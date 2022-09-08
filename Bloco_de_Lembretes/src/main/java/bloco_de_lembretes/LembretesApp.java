/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloco_de_lembretes;
import java.util.Scanner;
/**
 *
 * @author Bruno
 */
public class LembretesApp {
    public static void main (String[] args){
        //Lembrete e1 = new Lembrete(new Data((byte)23, (byte)6, (short)2000),"Bruno","Futebol"); //TESTE, EX1 FEITO
        //e1.imprimir(); Feito para o ex1
        BlocoDeLembretes bloco = new BlocoDeLembretes();
        
        Scanner ler = new Scanner (System.in);
        int dia, mes, ano, choose, indice;
        String nome, descricao;
        
        menu(bloco);
        System.out.println("\n");
        choose = ler.nextInt();
        System.out.println("\n");
        while (choose < 1 || choose > 6){
            System.out.println("DIGITE UMA ESCOLHA VÁLIDA!");
            menu(bloco);
            System.out.println("\n");
            choose = ler.nextInt();
            System.out.println("\n");
        }
        
        while (choose > 0 && choose < 7){
            if (choose == 1){ //INSERIR
                System.out.println("Informe o lembrete.");
                System.out.print("Dia: ");
                dia = ler.nextInt();
                System.out.print("Mês: ");
                mes = ler.nextInt();
                System.out.print("Ano: ");
                ano = ler.nextInt();
                ler.nextLine();//Limpa o buffer
                System.out.print("Nome: ");
                nome = ler.nextLine();          
                System.out.print("Descrição: ");
                descricao = ler.nextLine();

                Lembrete evento = new Lembrete(new Data((byte)dia, (byte)mes, ano), nome, descricao);
                bloco.incluirLembrete(evento);
                System.out.println("\n");
            }
            if (choose == 2){ //REMOVER
                if (bloco.numeroDeLembretes() == 0){
                    System.out.println("NÃO EXISTE NENHUM LEMBRETE CADASTRADO!");
                }
                else{
                    System.out.print("Informe qual lembrete você deseja remover(NÚMERO): ");
                    indice = ler.nextInt();                    
                    if (bloco.removerLembrete(indice) == false){
                        System.out.println("O LEMBRETE " + indice + " NÃO EXISTE!");
                    }
                    else{
                        System.out.println("O LEMBRETE " + indice + " FOI REMOVIDO!");
                    }
                }                
            }
            if (choose == 3){ //LISTAR
                bloco.listarLembretes();
            }
            if (choose == 4){ //BUSCA POR DATA
                System.out.println("INFORME A DATA.");
                System.out.print("Dia: ");
                dia = ler.nextInt();
                System.out.print("Mês: ");
                mes = ler.nextInt();
                System.out.print("Ano: ");
                ano = ler.nextInt();
                bloco.buscarLembretesPorData(new Data(dia, mes, ano));
            
            }
            if (choose == 5){ //BUSCA POR NOME
                System.out.println("INFORME O NOME: ");
                ler.nextLine();//Limpa o buffer
                nome = ler.nextLine();
                bloco.buscarLembretesPorNome(nome);                
            }
            if (choose == 6){
                break;
            }
            
            menu(bloco);
            System.out.println("\n");
            choose = ler.nextInt();
            System.out.println("\n");
            while (choose < 1 || choose > 7){
                System.out.println("DIGITE UMA ESCOLHA VÁLIDA!");
                menu(bloco);
                System.out.println("\n");
                choose = ler.nextInt();
                System.out.println("\n");
            }
        }       
        System.out.println("\nFIM DO PROGRAMA!");
    }
    
    public static void menu (BlocoDeLembretes bloco){
        System.out.println("Lembretes App - A lista contém " + bloco.numeroDeLembretes() + " lembretes.");
        System.out.println("Escolha uma das seguintes opções:");
        System.out.println("1 - Adicionar novo lembrete");
        System.out.println("2 - Remover Lembrete");
        System.out.println("3 - Listar");
        System.out.println("4 - Busca por data");
        System.out.println("5 - Busca por nome");
        System.out.println("6 - Sair");
    }
}
