/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

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
        return cont;
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
    
    /*for(int x = 0; x < numeroDeLembretes(); x++){
            if (this.v1[x] != null){
                System.out.print(this.v1[x] + "\n");
            }
            else{
                System.out.println("NENHUM LEMBRETE INSERIDO.");
            }
        }*/
    
    public void ordenar(){
        
    }
}
