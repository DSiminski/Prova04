package View;

import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class LivroView {
    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    LivroController livroController = new LivroController();

    public Livro cadastraLivro() {
        GeneroView generoView = new GeneroView();
        BibliotecaView bibliotecaView = new BibliotecaView();
        Livro livro = new Livro();

        System.out.println("Informe o nome do Livro: ");
        livro.setLivro(leitor.next());

        System.out.println("Selecione o Gênero que deseja:");
        Genero genero = generoView.selectById();
        livro.setGenero(genero);

        System.out.println("Selecione a Biblioteca:");
        Biblioteca biblioteca = bibliotecaView.selectById();
        livro.setBiblioteca(biblioteca);

        livroController.criaTabelaLivro();
        livroController.cadastraLivro(livro);

        return livro;
    }

    public void mostrarLivro() {
        System.out.println(livroController.listarLivros());
    }

    public Livro selectById () {
        this.mostrarLivro();

        System.out.println("Selecione Livro: ");
        int LiSelecionado = leitor.nextInt();

        Livro livro = livroController.selectById(LiSelecionado);

        System.out.println("O Livro selecionado foi: " + livro);

        return livro;
    }
    public void editarLivro(){
        Livro livro = new Livro();

        System.out.println("Escolha um Novo Livro:");
        livro.setLivro(leitor.next());
        livroController.editaLivro(livro);
    }
    public void menu() {
        Scanner leitor = new Scanner(System.in);
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Editar                 |");
                System.out.println("|        4 - Selecionar             |");
                System.out.println("|   5 - Selecionar por Gênero       |");
                System.out.println("|  6 - Selecionar por Biblioteca    |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 7);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastraLivro();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("7 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarLivro();
                    System.out.println("7 - Voltar");
                    op = leitor.nextInt();
                    break;
                case 3:
                    this.editarLivro();
                    System.out.println("7-Voltar");
                    op = leitor.nextInt();
                    break;
                case 4:
                    this.selectById();
                    System.out.println("7-Voltar");
                    op = leitor.nextInt();
                break;
                case 5:
                    this.listarLivrosGenero();
                    System.out.println("7-Voltar");
                    op = leitor.nextInt();
                    break;
                case 6:
                    this.listarLivrosBiblioteca();
                    System.out.println("7-Voltar");
                    op = leitor.nextInt();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("7 - Voltar");
                    op = leitor.nextInt();
                    break;
            }

        } while (op != 0);
    }
    public void listarLivrosGenero(){
        GeneroView generoView = new GeneroView();

        System.out.println("Selecione o Gênero:");
        System.out.println(livroController.listarLivroPeloGenero(generoView.selectById()));
    }
    public void listarLivrosBiblioteca(){
        BibliotecaView bibliotecaView = new BibliotecaView();

        System.out.println("Selecione a Biblioteca:");
        System.out.println(livroController.listarLivroPelaBiblioteca(bibliotecaView.selectById()));


    }
}

