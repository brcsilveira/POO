/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

import java.util.Arrays;

/**
 *
 * @author T-Gamer
 */
public class CadastroDeVeiculos {
    private Veiculo[] listaDeVeiculos;
    private int cont;
    
    public CadastroDeVeiculos(int tamanhoDaLista){
        this.listaDeVeiculos = new Veiculo[tamanhoDaLista];
        this.cont = 0;
    }
    
    public void inserir(Veiculo objeto){
        boolean flag = cont == listaDeVeiculos.length;
        
        if(flag){
            Veiculo[] copy = new Veiculo[listaDeVeiculos.length * 2];
            
            System.arraycopy(this.listaDeVeiculos, 0, copy, 0, this.listaDeVeiculos.length);
            
            this.listaDeVeiculos = copy;
        }
        listaDeVeiculos[cont] = objeto;
        cont++;
    }
    
    public String retornaItem (int posicao){
        int index = posicao - 1;
        
        if(index > listaDeVeiculos.length){
            return null;
        }
        
        if((this.listaDeVeiculos[index] == null)){
            return null;
        }
        else{
            return "VEÍCULO DA POSIÇÃO " + posicao + ".\n" + this.listaDeVeiculos[index];
        }
    }
    
    public int tamanho(){
        return this.cont;
    }
    
    public void imprimir(){
        for(int i = 0; i < tamanho(); i++){
            if (this.listaDeVeiculos[i] != null){
                System.out.print(this.listaDeVeiculos[i] + "\n");
            }
            else{
                System.out.println("NENHUM VEICULO CADASTRADO!");
            }
        }
    }
    
    public void ordenar(){
        Veiculo temp;
        
        for(int x = 0; x < tamanho() - 1; x++)
        {
            for(int y = x + 1; y < tamanho(); y++){
                if ((this.listaDeVeiculos[x].getModelo().compareTo(this.listaDeVeiculos[y].getModelo())) > 0){ //listaDeVeiculos[x] é maior que listaDeVeiculos[y]
                    temp = listaDeVeiculos[x];
                    this.listaDeVeiculos[x] = listaDeVeiculos[y];
                    this.listaDeVeiculos[y] = temp;  
                }
            }
        }
    }
}
