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
public class Meditacao extends Tratamento {
    ArrayList<String> beneficios = new ArrayList<String>();

    public Meditacao( Quadro quadro) {
        super(0.15, 25, quadro);
        this.beneficios = beneficios;
        this.beneficios.add(0,"Maior foco no presente\n");
        this.beneficios.add(1,"Menor impacto dos pensamentos obsessivos\n");
        this.beneficios.add(2,"Bem-Estar\n");
        this.beneficios.add(3,"Alívio e melhor sono\n");
    }
    @Override
    public String toString(){
        return "D";
    }
    public static String Informativo(){
        return ("""
                A Medita\u00e7ao tem benef\u00edcios diversos, podendo amenizar e at\u00e9 mesmo eliminar os sintomas do paciente. 
                 Lista de Benef\u00edcios: 
                Maior foco no presente
                Menor impacto dos pensamentos obsessivos
                Bem-Estar
                Al\u00edvio e melhor sono
                """
                );
    }
}
