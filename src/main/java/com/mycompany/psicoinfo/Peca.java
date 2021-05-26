/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.psicoinfo;

public abstract class Peca {
    protected Posicao posicao;
    public Quadro quadro;

    public Peca(Quadro quadro) {
        this.quadro = quadro;
        posicao = null;
    }

    protected Quadro getQuadro() {
        return quadro;
    }
    public abstract boolean [][] possivelMovimento();
    
    public boolean possivelMovimento(Posicao posicao){
        return possivelMovimento()[posicao.getLinha()][posicao.getColuna()];
    }/*Rever*/
    
    public boolean temAlgumMovimentoPossivel(){
        boolean[][] mat = possivelMovimento();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                if (mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean temAlgumMovimentoPossivel(boolean[][] p){
        boolean[][] mat = p;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                if (mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
