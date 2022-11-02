/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecoes;

import java.io.Serializable;

/**
 *
 * @author Felipe Marques
 */
public class Data implements Comparable<Data>, Serializable {
    private final int dia;
    private final int mes;
    private final int ano;
    private static final String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril",
                                           "Maio", "Junho", "Julho", "Agosto",
                                           "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public Data(int ano, int mes, int dia) { // Considerar validar intervalos e lançar exceções
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public int dia() {
        return dia;
    }
    
    public int mes() {
        return mes;
    }
    
    public int ano() {
        return ano;
    }
    
    @Override
    public String toString() {
        return (dia < 10 ? "0"+dia : dia) + "/" + (mes < 10 ? "0"+mes : mes) + "/" + ano;
    }
    
    public String porExtenso() {
        return (dia < 10 ? "0"+dia : dia) + " de " + nomeDoMes(mes) + " de " + ano;
    }
    
    public static String nomeDoMes(int mes) {
        if (mes > 0 && mes < 13)
            return meses[mes-1];
        return null;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) {  
           return true;  
       }  
       if (o instanceof Data) {  
           Data outraData = (Data) o;  
           if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia == outraData.dia) {  
               return true;  
           }  
       }  
       return false;              
    }

    @Override
    public int compareTo(Data data) {
        if (this.equals(data))
            return 0;
        if (this.ano == data.ano && this.mes == data.mes)
            return this.dia - data.dia;
        if (this.ano == data.ano)
            return this.mes - data.mes;
        return this.ano - data.ano;
    }
}