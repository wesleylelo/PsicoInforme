/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.psicoinfo;

import static psico.Cor.WHITE;
import static psico.Cor.YELLOW;
import psico.PsicoCampo;


public class Quadro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Quadro(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
            throw new QuadroExcecao("Error creating board: there must be at least 1 row and 1 column");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna){
        if(!posicaoExiste(linha,coluna)){
            throw new QuadroExcecao("Position not on the board");
        }
        return pecas[linha][coluna];
    }
    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new QuadroExcecao("Position not on the board");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    
    public void locarPeca(Peca peca, Posicao posicao, PsicoCampo p){
        if(existeEUmaPeca(posicao)){
            throw new QuadroExcecao("There is already a piece on position" + posicao);
        }
        if(p.getAtualPlayer() == WHITE){
            if(posicao.getLinha() >= 4){
                pecas[posicao.getLinha()][posicao.getColuna()] = peca;
                peca.posicao = posicao;
            }else{
                throw new QuadroExcecao("Campo não é seu!");
            }
        }else if(p.getAtualPlayer() == YELLOW){
            if(posicao.getLinha() <= 3 ){
                pecas[posicao.getLinha()][posicao.getColuna()] = peca;
                peca.posicao = posicao;
            }else{
                throw new QuadroExcecao("Campo não é seu!");
            }
        }
    }
    public void locarPeca(Peca peca, Posicao posicao){
        if(existeEUmaPeca(posicao)){
            throw new QuadroExcecao("There is already a piece on position" + posicao);
        }
            pecas[posicao.getLinha()][posicao.getColuna()] = peca;
            peca.posicao = posicao;
    }
    public Peca removerPeca (Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new QuadroExcecao("Position not on the board");
        }
        if(peca(posicao) == null){
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
    public boolean posicaoExiste(Posicao posicao){
       return posicaoExiste(posicao.getLinha(), posicao.getColuna()); 
    }/*Consertar*/
    public boolean posicaoExiste(int linha, int coluna){
      return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas; 
    }/*Consertar*/
    public boolean existeEUmaPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new QuadroExcecao("Position not on the board");
        }
        return peca(posicao) != null;
    }/**/
}