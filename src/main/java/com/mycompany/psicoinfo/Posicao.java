/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.psicoinfo;

/**
 *
 * @author lelo0
 */
public class Posicao {
    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public void setValores(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    @Override
    public String toString(){
        return linha + ", " + coluna;
    }
}
