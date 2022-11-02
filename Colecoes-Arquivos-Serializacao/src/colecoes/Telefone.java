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
public class Telefone implements Serializable {
    private final String codigoDeArea;
    private final String numero;
    
    public Telefone(String ca, String n) {
        this.codigoDeArea = ca;
        this.numero = n;
    }
    
    @Override
    public String toString() {
        return "(" + this.codigoDeArea + ") " + numero; 
    }
}
