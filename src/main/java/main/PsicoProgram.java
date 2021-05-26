/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import static main.UI.AlocarPecas;
import psico.PsicoCampo;
import psico.PsicoExcecao;
import psico.PsicoPeca;
import psico.PsicoPosicao;
import psicopatologia.Psicopatologia;
import tratamento.Tratamento;

public class PsicoProgram {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        int j,l,k = 0;
        System.out.println("Bem vim ao Jogo de Informacao do Mundo psicológico\nDigite 1, 2 ou 3 para escolher os mapas");
        j = sc.nextInt();
       while(j != 0){
            if(j == 1){
                PsicoCampo psicoCampo1 = new PsicoCampo(j);
                UI.clearScreen();
                UI.printPsicoCampoMapa(psicoCampo1);
            
            }
            else if(j == 2){
                PsicoCampo psicoCampo2 = new PsicoCampo(j);
                UI.clearScreen();
                UI.printPsicoCampoMapa(psicoCampo2);
            
            } 
            else{
                PsicoCampo psicoCampo3 = new PsicoCampo(j);
                UI.clearScreen();
                UI.printPsicoCampoMapa(psicoCampo3);
            }
            k = j;
            sc.nextLine();
                    
            j = sc.nextInt();
        }
        System.out.println(k);
        PsicoCampo psicoCampo = new PsicoCampo(k);
        AlocarPecas(psicoCampo);
        while(psicoCampo.getTurno() != 0 || psicoCampo.getTratamentoLife() == 0 || psicoCampo.VivoOuMorto()){
            try{
                UI.clearScreen();
                UI.printPsicoCampo(psicoCampo);
                System.out.println();
                UI.printTratamento(psicoCampo);
                System.out.println("Digite 1 para mover ou 2 para atacar");
                l = sc.nextInt();
                if(l == 1){
                    System.out.print("Source: \n");
                    sc.nextLine();
                    PsicoPosicao source = UI.lerPsicoPosicao(sc);
                    
                    boolean[][] possibleMoves = psicoCampo.PossiveisMovimentos(source);
                    UI.clearScreen();
                    UI.printLife(source, psicoCampo);
                    UI.printQuadro(psicoCampo.getPecas(), possibleMoves);                    
                    System.out.println();
                    UI.printLife(source, psicoCampo);
                    System.out.print("Target: ");
                    PsicoPosicao target = UI.lerPsicoPosicao(sc);
                    UI.printLife(target, psicoCampo);
                    PsicoPeca capturedPiece = psicoCampo.performMove(source, target);
                    psicoCampo.proximoTurno();
                }else{
                    System.out.print("Source: ");
                    sc.nextLine();
                    PsicoPosicao source = UI.lerPsicoPosicao(sc);
                    UI.printLife(source, psicoCampo);
                    PsicoPeca p = (PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao());
                    boolean[][] possivelAtaque = p.possivelAtaque();
                    UI.clearScreen();
                    UI.printQuadro(psicoCampo.getPecas(), possivelAtaque);
                    System.out.println();
                    System.out.print("Target: ");
                    PsicoPosicao target = UI.lerPsicoPosicao(sc);
                    UI.printLife(target, psicoCampo);
                    if((PsicoPeca)(psicoCampo.getQuadro().peca(target.toPosicao())) instanceof Psicopatologia){
                       ((Psicopatologia)((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(target.toPosicao()))).setResistencia(
                        ((((Tratamento)(PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao()))).tratar()));
                       if(((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(target.toPosicao())).getResistencia() == 0){
                           (psicoCampo).getQuadro().removerPeca(target.toPosicao());
                       }
                    }else if((PsicoPeca)(psicoCampo.getQuadro().peca(target.toPosicao())) instanceof Tratamento){
                        psicoCampo.setTratamentoLife(((Tratamento)((Tratamento)(PsicoPeca)psicoCampo.getQuadro().peca(target.toPosicao()))).getBloqueio(
                        (((Psicopatologia)((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao())))).getSeveridade()));
                    }
                    
                    psicoCampo.proximoTurno();
                }
            }
            catch(PsicoExcecao e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            
            
        }
        sc.close();
        b.close();
    }
}

    

