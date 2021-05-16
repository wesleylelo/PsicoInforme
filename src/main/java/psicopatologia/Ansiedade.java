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

    public Ansiedade(Quadro quadro) {
        super(20, 100, quadro);
        this.sintomas = sintomas;
        this.sintomas.add(0,"Aumento do batimento cardíaco\n");
        this.sintomas.add(1,"Pensamentos Obsessivos\n");
        this.sintomas.add(2,"Pensamento focado no Futuro\n");
        this.sintomas.add(3,"Angústia\n");
        this.sintomas.add(4,"Pensamentos Negativos sobre o futuro\n");
        this.sintomas.add(5,"Medo irracionais\n");
    }
    @Override
    public String toString(){
        return "Es";
    }
    public String Informativo(){
        return ("Na Ansiedade existem diversos sintomas, " + 
                "podendo paralizar o paciente. \n Lista de Sintomas" + sintomas.get(0)
                + sintomas.get(1)
                + sintomas.get(2)
                + sintomas.get(3)
                + sintomas.get(4)
                + sintomas.get(5));
    }
    public Integer Atacar(){
        return getSeveridade();
    }
}
