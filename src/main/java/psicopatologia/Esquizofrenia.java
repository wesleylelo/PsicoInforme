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
public class Esquizofrenia extends Psicopatologia {

    public Esquizofrenia(Quadro quadro) {
        super(30, 100,quadro);
        
    }
    @Override
    public String toString(){
        return "E";
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
                Na Esquizofrenia existem diversos sintomas, podendo paralizar o paciente. 
                 Lista de Sintomas: 
                Del\u00edrio, ter certeza cristalizada
                Pensamentos Obsessivos
                Alucina\u00e7\u00f5es, ver imagens ilus\u00f3rios
                Achar que tem super talentos
                Pensamentos distorcidos
                Medo irracionais
                """);
    }
    
    public Integer Atacar(){
        return getSeveridade();
    }
}
