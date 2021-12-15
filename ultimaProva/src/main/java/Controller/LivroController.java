package Controller;

import Dao.LivroDao;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;

public class LivroController {
    LivroDao livroDao = new LivroDao();

    public void criaTabelaLivro(){
        livroDao.getcriaTabelaLivro();
    }
    public void cadastraLivro(Livro livro){
        livroDao.getcadastraLivro(livro);
    }
    public List<Livro> listarLivros(){
        return livroDao.listarLivro();
    }
    public Livro selectById(int id){
        return livroDao.selectById(id);
    }
    public void editaLivro(Livro livro){
        livroDao.editaLivro(livro);
    }
    public List<Livro> listarLivroPeloGenero(Genero generoSelecionado){
       return livroDao.listarLivroPeloGenero(generoSelecionado);
    }
    public List<Livro> listarLivroPelaBiblioteca(Biblioteca bibliotecaSelecionada){
        return livroDao.listarLivroPelaBiblioteca(bibliotecaSelecionada);
    }
}
