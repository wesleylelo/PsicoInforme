/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psicopatologia;

import com.mycompany.psicoinfo.Quadro;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import psico.Cor;

/**
 *
 * @author lelo0
 */
public class Ansiedade extends Psicopatologia {
    ArrayList<String> sintomas = new ArrayList<String>();

    public Ansiedade(int severidade, int resistencia, Quadro quadro) {
        super(severidade, resistencia, quadro);
    }

    public Ansiedade(Quadro quadro) {
        super(20, 100, quadro);
        
    }
    
    @Override
    public String toString(){
        return "A";
    }
    public boolean setLife() {
        if(getResistencia() == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public static String Informativo(){
        return ("""
                Na Ansiedade existem diversos sintomas, podendo paralizar o paciente. 
                 Lista de SintomasAumento do batimento card\u00edaco
                Pensamentos Obsessivos
                Pensamento focado no Futuro
                Ang\u00fastia
                Pensamentos Negativos sobre o futuro
                Medo irracionais
                """);
    }
    public Integer Atacar(){
        return getSeveridade();
    }
}
