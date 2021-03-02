package Principal;

import java.util.Scanner;

public class metodosJogo {

    public static char[][] initialize() {
        char[][] matriz = new char[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = ' ';
            }
        }
        return matriz;
    }

    public static void mostrar(char matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            if (i > 0 && i < 3) {
                System.out.println();
                System.out.println("______");
            }
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
                if (j < matriz.length - 1) {
                    System.out.print("|");
                }
            }
        }
    }

    public static boolean step(char matriz[][], int lin, int col, char Jogador) {

        boolean inserir = false;

        if (matriz[lin][col] == ' ') {
            inserir = true;
            matriz[lin][col] = Jogador;
        }
        return inserir;
    }

    public static int digitarLinha() {
        Scanner ler = new Scanner(System.in);

        System.out.println("\nDigite a linha de sua jogada. (0 a 2) ");
        int lin = ler.nextInt();
        while (lin > 2 || lin < 0) {
            System.out.println("Digite uma Casa Disponivel!");
            System.out.println("\nDigite a linha de sua jogada. (0 a 2) ");
            lin = ler.nextInt();
        }
        return lin;
    }

    public static int digitarColuna() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a coluna de sua jogada. (0 a 2)");
        int col = ler.nextInt();
        while (col > 2 || col < 0) {
            System.out.println("Digite uma Casa Disponivel!");
            System.out.println("Digite a coluna de sua jogada. (0 a 2) ");
            col = ler.nextInt();
        }
        return col;
    }

    public static int status(char matriz[][]) {
        int resp = 15;
        if (ganhar(matriz, 'O') == 'O') {
            resp = 1;
        } else if (ganhar(matriz, 'X') == 'X') {
            resp = 2;
        }
        if (matrizCompleta(matriz) == true && resp != 1 && resp != 2) {
            resp = 0;
        }
        if (matrizCompleta(matriz) == false && resp != 1 && resp != 2) {
            resp = -1;
        }
        switch (resp) {
            case 0:
                System.out.println("\n\nEmpate!");
                break;
            case 1:
                System.out.println("\n\nJogador O ganhou!");
                break;
            case 2:
                System.out.println("\n\nJogador X ganhou!");
                break;
        }
        return resp;
    }

    public static char ganhar(char matriz[][], char jogador) {
        char statusVitoria = ' ';
        for (int i = 0; i < matriz.length; i++) {
            if ((matriz[i][0] == jogador && matriz[i][1] == jogador && matriz[i][2] == jogador)
                    || (matriz[0][i] == jogador && matriz[1][i] == jogador && matriz[2][i] == jogador)) {
                statusVitoria = jogador;
            }
        }
        int contagem = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    if (matriz[i][j] == jogador) {
                        contagem += 1;
                    }
                }
            }
            if (contagem == 3) {
                statusVitoria = jogador;
            }
        }
        if (matriz[0][2] == jogador && matriz[1][1] == jogador && matriz[2][0] == jogador) {
            statusVitoria = jogador;
        }
        return statusVitoria;
    }

    public static boolean matrizCompleta(char Matriz[][]) {
        boolean resp;
        int contagem = 0;
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                if (Matriz[i][j] != ' ') {
                    contagem += 1;
                }
            }
        }
        if (contagem == 9) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    public static void game() {

        char Matriz[][] = metodosJogo.initialize();
        char player = 'Q';
        System.out.println();
        mostrar(Matriz);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                player = 'O';
            } else {
                player = 'X';
            }
            System.out.print("\n\nVez do jogador: " + player);

            boolean bool = step(Matriz, metodosJogo.digitarLinha(), metodosJogo.digitarColuna(), player);
            if (bool == false) {
                do {
                    System.out.print("\nDigite um campo valido!");
                    bool = step(Matriz, metodosJogo.digitarLinha(), metodosJogo.digitarColuna(), player);
                } while (bool == false);
            }
            System.out.println();
            mostrar(Matriz);
            int x = status(Matriz);

            if (x == 1 || x == 2 || x == 0) {
                break;
            }
        }
    }
}
