package Controller;

import Dao.GeneroDao;
import Model.Genero;
import View.GeneroView;

import java.util.List;

public class GeneroController {
    GeneroDao generoDao = new GeneroDao();

    public void criaTabelaGenero(){
        generoDao.criaTabelaGenero();
    }
    public void cadastraGenero(Genero genero){
        generoDao.cadastraGenero(genero);
    }
    public List<Genero> listarGenero(){
        return generoDao.listarGenero();
    }
    public Genero selectByGenero (int id){
        return generoDao.selectByGenero(id);
    }
    public void editaGenero(Genero genero){
        generoDao.editaGenero(genero);
    }
}
