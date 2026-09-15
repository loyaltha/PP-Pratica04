package biblioteca;

public class Emprestimo implements Imprimivel {
    private Usuario usuario;
    private Livro livro;
    private boolean ativo;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.ativo = true;
    }

    // Método responsável por mediar o aluguel
    public static Emprestimo registrar(Usuario usuario, Livro livro) {
        if (usuario.getEmprestimoAtivo() != null) {
            System.out.println(usuario.getNome() + " já possui o livro '" + usuario.getEmprestimoAtivo().getLivro().getTitulo() + "' em mãos.");
            return null;
        }
        if (!livro.getDisponivel()) {
            System.out.println("O livro '" + livro.getTitulo() + "' não está disponível no momento.");
            return null;
        }

        livro.setDisponivel(false);
        Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
        usuario.setEmprestimoAtivo(novoEmprestimo);

        System.out.println(usuario.getNome() + " alugou o livro: " + livro.getTitulo());
        System.out.println("Prazo para devolução: " + usuario.obterDiasDevolucao() + " dias.");
        return novoEmprestimo;
    }

    // Método responsável por mediar a renovação
    public boolean renovar() {
        if (!this.ativo) {
            return false;
        }
        System.out.println(usuario.getNome() + " RENOVOU o livro: " + livro.getTitulo());
        System.out.println("Novo prazo para devolução: " + usuario.obterDiasDevolucao() + " dias a partir de hoje.");
        return true;
    }

    // Método responsável por mediar a devolução
    public void finalizar() {
        if (!this.ativo) {
            System.out.println("Este empréstimo já foi encerrado.");
            return;
        }
        this.livro.setDisponivel(true);
        this.usuario.setEmprestimoAtivo(null);
        this.ativo = false;
        System.out.println(this.usuario.getNome() + " devolveu o livro: " + this.livro.getTitulo());
    }

    @Override
    public void imprimirDados() {
        System.out.println("EMPRÉSTIMO | Usuário: " + usuario.getNome() + 
                           " | Livro: " + livro.getTitulo() + 
                           " | Status Ativo: " + (ativo ? "Sim" : "Não"));
    }

    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public boolean isAtivo() { return ativo; }
}