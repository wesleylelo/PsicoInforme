/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psicopatologia;

import com.mycompany.psicoinfo.Quadro;
import java.util.ArrayList;
import psico.Cor;

/**
 *
 * @author lelo0
 */
public class Depressao extends Psicopatologia{
    ArrayList<String> sintomas = new ArrayList<String>();

    public Depressao(Quadro quadro) {
        super(35, 100,quadro);
        
    }
    @Override
    public String toString(){
        return "D";
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
                Na Depress\u00e3o existem diversos sintomas, podendo paralizar o paciente. 
                 Lista de Sintomas: 
                Fadiga
                Pensamentos Obsessivos Negativos
                Falta de energia e apetite
                Tristeza em excesso
                Pensamentos suicidas, em casos graves
                Sem esperan\u00e7a de alegria e bem-estar
                """);
    }
    public Integer Atacar(){
        return getSeveridade();
    }
}  

