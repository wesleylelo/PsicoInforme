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
public class PsicoExcecao extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PsicoExcecao(String msg){
        super(msg);
    }
}
