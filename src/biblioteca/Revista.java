package biblioteca;

public class Revista implements Imprimivel, ItemEmprestavel {
    private String titulo;
    private int edicao;
    private boolean disponivel = true;

    public Revista(String titulo, int edicao) {
        this.titulo = titulo;
        this.edicao = edicao;
        System.out.println("Revista '" + this.titulo + "' cadastrada no sistema.");
    }


}