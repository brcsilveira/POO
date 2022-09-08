/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloco_de_lembretes;

/**
 *
 * @author aluno
 */
public class Lembrete {
    private Data data;
    private String nome;
    private String descricao;
    
    public Lembrete(Data data, String nome, String descricao){
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    void imprimir (){
        System.out.println(this);
    }
    
    public Data getData(){
        return this.data;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    @Override
	public String toString() {
        return
        	"Nome: " + this.nome + "\n" +
        	"Descrição: " + this.descricao + "\n" +
        	"Data: " + this.data + "\n";
    }
}
