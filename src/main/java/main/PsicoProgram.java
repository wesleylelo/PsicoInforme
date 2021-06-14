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
import psicopatologia.Ansiedade;
import psicopatologia.Depressao;
import psicopatologia.Esquizofrenia;
import psicopatologia.Psicopatologia;
import tratamento.AtividadeFisica;
import tratamento.Medicacao;
import tratamento.Meditacao;
import tratamento.Terapia;
import tratamento.Tratamento;

public class PsicoProgram {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        int j,l,k = 0;
        String ler;
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
        while(psicoCampo.getTurno() != 0){
        do{
            try{
                UI.clearScreen();
                UI.printPsicoCampo(psicoCampo);
                System.out.println();
                UI.printTratamento(psicoCampo);
                System.out.println("Digite 1 para mover ou 2 para atacar");
                l = sc.nextInt();
                if(l == 1){
                    System.out.println("Source: ");
                    sc.nextLine();
                    ler = sc.nextLine();
                    PsicoPosicao source = UI.lerPsicoPosicao(ler);   
                    boolean[][] possibleMoves = psicoCampo.PossiveisMovimentos(source);
                    UI.clearScreen();                   
                    System.out.println();
                    System.out.println("Target: ");
                    
                    ler = sc.nextLine();
                    PsicoPosicao target = UI.lerPsicoPosicao(ler);
                    UI.printQuadro(psicoCampo.getPecas(), possibleMoves); 
                    UI.printLife(target, psicoCampo);
                    psicoCampo.performMove(source, target);
                    psicoCampo.proximoTurno();
                }else{
                    System.out.println("Source: ");
                    sc.nextLine();
                    ler = sc.nextLine();
                    PsicoPosicao source = UI.lerPsicoPosicao(ler);
                    UI.printLife(source, psicoCampo);
                    PsicoPeca p = (PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao());
                    boolean[][] possivelAtaque = p.possivelAtaque();
                    UI.clearScreen();
                    System.out.println();
                    
                    System.out.println("Target: ");
                    
                    ler = sc.nextLine();
                    PsicoPosicao target = UI.lerPsicoPosicao(ler);
                    UI.printLife(target, psicoCampo);
                    if((PsicoPeca)(psicoCampo.getQuadro().peca(target.toPosicao())) instanceof Psicopatologia){
                       ((Psicopatologia)((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(target.toPosicao()))).setResistencia(
                        ((((Tratamento)(PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao()))).tratar()));
                       if(((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(target.toPosicao())).getResistencia() == 0){
                           (psicoCampo).getQuadro().removerPeca(target.toPosicao());
                       }
                    }else if((PsicoPeca)(psicoCampo.getQuadro().peca(target.toPosicao())) instanceof Tratamento){
                        psicoCampo.setTratamentoLife(
                        ((Psicopatologia)((Psicopatologia)(PsicoPeca)psicoCampo.getQuadro().peca(source.toPosicao()))).getSeveridade()*1.0);
                    } 
                    
                    psicoCampo.proximoTurno();
                }
            }
            catch(PsicoExcecao e){
                System.out.println(e.getMessage());
               
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());

            }
            
            
        }while(psicoCampo.getTurno() != 0 && psicoCampo.getTratamentoLife() > 0);
        
        if(psicoCampo.getTurno() == 0 && psicoCampo.getTratamentoLife() != 0 && psicoCampo.VivoOuMorto()){
           System.out.println("Deseja jogar mais? Adicione mais turnos "); 
           int ç;
           ç = sc.nextInt();
           psicoCampo.setTurno(ç); 
           continue;
        } else if( psicoCampo.getTratamentoLife() == 0){
           System.out.println("Que pena que Psicopatologia ganhou, :C \n" 
                   + "Importante saber seu inimigo, segue alguns informes:"
                   + Ansiedade.Informativo()
                   + Depressao.Informativo()
                   + Esquizofrenia.Informativo()
           ); 
        } else{
            System.out.println("Isso aí, você conheceu bem seus benefícios\n" 
                   + "Segue alguns informes:"
                   + AtividadeFisica.Informativo()
                   + Medicacao.Informativo()
                   + Meditacao.Informativo()
                   + Terapia.Informativo()
           ); 
        }
        sc.close();
        b.close();
    }
   }   
  }


    

