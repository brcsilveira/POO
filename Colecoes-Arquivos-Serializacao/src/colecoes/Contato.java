/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class Contato implements Serializable{
    private final String nome;
    private final Data datadenascimento;
    private final Telefone telefone;
    
    public Contato(String n, Data d, Telefone t){
        this.nome = n;
        this.datadenascimento = d;
        this.telefone = t;
    }
    
    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + " - " + telefone +
                "\nData de Nascimento: " + datadenascimento;
    }
}
