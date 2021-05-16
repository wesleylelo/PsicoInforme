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
        this.sintomas = sintomas;
        this.sintomas.add(0,"Fadiga\n");
        this.sintomas.add(1,"Pensamentos Obsessivos Negativos\n");
        this.sintomas.add(2,"Falta de energia e apetite\n");
        this.sintomas.add(3,"Tristeza em excesso\n");
        this.sintomas.add(4,"Pensamentos suicidas, em casos graves\n");
        this.sintomas.add(5,"Sem esperança de alegria e bem-estar\n");
    }
    @Override
    public String toString(){
        return "De";
    }
    public String Informativo(){
        return ("Na Depressão existem diversos sintomas, " + 
                "podendo paralizar o paciente. \n Lista de Sintomas: \n" + sintomas.get(0)
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

