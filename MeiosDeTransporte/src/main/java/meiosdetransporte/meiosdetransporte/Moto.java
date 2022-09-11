/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

/**
 *
 * @author bruno
 */
public class Moto extends Automovel{
    private boolean partidaEletrica;
    
    public Moto(String marca, String modelo, int qtdRodas, double potenciaDoMotor, boolean partidaEletrica){
        super(marca, modelo, qtdRodas, potenciaDoMotor);
        this.partidaEletrica = partidaEletrica;
    }
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println(partidaEletrica? "Tem partida elétrica" : "Não tem partida elétrica");
        System.out.println("+-----------------------------------------------+");
    }
}
