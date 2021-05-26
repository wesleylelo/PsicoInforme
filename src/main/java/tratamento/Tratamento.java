/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamento;

import com.mycompany.psicoinfo.Posicao;
import com.mycompany.psicoinfo.Quadro;
import psico.Cor;
import static psico.Cor.WHITE;
import psico.PsicoPeca;

/**
 *
 * @author lelo0
 */
public abstract class Tratamento extends PsicoPeca {
    private Double bloqueio;
    private Integer beneficio;

    public Tratamento(Double bloqueio, Integer beneficio, Quadro quadro) {
        super(WHITE, quadro);
        this.bloqueio = bloqueio;
        this.beneficio = beneficio;
    }

    

    public Double getBloqueio(Integer b) {
        return bloqueio*b;
    }

    public Integer getBeneficio() {
        return beneficio;
    }
    
    public Integer tratar(){
        return getBeneficio();
    }
    
    private boolean podeMover(Posicao posica){
        PsicoPeca p = (PsicoPeca)getQuadro().peca(posica);
        if(posicao.getLinha() >= 5)
            return p == null;
        else
            return false;
    }
    @Override
    public boolean[][] possivelMovimento() {
        boolean[][] mat = new boolean [getQuadro().getLinhas()][getQuadro().getColunas()];
        Posicao p = new Posicao(0,0);
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if(getQuadro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }
        return mat;
}
}