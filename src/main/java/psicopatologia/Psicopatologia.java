/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psicopatologia;

import com.mycompany.psicoinfo.Posicao;
import com.mycompany.psicoinfo.Quadro;
import javax.swing.text.Position;
import psico.Cor;
import static psico.Cor.WHITE;
import static psico.Cor.YELLOW;
import psico.PsicoPeca;

/**
 *
 * @author lelo0
 */
public abstract class Psicopatologia extends PsicoPeca {
    private Integer severidade;
    private Integer resistencia;
    
    public Psicopatologia(int severidade, int resistencia,Quadro quadro) {
        super(YELLOW, quadro);
        this.severidade = severidade;
        this.resistencia = resistencia;
    }
   
    public int getSeveridade() {
        return severidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = this.resistencia - resistencia;
    }

    
    private boolean podeMover(Posicao posica){
        PsicoPeca p = (PsicoPeca)getQuadro().peca(posica);
        if(posicao.getLinha() < 5)
            return p == null;
        else
            return false;
    }
    
    @Override
    public boolean[][] possivelMovimento() {
        boolean[][] mat = new boolean [getQuadro().getLinhas()][getQuadro().getColunas()];
        Posicao p = new Posicao(0,0);
        /*Rever*/
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
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
        
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
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
        
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
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
