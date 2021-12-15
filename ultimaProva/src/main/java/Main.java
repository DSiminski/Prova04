import Model.Biblioteca;
import View.BibliotecaView;
import View.GeneroView;
import View.LivroView;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LivroView livroView = new LivroView();
        BibliotecaView bibliotecaView = new BibliotecaView();
        GeneroView generoView = new GeneroView();
        Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        int op = 0;
        do{
            System.out.println("-------------------------------------");
            System.out.println("|        0 - Sair                   |");
            System.out.println("|        1 - Biblioteca             |");
            System.out.println("|        2 - Gênero                 |");
            System.out.println("|        3 - Livros                 |");
            System.out.println("-------------------------------------");
            System.out.println("|     Digite aqui a sua opção:      |");
            System.out.println("-------------------------------------");
            op = leitor.nextInt();
        switch (op) {

            case 0:
                break;

            case 1:
                bibliotecaView.menu();
                System.out.println("7 - Voltar");
                op = leitor.nextInt();
                break;

            case 2:
                generoView.menu();
                System.out.println("7 - Voltar");
                op = leitor.nextInt();
                break;
            case 3:
                livroView.menu();
                System.out.println("7-Voltar");
                op = leitor.nextInt();
                break;

            default:
                System.out.println("Opção inválida");
                System.out.println("7 - Voltar");
                op = leitor.nextInt();
                break;
        }

        }while (op==0);
    }
}
