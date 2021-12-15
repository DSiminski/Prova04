package Model;

public class Genero {
    private int Id;
    private String genero;

    public Genero() {
    }

    public Genero(int id, String genero) {
        Id = id;
        this.genero = genero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "Id=" + Id +
                ", genero='" + genero + '\'' +
                '}';
    }
}
