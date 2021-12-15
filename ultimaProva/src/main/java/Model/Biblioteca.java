package Model;

public class Biblioteca {
    private String biblioteca;
    private int idBiblioteca;

    public Biblioteca() {
    }

    public Biblioteca(String biblioteca, int idBiblioteca) {
        this.biblioteca = biblioteca;
        this.idBiblioteca = idBiblioteca;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    @Override
    public String toString() {
        return "BibliotecaModel{" +
                "Biblioteca='" + biblioteca + '\'' +
                ", idBiblioteca=" + idBiblioteca +
                '}';
    }
}
