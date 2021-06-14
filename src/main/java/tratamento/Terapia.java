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
        
    }
    @Override
    public String toString(){
        return "T";
    }
    public static String Informativo(){
        return ("""
                A Terapia tem benef\u00edcios diversos, podendo amenizar e at\u00e9 mesmo eliminar os sintomas do paciente. 
                 Lista de Benef\u00edcios: 
                Autoconhecimento
                Conhecimento atrav\u00e9s da associa\u00e7\u00e3o livre
                Bem-Estar
                Melhora por t\u00e9cnicas terap\u00eauticas
                """
                );
    }
}
