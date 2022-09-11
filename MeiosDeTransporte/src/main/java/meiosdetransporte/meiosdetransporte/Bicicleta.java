/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package meiosdetransporte.meiosdetransporte;

/**
 *
 * @author bruno
 */
public class Bicicleta extends Veiculo {
    private int numeroDeMarchas;
    private boolean bagageiro;
    
    public Bicicleta(String marca, String modelo, int qtdRodas, int numeroDeMarchas, boolean bagageiro){
        super(marca, modelo, qtdRodas);
        this.numeroDeMarchas = numeroDeMarchas;
        this.bagageiro = bagageiro;
    }
    
    /*
    (exp)? then : else
        Serve para a linha 28;
    */
    
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Numero de marchas: " + numeroDeMarchas);
        System.out.println(bagageiro? "Tem bagageiro" : "Não tem bagageiro");
        System.out.println("+-----------------------------------------------+");
    }
}
