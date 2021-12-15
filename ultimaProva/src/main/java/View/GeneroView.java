package View;

import Controller.GeneroController;
import Model.Genero;

import java.util.Locale;
import java.util.Scanner;

public class GeneroView {
    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    GeneroController generoController = new GeneroController();

    public Genero cadastraGenero() {

        Genero genero = new Genero();

        System.out.println("Informe o nome do Gênero: ");
        genero.setGenero(leitor.next());

        generoController.criaTabelaGenero();
        generoController.cadastraGenero(genero);
        return genero;
    }

    public void mostrarGenero() {
        System.out.println(generoController.listarGenero());
    }

    public Genero selectById () {
        this.mostrarGenero();

        System.out.println("Selecione Gênero: ");
        int GeSelecionado = leitor.nextInt();

        Genero genero = generoController.selectByGenero(GeSelecionado);

            System.out.println("O Gênero selecionado foi: " + genero);

        return genero;
    }
    public void editarGenero(){
       Genero genero = this.selectById();

        System.out.println("Escolha um Novo Gênero:");
        genero.setGenero(leitor.next());

        GeneroController generoController = new GeneroController();

        generoController.editaGenero(genero);

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
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastraGenero();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarGenero();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                     this.editarGenero();
                    System.out.println("5-Voltar");
                    op = leitor.nextInt();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;
            }

        } while (op != 0);
    }
}
