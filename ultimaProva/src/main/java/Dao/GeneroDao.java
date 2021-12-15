package Dao;

import ConnectionFactory.ConnectionFactory;
import Controller.GeneroController;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    private Connection connection;

    public GeneroDao(){
        this.connection = ConnectionFactory.getConection();
    }
    public void criaTabelaGenero() {
        String sql = "CREATE TABLE IF NOT EXISTS genero (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "genero VARCHAR(50) NOT NULL);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela criada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro identificado");
        }
    }

    public void cadastraGenero(Genero genero) {
        String sql = "INSERT INTO genero " +
                "(genero) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,genero.getGenero());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while(resultSet.next()) {
                genero.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genero> listarGenero() {
        String sql = "SELECT * FROM genero";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Genero> listaDeGeneros = new ArrayList<>();

            while(resultSet.next()) {
    Genero genero = new Genero();
                genero.setGenero(resultSet.getString("genero"));
                genero.setId(resultSet.getInt("id"));

                listaDeGeneros.add(genero);
            }

            return listaDeGeneros;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Genero selectByGenero(int id) {
        String sql = "SELECT * FROM genero WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
            Genero genero = new Genero();
                genero.setGenero(resultSet.getString("genero"));
                genero.setId(resultSet.getInt("id"));

                return genero;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void editaGenero(Genero genero) {
        String sql = "UPDATE genero SET genero = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, genero.getGenero());
            stmt.setInt(2, genero.getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }


