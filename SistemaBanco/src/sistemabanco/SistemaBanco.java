/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

/**
 *
 * @author Felipe Marques
 */
public class SistemaBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean consegui;
        Conta minhaConta, contaDestino;
        
        Pessoa maria, joao, felipe;
        maria = new Pessoa("Maria");
        joao = new Pessoa("Joao");
        felipe = new Pessoa("Felipe");
        
        minhaConta = new Conta(maria, 1000, 700);
        minhaConta.imprimir();
        
        contaDestino = new Conta(joao, 500);
        contaDestino.deposita(200);
        contaDestino.imprimir();
        
        Conta contaFelipe = new Conta(felipe, 400, 300);
        
        consegui = minhaConta.saca(700);
        if (consegui == true)
            System.out.println("Saque realizado com sucesso!");
        else
            System.out.println("Saldo Insuficiente!");
        
        minhaConta.transferirPara(contaDestino, 500);
        
        minhaConta.imprimir();
        contaDestino.imprimir();
        contaFelipe.imprimir();
    }
}