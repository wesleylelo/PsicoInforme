/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamento;

import com.mycompany.psicoinfo.Quadro;
import java.awt.Color;
import java.util.ArrayList;
import psico.Cor;

/**
 *
 * @author lelo0
 */
public class Terapia extends Tratamento {
    ArrayList<String> beneficios = new ArrayList<String>();

    public Terapia(Quadro quadro) {
        super(0.25, 25, quadro);
        this.beneficios = beneficios;
        this.beneficios.add(0,"Autoconhecimento\n");
        this.beneficios.add(1,"Conhecimento através da associação livre\n");
        this.beneficios.add(2,"Bem-Estar\n");
        this.beneficios.add(3,"Melhora por técnicas terapêuticas\n");
    }
    @Override
    public String toString(){
        return "T";
    }
    public String Informativo(){
        return ("A Terapia tem benefícios diversos, " + 
                "podendo amenizar e até mesmo eliminar os sintomas do paciente. \n Lista de Benefícios: \n" 
                + beneficios.get(0)
                + beneficios.get(1)
                + beneficios.get(2)
                + beneficios.get(3)
                + beneficios.get(4)
                + beneficios.get(5));
    }
}
