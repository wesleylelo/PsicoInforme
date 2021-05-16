/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psico;

import com.mycompany.psicoinfo.Posicao;

/**
 *
 * @author lelo0
 */
public class PsicoPosicao {
    private char coluna;
    private int linha;
    public PsicoPosicao(char coluna, int linha){
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new PsicoExcecao("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public void setColuna(char coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    protected Posicao toPosicao(){
        return new Posicao(8 - linha, coluna - 'a');
    }
    protected static PsicoPosicao dePosicao(Posicao posicao){
        return new PsicoPosicao((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }/*Rever*/
    @Override
    public String toString(){
        return "" + coluna + linha;
    }
}
