package Dao;

import ConnectionFactory.ConnectionFactory;
import Model.Biblioteca;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDao {
    public Connection connection;

    public BibliotecaDao(){
        this.connection = ConnectionFactory.getConection();

    }
    public void criaTabelaBiblioteca(){
        String sql = "CREATE TABLE IF NOT EXISTS biblioteca (" +
                "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                "biblioteca VARCHAR (50) NOT NULL);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cadastraBiblioteca(Biblioteca biblioteca){
    String sql = "INSERT INTO biblioteca " +
            "(biblioteca) " +
            "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, biblioteca.getBiblioteca());
            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            while(resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Biblioteca> listarBiblioteca(){
        String sql = "SELECT * FROM biblioteca";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Biblioteca> listaDeBibliotecas = new ArrayList<>();

            while (resultSet.next()) {

                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setBiblioteca(resultSet.getString("biblioteca"));
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));


                listaDeBibliotecas.add(biblioteca);
            }

            return listaDeBibliotecas;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public Biblioteca SelectById(int id){
        String sql = "SELECT * FROM biblioteca WHERE idBiblioteca = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                Biblioteca biblioteca = new Biblioteca();

                biblioteca.setBiblioteca(resultSet.getString( "biblioteca"));
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));

                return biblioteca;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    }


