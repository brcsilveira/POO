/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

/**
 *
 * @author bruno
 */
public class Carro extends Automovel{
    private int qtdPortas;
    
    public Carro(String marca, String modelo, int qtdRodas, double potenciaDoMotor, int qtdPortas){
        super(marca, modelo, qtdRodas, potenciaDoMotor);
        this.qtdPortas = qtdPortas;
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Quantidade de portas: " + qtdPortas);
        System.out.println("+-----------------------------------------------+");
    }
}
