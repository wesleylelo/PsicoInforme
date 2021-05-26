/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.InputMismatchException;
import java.util.Scanner;
import static psico.Cor.WHITE;
import psico.PsicoCampo;
import psico.PsicoPeca;
import psico.PsicoPosicao;
import psicopatologia.Ansiedade;
import psicopatologia.Depressao;
import psicopatologia.Esquizofrenia;
import psicopatologia.Psicopatologia;
import tratamento.AtividadeFisica;
import tratamento.Medicacao;
import tratamento.Meditacao;
import tratamento.Terapia;
import tratamento.Tratamento;

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
        try{
            
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
            if (null == peca.getCor()) {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
            else switch (peca.getCor()) {
                    case WHITE -> System.out.print(ANSI_WHITE + peca + ANSI_RESET);
                    case GREEN -> System.out.print(ANSI_GREEN + peca.toString() + ANSI_RESET);
                    default -> System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
                }
        }
        System.out.print(" ");
	}
    
    public static PsicoCampo AlocarPecas(PsicoCampo psicoCampo1){
        int n,m,h = 4;
        String s;
        Scanner sc = new Scanner(System.in);
            UI.clearScreen();
            UI.printPsicoCampoMapa(psicoCampo1);
            if(psicoCampo1.getAtualPlayer() == WHITE)
                System.out.println("TRATAMENTO, SEU LADO E O INFERIOR");
            else
                System.out.println("PSICOPATOLOGIA, SEU LADO E O SUPERIOR");
        if(psicoCampo1.getAtualPlayer() == WHITE){
            while(h != 0){
                
                System.out.println("Tratamento: \nDigite 1 - Atividade Fisica 2 - Medicacao 3 - Meditacao 4 - Terapia");            
                
                m = sc.nextInt();
                sc.nextLine();
                switch (m) {
                    case 1 ->                         {
                            Tratamento atvFisica = new AtividadeFisica(psicoCampo1.getQuadro());
                            ((AtividadeFisica)atvFisica).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(atvFisica,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 2 ->                         {
                            Tratamento medicacao = new Medicacao(psicoCampo1.getQuadro());
                            ((Medicacao)medicacao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(medicacao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 3 ->                         {
                            Tratamento meditacao = new Meditacao(psicoCampo1.getQuadro());
                            ((Meditacao)meditacao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(meditacao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 4 ->                         {
                            Tratamento terapia = new Terapia(psicoCampo1.getQuadro());
                            ((Terapia)terapia).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(terapia,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    default -> {
                        System.out.println("Digite novamente");
                        continue;
                    }
                }
            }
                h = 3;
                psicoCampo1.proximaAlocacao();
            while(h != 0){
                System.out.println("Psicopatologia: \nDigite 1 - Ansiedade 2 - Depressao 3 - Esquizofrenia");
                
                n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1 ->                         {
                            Psicopatologia ansiedade = new Ansiedade(psicoCampo1.getQuadro());
                            ((Ansiedade)ansiedade).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(ansiedade,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 2 ->                         {
                            Psicopatologia depressao = new Depressao(psicoCampo1.getQuadro());
                            ((Depressao)depressao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(depressao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 3 ->                         {
                            Psicopatologia esquizofrenia = new Esquizofrenia(psicoCampo1.getQuadro());
                            ((Esquizofrenia)esquizofrenia).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(esquizofrenia,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    default -> {
                        System.out.println("Digite novamente");
                        continue;
                    }
                }
            }
        } 
        else{ 
            h = 3;
            while(h != 0){               
                System.out.println("Digite 1 - Ansiedade 2 - Depressao 3 - Esquizofrenia");
                m = sc.nextInt();
                sc.nextLine();
                switch (m) {
                    case 1 ->                         {
                            Psicopatologia ansiedade = new Ansiedade(psicoCampo1.getQuadro());
                            ((Ansiedade)ansiedade).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(ansiedade,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 2 ->                         {
                            Psicopatologia depressao = new Depressao(psicoCampo1.getQuadro());
                            ((Depressao)depressao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(depressao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 3 ->                         {
                            Psicopatologia esquizofrenia = new Esquizofrenia(psicoCampo1.getQuadro());
                            ((Esquizofrenia)esquizofrenia).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(esquizofrenia,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    default -> {
                        System.out.println("Digite novamente");
                        continue;
                    }
                }
                }
                psicoCampo1.proximaAlocacao();
                h = 4;
                while(h != 0){
                    System.out.println("Tratamento: \nDigite 1 - Atividade Fisica 2 - Medicacao 3 - Meditacao 4 - Terapia");            
                    
                    n = sc.nextInt();
                    sc.nextLine();
                switch (n) {
                    case 1 ->                         {
                            Tratamento atvFisica = new AtividadeFisica(psicoCampo1.getQuadro());
                            ((AtividadeFisica)atvFisica).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(atvFisica,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 2 ->                         {
                            Tratamento medicacao = new Medicacao(psicoCampo1.getQuadro());
                            ((Medicacao)medicacao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(medicacao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 3 ->                         {
                            Tratamento meditacao = new Meditacao(psicoCampo1.getQuadro());
                            ((Meditacao)meditacao).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(meditacao,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    case 4 ->                         {
                            Tratamento terapia = new Terapia(psicoCampo1.getQuadro());
                            ((Terapia)terapia).Informativo();
                            System.out.println("Digite uma letra e um número");
                            char letra = sc.next().charAt(0);
                            sc.nextLine();
                            int w = sc.nextInt();
                            sc.nextLine();
                            PsicoPosicao posicao = new PsicoPosicao(letra, w);
                            psicoCampo1.getQuadro().locarPeca(terapia,posicao.toPosicao(), psicoCampo1);
                            UI.clearScreen();
                            UI.printPsicoCampoMapa(psicoCampo1);
                            h--;
                        }
                    default -> {
                        System.out.println("Digite novamente");
                        continue;
                    }
                }
                }
            }
        return psicoCampo1;
    }
    public static void printLife(PsicoPosicao p,PsicoCampo psicoCampo){
        if((PsicoPeca)psicoCampo.getQuadro().peca(p.toPosicao()) instanceof Psicopatologia psicopatologia){
            System.out.println("\n Life desta peca: " + ((Psicopatologia)psicopatologia).getResistencia());
        }
        else{
            printTratamento(psicoCampo);
        }
    }
    public static void printTratamento(PsicoCampo p){
        System.out.println("\n Tratamento, seu Life e: " + p.getTratamentoLife());
    }
}
