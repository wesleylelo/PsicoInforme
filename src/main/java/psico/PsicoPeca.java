/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psico;

import com.mycompany.psicoinfo.Peca;
import com.mycompany.psicoinfo.Posicao;
import com.mycompany.psicoinfo.Quadro;
import static psico.Cor.GREEN;
import static psico.Cor.WHITE;
import static psico.Cor.YELLOW;

/**
 *
 * @author lelo0
 */
    public abstract class PsicoPeca extends Peca {
    private Cor cor;
    
    public PsicoPeca(Cor cor, Quadro quadro) {
        super(quadro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
    protected boolean existeOponentePeca(Posicao posicao){
        PsicoPeca p = (PsicoPeca)getQuadro().peca(posicao);
        return p != null && p.getCor() != cor && p.getCor() != GREEN;
    }
    public boolean[][] possivelAtaque(){
        boolean[][] mat  = new boolean[getQuadro().getLinhas()][getQuadro().getColunas()];
        Posicao p = new Posicao(0,0);
        p.setValores(posicao.getLinha(), posicao.getColuna());
        System.out.println("+++++++++++++++0");
        if(cor == WHITE){
        while(getQuadro().posicaoExiste(p) && !getQuadro().existeEUmaPeca(p)){
            p.setLinha(p.getLinha() + 1);
            System.out.println("+++++++++++++++0");
            continue;
            
        }
        if(getQuadro().posicaoExiste(p) && existeOponentePeca(p)){
            System.out.println("+++++++++++++++");
            mat[p.getLinha()][p.getColuna()] = true;
        }
        } else if(cor == YELLOW){
           while(getQuadro().posicaoExiste(p) && !getQuadro().existeEUmaPeca(p)){
            p.setLinha(p.getLinha() -1);
            System.out.println("+++++++++++++++0");
            continue;
            
        }
        if(getQuadro().posicaoExiste(p) && existeOponentePeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            System.out.println("+++++++++++++++");
                    
        } 
        }
        return mat;
    }
}
