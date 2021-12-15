package Model;

public class Livro {
    private String livro;
    private int id;
    private Genero genero;
    private Biblioteca biblioteca;

    public Livro() {
    }

    public Livro(String livro, int id, Genero genero, Biblioteca biblioteca) {
        this.livro = livro;
        this.id = id;
        this.genero = genero;
        this.biblioteca = biblioteca;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "livro='" + livro + '\'' +
                ", id=" + id +
                ", genero=" + genero +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
