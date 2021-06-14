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
public class Medicacao extends Tratamento {
    ArrayList<String> beneficios = new ArrayList<String>();

    public Medicacao( Quadro quadro) {
        super(0.20, 25, quadro);
        
    }
    @Override
    public String toString(){
        return "C";
    }
    public static String Informativo(){
        return ("""
                A Medica\u00e7ao tem benef\u00edcios diversos, podendo amenizar e at\u00e9 mesmo eliminar os sintomas do paciente. 
                 Lista de Benef\u00edcios: 
                Al\u00edvio imediato dos sintomas
                Diminui\u00e7\u00e3o dos pensamentos obsessivos
                Aumento da serotonina ou outras subst\u00e2ncias
                Melhora do apetite e do sono
                """
                );
    }
}
