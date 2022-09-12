/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package meiosdetransporte.meiosdetransporte;

/**
 *
 * @author bruno
 */
public class MeiosDeTransporte {

    public static void main(String[] args) {
        /*Veiculo v1 = new Veiculo("Teste", "Meu modelo", 3);
        v1.acelerar(10);
        v1.imprimirInformacoes();
        
        System.out.println("#--------Teste da Bike--------#");
        
        Bicicleta b1 = new Bicicleta("ferrada", "prateada", 2, 12, false);
        b1.acelerar(14);
        b1.imprimirInformacoes();
        
        System.out.println("#--------Teste do Auto--------#");
        
        //public Automovel(String marca, String modelo, int qtdRodas, double potenciaDoMotor)
        Automovel a1 = new Automovel("Chevrolet", "Prisma", 4, 1.0);
        a1.acelerar(140);
        a1.imprimirInformacoes();
        
        System.out.println("#--------Teste do Carro--------#");
        
        //public Carro(String marca, String modelo, int qtdRodas, double potenciaDoMotor, int qtdPortas)
        Carro c1 = new Carro("Ford", "Focus", 4, 1.6, 4);
        c1.acelerar(180);
        c1.imprimirInformacoes();
        
        System.out.println("#--------Teste da Moto--------#");
        
        //public Moto(String marca, String modelo, int qtdRodas, double potenciaDoMotor, boolean partidaEletrica)
        Moto m1 = new Moto("Honda", "FAN", 2, 125, true);
        m1.acelerar(110);
        m1.imprimirInformacoes();*/
        
        System.out.println("#--------Teste Cadastro de Veiculos--------#");
        
        CadastroDeVeiculos vei = new CadastroDeVeiculos(2);
        vei.inserir(new Veiculo("Chevrolet", "Onix", 4));
        vei.imprimir();
        System.out.println("fim do primeiro imprimir");
        vei.inserir(new Veiculo("Chevrolet", "Prisma", 4));
        vei.imprimir();
        System.out.println("fim dos segundo imprimir");
        vei.inserir(new Veiculo("Chevrolet", "Celta", 4));
        vei.imprimir();
        System.out.println("fim do terceiro imprimir");
        System.out.println(vei.retornaItem(50));
        System.out.println("Teste de ordenação:");
        vei.ordenar();
        vei.imprimir();
    }
}
