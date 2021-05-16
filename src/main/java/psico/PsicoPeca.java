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
}
