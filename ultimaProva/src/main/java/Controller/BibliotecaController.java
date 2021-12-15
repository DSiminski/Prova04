package Controller;

import Dao.BibliotecaDao;
import Model.Biblioteca;

import java.util.List;

public class BibliotecaController {
    BibliotecaDao bibliotecaDao = new BibliotecaDao();

    public void criaTabelaBiblioteca(){
        bibliotecaDao.criaTabelaBiblioteca();
    }
    public void cadastraBiblioteca(Biblioteca biblioteca){
        bibliotecaDao.cadastraBiblioteca(biblioteca);
    }

    public List<Biblioteca>listarbiblioteca(){
        return bibliotecaDao.listarBiblioteca();
    }
    public Biblioteca SelectById(int id){
        return bibliotecaDao.SelectById(id);
    }
        }
