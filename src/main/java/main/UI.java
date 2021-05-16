/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.InputMismatchException;
import java.util.Scanner;
import psico.Cor;
import psico.PsicoCampo;
import psico.PsicoPeca;
import psico.PsicoPosicao;

/**
 *
 * @author lelo0
 */
public class UI {
        public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static PsicoPosicao lerPsicoPosicao(Scanner sc){
        try{;
            String s = sc.nextLine();
            char coluna = s.charAt(0);
            int linha = Integer.parseInt(s.substring(1));
            return new PsicoPosicao(coluna, linha);
        }
        catch(RuntimeException e){
            throw new InputMismatchException("Error reading ChessPosition");
        }
    }
    
    public static void printPsicoCampo(PsicoCampo psicoCampo){
        printQuadro(psicoCampo.getPecas());
        System.out.println();
        System.out.println("Turn : " + psicoCampo.getTurno());
        System.out.println("Waiting player: " + psicoCampo.getAtualPlayer());
    }
    public static void printPsicoCampoMapa(PsicoCampo psicoCampo){
        printQuadro(psicoCampo.getPecas());
        System.out.println();
        System.out.println("Turn : " + psicoCampo.getTurno());
        System.out.println("Waiting player: " + psicoCampo.getAtualPlayer());
    }
    public static void printQuadro(PsicoPeca[][] pecas){
        for(int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for(int j = 0; j < pecas.length; j++){
                printPeca(pecas[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    
    
    public static void printQuadro(PsicoPeca[][] pecas, boolean[][]possivelMovimento){
        for(int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");
            for(int j = 0; j < pecas.length; j++){
                printPeca(pecas[i][j], possivelMovimento[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    private static void printPeca(PsicoPeca peca,boolean background) {
    	if(background){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (peca.getCor() == Cor.WHITE) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else if(peca.getCor() == Cor.GREEN){
                System.out.print(ANSI_GREEN + peca + ANSI_RESET);
            }
            else{
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
}