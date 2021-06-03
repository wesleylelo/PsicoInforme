/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamento;

import com.mycompany.psicoinfo.Quadro;
import java.util.ArrayList;
import psico.Cor;

/**
 *
 * @author lelo0
 */
public class AtividadeFisica extends Tratamento{
    ArrayList<String> beneficios = new ArrayList<String>();

    public AtividadeFisica(Quadro quadro) {
        super(0.15, 25, quadro);
        
        this.beneficios.add(0,"Liberação de dopamina\n");
        this.beneficios.add(1,"Maior concentração\n");
        this.beneficios.add(2,"Bem-Estar\n");
        this.beneficios.add(3,"Alívio dos sintomas e melhora sono\n");
    }
    @Override
    public String toString(){
        return "F";
    }
    public String Informativo(){
        return ("A Atividade Física tem benefícios diversos, " + 
                "podendo amenizar e até mesmo eliminar os sintomas do paciente. \n Lista de Benefícios: \n" 
                + beneficios.get(0)
                + beneficios.get(1)
                + beneficios.get(2)
                + beneficios.get(3)
                );
    }
}
