/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psico;

/**
 *
 * @author lelo0
 */

import com.mycompany.psicoinfo.Peca;
import com.mycompany.psicoinfo.Quadro;
import static psico.Cor.GREEN;

/**
 *
 * @author lelo0
 */
public class Obstaculo extends PsicoPeca {
    

    public Obstaculo(Quadro quadro) {
        super(GREEN, quadro);
    
    }


    @Override
    public boolean[][] possivelMovimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}