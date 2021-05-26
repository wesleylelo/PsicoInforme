/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psico;

import com.mycompany.psicoinfo.Peca;
import com.mycompany.psicoinfo.Posicao;
import com.mycompany.psicoinfo.Quadro;
import java.util.Random;
import static psico.Cor.WHITE;
import static psico.Cor.YELLOW;
import psicopatologia.Ansiedade;
import psicopatologia.Depressao;
import psicopatologia.Esquizofrenia;
import psicopatologia.Psicopatologia;

/**
 *
 * @author lelo0
 */
public class PsicoCampo {
    private int turno;
    private int selectMap;
    private Cor atualPlayer;
    private Quadro quadro;
    private Double tratamentoLife;

    
    public PsicoCampo(int selectMap){
        quadro = new Quadro(8,8);
        turno = 10;
        tratamentoLife = 100.0;
        this.selectMap = selectMap;
        Random m = new Random();
        int h = m.nextInt(2) + 1;
        if(h == 1)
          atualPlayer = WHITE;
        else
            atualPlayer = YELLOW;
        if(selectMap == 1){
            initialSetup1();
        } else if(selectMap == 2){
            initialSetup2();
        } else{
            initialSetup3();
        }
 
    }
    public void setSelectMap(int selectMap) {
        this.selectMap = selectMap;
    }

    public Quadro getQuadro() {
        return quadro;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    public Double getTratamentoLife() {
        return tratamentoLife;
    }

    public void setTratamentoLife(Double dano) {
        this.tratamentoLife = tratamentoLife - dano;
    }
    public int getTurno(){
        return turno;
    }
    public void setTurno(int turno){
        this.turno = turno;
    }
    
    public Cor getAtualPlayer(){
        return atualPlayer;
    }
    public PsicoPeca[][] getPecas(){
        PsicoPeca[][] mat = new PsicoPeca[quadro.getLinhas()][quadro.getColunas()];
        for(int i = 0; i < quadro.getLinhas(); i++){
            for(int j = 0; j < quadro.getColunas(); j++){
                mat[i][j] = (PsicoPeca) quadro.peca(i, j);
            }
        }
        return mat;
    }
    
    public boolean VivoOuMorto(){

        PsicoPeca[][] mat = new PsicoPeca[quadro.getLinhas()][quadro.getColunas()];
        for(int i = 4; i < quadro.getLinhas(); i++){
            for(int j = 0; j < quadro.getColunas(); j++){
                mat[i][j] = (PsicoPeca) quadro.peca(i, j);
                mat[i][j] = (Psicopatologia)mat[i][j];
                if(((Psicopatologia)mat[i][j]).getResistencia() == 0)
                    continue;
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean [][] PossiveisMovimentos(PsicoPosicao origemPosicao){
        Posicao posicao = origemPosicao.toPosicao();
        validarOrigemPosicao(posicao);
        return quadro.peca(posicao).possivelMovimento();
    }
    public PsicoPeca performMove(PsicoPosicao origemPosicao, PsicoPosicao targetPosicao){
        Posicao origem = origemPosicao.toPosicao();
        Posicao target = targetPosicao.toPosicao();
        validarOrigemPosicao(origem);
        validarTargetPosicao(origem, target);
        Peca capturadoPeca = makeMove(origem,target);
        return (PsicoPeca)capturadoPeca;
    }/*Mudar entender melhor*/
    private Peca makeCapture( Posicao target){
        Peca capturadoPeca = quadro.removerPeca(target);
        return capturadoPeca;
    }
    private Peca makeMove(Posicao origem, Posicao target){
        Peca p = quadro.removerPeca(origem);
        quadro.locarPeca(p, target);
        return p;
    }
    private void validarOrigemPosicao(Posicao posicao){
        if(!quadro.existeEUmaPeca(posicao)){
            throw new PsicoExcecao("There is no piece on source position");
        }
        if(atualPlayer != ((PsicoPeca)(quadro.peca(posicao))).getCor()){
            throw new PsicoExcecao("The chosen piece is not yours");
        }
        if(!quadro.peca(posicao).temAlgumMovimentoPossivel()){
            throw new PsicoExcecao("There is no possible for the chosen piece");
        }
    }/*Rever*/
    public void validarTargetPosicao(Posicao origem, Posicao target){
       if(!quadro.peca(origem).possivelMovimento(target)){
           throw new PsicoExcecao("The chosen piece can't move to target position");
       } 
    }
    
    public void proximoTurno(){
        turno--;
        if(atualPlayer == Cor.WHITE){
            atualPlayer = YELLOW;
        } else if(atualPlayer == Cor.YELLOW){
            atualPlayer = WHITE;
        }
    }
    public void proximaAlocacao(){
        
        if(atualPlayer == Cor.WHITE){
            atualPlayer = YELLOW;
        } else if(atualPlayer == Cor.YELLOW){
            atualPlayer = WHITE;
        }
    }
    private void locarNovaPeca(char coluna, int linha, PsicoPeca peca){
        quadro.locarPeca(peca, new PsicoPosicao(coluna, linha).toPosicao());
    }
    private void initialSetup1(){
        locarNovaPeca('c', 5, new Obstaculo(quadro));
        locarNovaPeca('e', 5, new Obstaculo(quadro));
        locarNovaPeca('g', 5, new Obstaculo(quadro));
        locarNovaPeca('c', 4, new Obstaculo(quadro));
        locarNovaPeca('e', 4, new Obstaculo(quadro));
        locarNovaPeca('g', 4, new Obstaculo(quadro));
    }
    
    private void initialSetup2(){
        locarNovaPeca('c', 6, new Obstaculo(quadro));
        locarNovaPeca('e', 6, new Obstaculo(quadro));
        locarNovaPeca('g', 6, new Obstaculo(quadro));
        locarNovaPeca('c', 3, new Obstaculo(quadro));
        locarNovaPeca('e', 3, new Obstaculo(quadro));
        locarNovaPeca('g', 3, new Obstaculo(quadro));
    }
    private void initialSetup3(){
        locarNovaPeca('c', 7, new Obstaculo(quadro));
        locarNovaPeca('e', 7, new Obstaculo(quadro));
        locarNovaPeca('g', 7, new Obstaculo(quadro));
        locarNovaPeca('c', 2, new Obstaculo(quadro));
        locarNovaPeca('e', 2, new Obstaculo(quadro));
        locarNovaPeca('g', 2, new Obstaculo(quadro));
    }
}
