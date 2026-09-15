package biblioteca;

public abstract class Usuario implements Imprimivel {
    protected String nome;
    private Emprestimo emprestimoAtivo; // Associação indireta através do mediador

    public Usuario(String nome) {
        this.nome = nome;
    }

    public abstract int obterDiasDevolucao();

    // Delega a ação de alugar para o mediador Emprestimo
    public boolean alugar(Livro livro) {
        Emprestimo emp = Emprestimo.registrar(this, livro);
        return emp != null; // Se retornou um objeto, o aluguel deu certo
    }

    // Sobrecarga do método alugar delegando para o mediador
    public boolean alugar(Livro livro, boolean renovacao) {
        if (renovacao) {
            if (this.emprestimoAtivo == null || !this.emprestimoAtivo.getLivro().equals(livro)) {
                System.out.println(this.nome + " não pode renovar um livro que não está em sua posse.");
                return false;
            }
            return this.emprestimoAtivo.renovar();
        } else {
            return this.alugar(livro); 
        }
    }

    // Delega a devolução para o mediador
    public void devolver() {
        if (this.emprestimoAtivo == null) {
            System.out.println(this.nome + " não tem nenhum livro para devolver.");
            return;
        }
        this.emprestimoAtivo.finalizar();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Emprestimo getEmprestimoAtivo() { return emprestimoAtivo; }
    public void setEmprestimoAtivo(Emprestimo emprestimoAtivo) { this.emprestimoAtivo = emprestimoAtivo; }
}