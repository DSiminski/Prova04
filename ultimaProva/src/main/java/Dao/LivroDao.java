package Dao;

import ConnectionFactory.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {
    private Connection connection;

    public LivroDao() {
        this.connection = ConnectionFactory.getConection();
    }

    public void getcriaTabelaLivro() {
        String sql = "CREATE TABLE IF NOT EXISTS livro (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "livro VARCHAR(50) NOT NULL," +
                "idGenero INT," +
                "idBiblioteca INT," +
                "FOREIGN KEY (idGenero) REFERENCES genero(id)," +
                "FOREIGN KEY (idBiblioteca) REFERENCES biblioteca(idBiblioteca));";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getcadastraLivro(Livro livro) {
        String sql = "INSERT INTO livro" +
                "(livro,idGenero,idBiblioteca)" +
                "VALUES  (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, livro.getLivro());
            stmt.setInt(2,livro.getGenero().getId());
            stmt.setInt(3,livro.getBiblioteca().getIdBiblioteca());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            while (resultSet.next()) {
                livro.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivro() {
        String sql = "SELECT * FROM livro";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Livro> listaDeLivros= new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();

                livro.setLivro(resultSet.getString( "Livro"));
                livro.setId(resultSet.getInt("Id"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.selectByGenero(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.SelectById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Livro selectById(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                Livro livro = new Livro();

                livro.setLivro(resultSet.getString( "livro"));
                livro.setId(resultSet.getInt("id"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.selectByGenero(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.SelectById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                return livro;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void editaLivro(Livro livro) {
        String sql = "UPDATE livro SET livro = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, livro.getLivro());
            stmt.setInt(2, livro.getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Livro> listarLivroPeloGenero(Genero generoSelecionado) {
        String sql = "SELECT * FROM livro WHERE idGenero = ? ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,generoSelecionado.getId());
            ResultSet resultSet = stmt.executeQuery();

            List<Livro> listaDeLivros= new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();

                livro.setLivro(resultSet.getString( "Livro"));
                livro.setId(resultSet.getInt("Id"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.selectByGenero(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.SelectById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Livro> listarLivroPelaBiblioteca(Biblioteca bibliotecaSelecionada) {
        String sql = "SELECT * FROM livro WHERE idBiblioteca = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,bibliotecaSelecionada.getIdBiblioteca());

            ResultSet resultSet = stmt.executeQuery();

            List<Livro> listaDeLivros= new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();

                livro.setLivro(resultSet.getString( "Livro"));
                livro.setId(resultSet.getInt("Id"));

                GeneroDao generoDao = new GeneroDao();
                Genero genero = generoDao.selectByGenero(resultSet.getInt("idGenero"));
                livro.setGenero(genero);

                BibliotecaDao bibliotecaDao = new BibliotecaDao();
                Biblioteca biblioteca = bibliotecaDao.SelectById(resultSet.getInt("idBiblioteca"));
                livro.setBiblioteca(biblioteca);

                listaDeLivros.add(livro);
            }

            return listaDeLivros;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}





