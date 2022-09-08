/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloco_de_lembretes;

/**
 *
 * @author aluno
 */
public class BlocoDeLembretes {    
    private Lembrete[] v1;
    private int cont;
    
    public BlocoDeLembretes(){
        this.v1 = new Lembrete[10];
        this.cont = 0;
    }
    
    public void incluirLembrete(Lembrete evento){
        boolean flag = cont == v1.length;
                        
        if(flag){
            Lembrete[] v2 = new Lembrete[v1.length * 2];
            System.arraycopy(this.v1, 0, v2, 0, this.v1.length);
            this.v1 = v2;
        }
        v1[cont] = evento;
        this.cont++;
    }
     
    public boolean removerLembrete(int posicao){
        int indice = posicao - 1;
        if(this.v1[indice] == null){
            return false;
        }
        int j = 0;
        Lembrete[] vcopy = new Lembrete[v1.length];
        for(int x = 0; x < numeroDeLembretes(); x++){
            if(x != indice){
                vcopy[j] = this.v1[x];
                j++;
            }
        }
        this.v1 = vcopy;
        
        this.cont--;
        return true;
    }
    
    public void listarLembretes(){
        for(int x = 0; x < numeroDeLembretes(); x++){
            if (this.v1[x] != null){
                System.out.print(this.v1[x] + "\n");
            }
            else{
                System.out.println("NENHUM LEMBRETE INSERIDO.");
            }
        }
    }    
   
    public void buscarLembretesPorData(Data data){
        int cont = 0;
        System.out.println("Inicio da busca\n");
        for(int i = 0; i < this.numeroDeLembretes(); i++) {
            if(this.v1[i].getData().equals(data)){
                this.v1[i].imprimir();
                cont++;
            }
	}
        if(cont == 0)
            System.out.println("NENHUM LEMBRETE RELACIONADO A ESSA DATA FOI ENCONTRADO.\n");
	System.out.println("Fim da busca\n");
    }
    
    public void buscarLembretesPorNome(String nome){
        int cont = 0;
        System.out.println("Inicio da busca\n");
        for(int i = 0; i < this.numeroDeLembretes(); i++){
            //System.out.println(this.v1[i].getNome().equalsIgnoreCase(nome)); //Compara ignorando maiúsculas e minúsculas
            if(this.v1[i].getNome().equalsIgnoreCase(nome)){
                this.v1[i].imprimir();
                cont++;
            }
        }
        if(cont == 0)
            System.out.println("NENHUM LEMBRETE RELACIONADO A ESSA DATA FOI ENCONTRADO.\n");
        System.out.println("Fim da busca\n");
    }
    
    //método GET
    public int numeroDeLembretes(){
        return this.cont;
    }
}
