/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import psico.PsicoCampo;

public class PsicoProgram {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j;
        System.out.println("Bem vim ao Jogo de Informacao do Mundo psicológico\nDigite 1, 2 ou 3 para escolher os mapas");
        j = sc.nextInt();
        while(j != 0){
        if(j == 1){
            PsicoCampo psicoCampo1 = new PsicoCampo(1);
            UI.clearScreen();
            UI.printPsicoCampoMapa(psicoCampo1);
        }
        else if(j == 2){
            PsicoCampo psicoCampo2 = new PsicoCampo(2);
            UI.clearScreen();
            UI.printPsicoCampoMapa(psicoCampo2);
        } 
        else{
            PsicoCampo psicoCampo3 = new PsicoCampo(3);
            UI.clearScreen();
            UI.printPsicoCampoMapa(psicoCampo3);
        }
        j = sc.nextInt();
        }
        System.out.println("Escolha um Lado, digite 1 para Inferior, 2 para superior");
        while(true){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);;
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}

    
}
