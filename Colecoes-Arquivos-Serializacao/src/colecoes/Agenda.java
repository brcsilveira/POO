/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecoes;

import io.Arquivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author aluno
 */
public class Agenda {
    private Map<String, Contato> colecao;
    
    public Agenda() {
        colecao = new TreeMap<String, Contato>();
    }
    
    public void inserir(Contato c) {
        colecao.put(c.getNome(), c);
    }
    
    public Contato remover(String nome) {
        return colecao.remove(nome);
    }
    
    public Contato buscaPorNome(String nome){
        return colecao.get(nome);
    }
    
    public void listar(){
        System.out.println("-- Lista de Contatos ---------------------");
        for (Contato c : colecao.values()){
            System.out.println(c);
        }
    }
    
    public void salvarArquivo(String caminho) {
        
        try {
            Arquivos.serializar(caminho, colecao);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: O arquivo '" + caminho + "não foi encontrado.");
        } catch (IOException e) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + caminho + ".");
        }
    }
    
    public void lerArquivo(String caminho) {
        try {
            colecao = (Map<String, Contato>) Arquivos.desserializar(caminho);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: O arquivo '" + caminho + "'não foi encontrado.");
        } catch (IOException e) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + caminho + ".");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: A classe referenciada no arquivo não definida.");
        }
    } 
    
    public void salvarArquivoTexto(String caminho) {
        
        try {
            Arquivos.escreverTexto(caminho, colecao);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: O arquivo '" + caminho + "não foi encontrado.");
        } catch (IOException e) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + caminho + ".");
        }
    }
    
    
    public static void main(String[] args){
        Agenda agenda = new Agenda();
        agenda.lerArquivo("Contatos.dat");
        
        /*Contato c = new Contato("Maria", new Data(2000, 6, 10), new Telefone("53", "999999999"));
        
        agenda.inserir(c);
        
        c = new Contato("Felipe", new Data(2000, 10, 10), new Telefone("53", "111111111"));
        
        agenda.inserir(c);
        */
        /*
        Contato c = new Contato("João", new Data(2000, 10, 24), new Telefone("53", "123456789"));
        
        agenda.inserir(c);
        /*
        c = agenda.remover("João");
        
        agenda.listar();
        
        System.out.println("-- Contato Removido -------");
        System.out.println(c);
        */
        
        agenda.listar();
        
        
        agenda.salvarArquivoTexto("Contatos.txt");
        //agenda.salvarArquivo("Contatos.dat");
    }
}
