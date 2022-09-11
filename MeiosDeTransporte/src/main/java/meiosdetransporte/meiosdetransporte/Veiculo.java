/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

/**
 *
 * @author bruno
 */
public class Veiculo {
    private String marca;
    private String modelo;
    private int qtdRodas;
    private int velocidade;
    
    public Veiculo(String marca, String modelo, int qtdRodas){
        this.marca = marca;
        this.modelo = modelo;
        this.qtdRodas = qtdRodas;
        this.velocidade = 0;
    }
    
    public void imprimirInformacoes(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("Marca: " + marca + " | Modelo: " + modelo);
        System.out.println("Quantidade de rodas: " + qtdRodas);
        System.out.println("Velocidade: " + velocidade + " Km/h");
        System.out.println("+-----------------------------------------------+");
    }
    
    public void acelerar(int valor){
        this.velocidade += valor;
    }
    
    public void frear(int valor){
        this.velocidade -= valor;
    }
    
    void imprimirVeiculo(){
        System.out.println(this);
    }
    
    @Override
	public String toString() {
        return
        	"Marca: " + this.marca + "\n" +
        	"Modelo: " + this.modelo + "\n" +
        	"Quantidade de rodas: " + this.qtdRodas + "\n";
    }
}
