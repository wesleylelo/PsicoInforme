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
    ArrayList<String> sintomas = new ArrayList<String>();

    public Esquizofrenia(Quadro quadro) {
        super(30, 100,quadro);
        this.sintomas = sintomas;
        this.sintomas.add(0,"Delírio, ter certeza cristalizada\n");
        this.sintomas.add(1,"Pensamentos Obsessivos\n");
        this.sintomas.add(2,"Alucinações, ver imagens ilusórios\n");
        this.sintomas.add(3,"Achar que tem super talentos\n");
        this.sintomas.add(4,"Pensamentos distorcidos\n");
        this.sintomas.add(5,"Medo irracionais\n");
    }
    @Override
    public String toString(){
        return "Es";
    }
    public String Informativo(){
        return ("Na Esquizofrenia existem diversos sintomas, " + 
                "podendo paralizar o paciente. \n Lista de Sintomas: \n" 
                + sintomas.get(0)
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
