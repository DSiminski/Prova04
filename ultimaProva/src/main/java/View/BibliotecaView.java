package View;

import Controller.BibliotecaController;
import Model.Biblioteca;

import java.util.Locale;
import java.util.Scanner;

public class BibliotecaView {
    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    BibliotecaController bibliotecaController = new BibliotecaController();

    public Biblioteca cadastraBiblioteca() {

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Informe o nome da biblioteca: ");
        biblioteca.setBiblioteca(leitor.next());

        bibliotecaController.criaTabelaBiblioteca();
       bibliotecaController.cadastraBiblioteca(biblioteca);
        return biblioteca;
    }

    public void mostrarBiblioteca() {
        System.out.println(bibliotecaController.listarbiblioteca());
    }

    public Biblioteca selectById () {
        this.mostrarBiblioteca();

        System.out.println("Selecione Biblioteca: ");
        int BiSelecionada = leitor.nextInt();

        Biblioteca biblioteca = bibliotecaController.SelectById(BiSelecionada);

        System.out.println("A Biblioteca selecionada foi: " + biblioteca);

        return biblioteca;
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
                        this.cadastraBiblioteca();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarBiblioteca();
                    System.out.println("5 - Voltar");
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
