package biblioteca;

public interface ItemEmprestavel extends ItemAcervo{
    boolean getDisponivel();
    void setDisponivel(boolean status);
}