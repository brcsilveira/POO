/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import colecoes.Contato;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *
 * @author Felipe Marques
 */
public class Arquivos {
    
    public static void serializar(String caminho, Object obj) throws FileNotFoundException, IOException {
        FileOutputStream arquivo = new FileOutputStream(caminho);
        ObjectOutputStream fluxo = new ObjectOutputStream(arquivo);
        fluxo.writeObject(obj);
        fluxo.close();
    }
    
    public static Object desserializar(String caminho)  throws ClassNotFoundException, FileNotFoundException, IOException {
        Object obj;
        FileInputStream arquivo = new FileInputStream(caminho);
        ObjectInputStream fluxo = new ObjectInputStream(arquivo);
        obj = fluxo.readObject();
        fluxo.close();
        return obj;
    }
    
    public static void escreverTexto(String caminho, Map<String, Contato> mapa)  throws FileNotFoundException, IOException  {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
        String linha;
        for(Contato contato : mapa.values()) {
            linha = contato.toString() + "\n";
            buffWrite.write(linha, 0, linha.length());
        }
        buffWrite.close();
    }
}
