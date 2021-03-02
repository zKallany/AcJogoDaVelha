package Principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Iniciar jogo? (S/N)");
        char resp = ler.next().toUpperCase().charAt(0);

        if(resp == 'S'){
            do{
                metodosJogo.game();
                System.out.println("Jogar novamente? (S/N)");
                resp = ler.next().toUpperCase().charAt(0);
            }while(resp == 'S');
        }
        ler.close();
    }
}
