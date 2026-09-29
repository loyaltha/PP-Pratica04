package biblioteca;

public interface ItemEmprestavel {
    String getTitulo();
    boolean getDisponivel();
    void setDisponivel(boolean status);
}