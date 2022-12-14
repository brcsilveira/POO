package game;

import java.util.*;
import java.util.Scanner;


public class JogoDaExplosao {
    private final Tabuleiro tabuleiro;
    private final Dado dado;
    private final List<Jogador> jogadores;
    private int indexJogadorAtual;
    private final Random randSeed;
    private Jogador ganhador;
    
    public JogoDaExplosao(Dado d, Tabuleiro t, List<Jogador> jogadores) {
        this.tabuleiro = t;
        this.dado = d;
        this.jogadores = jogadores;
        this.indexJogadorAtual = 0;
        this.randSeed = new Random();
    }
    
    public void mudarJogador() {
        this.indexJogadorAtual++;
        if(this.indexJogadorAtual >= this.jogadores.size()) {
            this.indexJogadorAtual = 0;
        }
    }
    
    public Jogador getJogadorAtual() {
        return this.jogadores.get(indexJogadorAtual);
    }

    public Dado getDado() {
        return dado;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getGanhador() {
        return ganhador;
    }
    
    public void tratativaValorDado(int valor, Jogador j) {
        System.out.println("Dado resultado foi " + valor);
        PosicaoTabuleiro posicaoAtualJogador = this.tabuleiro.getPosicao(j.getPosicaoX(), j.getPosicaoY());
        if(valor<=3) {
            System.out.println("Andar " + valor);
            // 1 2 3 andar
            int construidas=0;
            // andar(valor+1)
            while(construidas<valor ) {
                posicaoAtualJogador = posicaoAtualJogador.getProximaPosicao();
                if(posicaoAtualJogador.getX() == j.getPosicaoInicialX() && posicaoAtualJogador.getY() == j.getPosicaoInicialY()) {
                    System.out.println("GANHOU");
                    this.ganhador = j;
                    break;
                    
                }
                if(!posicaoAtualJogador.getConstruida()) {
                    construidas++;
                    posicaoAtualJogador.setConstruida(true);
                }
            }
            
            j.setPosicaoX(posicaoAtualJogador.getX());
            j.setPosicaoY(posicaoAtualJogador.getY());
            
        } else if (valor <=5) {
            // 4 5 = bomba
            int ladoId = this.randSeed.nextInt(4);
            String ladoString = "gerando";
            switch (ladoId) {
                case 0 -> ladoString = "topo";
                case 1 -> ladoString = "base";
                case 2 -> ladoString = "direito";
                case 3 -> ladoString = "esquerdo";
            }

            System.out.println("BOMBAAA!! destruindo o lado " + ladoString);
            this.tabuleiro.explodirLado(ladoId); 
            
            // verificar se algum jogador est?? no lado explodido
            for(int i=0; i<this.jogadores.size(); i++) {
                Jogador jogador = jogadores.get(i);
                int x = jogador.getPosicaoX();
                int y = jogador.getPosicaoY();
                
                //
                PosicaoTabuleiro posicaoJogador = tabuleiro.getPosicao(x, y);
                PosicaoTabuleiro pontoDeSalvamento = null;
                // resetar para o proximo salvamento
                if(ladoId == 0 && y == 0) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador no topo
                } else if (ladoId == 1 && y == tabuleiro.getDimensaoTabuleiro() - 1) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na base
                } else if (ladoId == 2 && x == tabuleiro.getDimensaoTabuleiro() - 1) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na direita
                } else if (ladoId == 3 && x == 0) {
                    pontoDeSalvamento = posicaoJogador.getPontoDeSalvamentoMaisProximo();
                    // explosao e jogador na esquerda
                }
                
                if(pontoDeSalvamento != null) {
                    System.out.println("O jogador " + jogador.getNome() + " caiu da ponte! ");
                    System.out.println("voltando para x: " + pontoDeSalvamento.getX() + " y: " + pontoDeSalvamento.getY());
                    jogador.setPosicaoX(pontoDeSalvamento.getX());
                    jogador.setPosicaoY(pontoDeSalvamento.getY());
                }
            }
        } else {
            Jogador jog;
            int poder = this.randSeed.nextInt(6);
            switch (poder) {
                case 0 : 
                    jog = getJogadorAtual();
                    jog.setPassivo(new AsasDeIcaro("AsasDeIcaro"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item passivo: AsasDeIcaro");
                break;
                case 1:
                    jog = getJogadorAtual();
                    jog.setPassivo(new Escudo("Escudo"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item passivo: Escudo");
                break;
                case 2:
                    jog = getJogadorAtual();
                    jog.setPassivo(new Empurrar("Empurrar"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item passivo: Empurrar");
                break;
                case 3:
                    jog = getJogadorAtual();
                    jog.setInstantaneo(new Imobilizar("Imobilizar"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item instant??neo: Imobilizar");
                break;
                case 4:
                    jog = getJogadorAtual();
                    jog.setInstantaneo(new Velocidade("Velocidade"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item instant??neo: Velocidade");
                break;
                case 5:
                    jog = getJogadorAtual();
                    jog.setInstantaneo(new Sabotar("Sabotar"));
                    System.out.println("Jogador " + jog.getNome() + " adquiriu um item instant??neo: Sabotar");
                break;
            }
            
        }
    
    }
    
    public String getMenu() {
        return """
               1 - Girar dado
               2 - listar poderes
               3 - usar poder""";
    }
    
    public void getPosicoesJogadores() {
        for(int i=0; i<jogadores.size(); i++) {
            Jogador j = jogadores.get(i);
            String nome = j.getNome();
            int x, y;
            x = j.getPosicaoX();
            y = j.getPosicaoY();
            System.out.println(nome + " est?? nas coordenadas X: " + x + " | Y: " + y);
        }
    }
    //Bruno: N??o entendi muito bem ess
    public void tratarEscolha(int escolha) {
        
        int valor;
        
        switch (escolha) {
        case 1: //Lan??a o dado
            valor = this.dado.rodar();
            this.tratativaValorDado(valor, this.getJogadorAtual());
        break;
        case 2: //Lista os poderes
            getJogadorAtual().listaPoderes();
            Scanner entrada = new Scanner(System.in);
            System.out.println("""
               1 - Girar dado
               3 - usar poder""");
            System.out.print(">");
            escolha = entrada.nextByte();
            tratarEscolha(escolha);
        break;
        case 3: //Usa os poderes
            
        break;
        default: //Se tudo der errado lan??a o dado
            valor = this.dado.rodar();
            this.tratativaValorDado(valor, this.getJogadorAtual());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("""
                           Bem vindo ao Jogo Explosao Estrela!
                           Inicialmente voc\u00ea deve definir as especifica\u00e7oes da partida a ser jogada, como dimensoes do tabuleiro, quantidade de jogadores e seus nomes.Tenha um bom jogo
                           """);
        
        
        // valida??ao int
        System.out.println("Informe as dimensoes do jogo: ");
        int dimensao = entrada.nextInt();
        
        // valida??ao int
        System.out.println("Informe a quantidade de jogadores (max. 4, valores maiores serao arredondados para 4): ");
        int numeroJogadores = entrada.nextByte();     numeroJogadores = numeroJogadores > 4 ? 4 : numeroJogadores;
        if(numeroJogadores > 4) {
            numeroJogadores = 4;
        }
        
        
        entrada.nextLine();
        List<Jogador> jogadores = new ArrayList<>();
        for(int i=0; i<numeroJogadores; i++) {
            int x, y;
            
            switch (i) {
                default:
                case 0:
                    x=0;
                    y=0;
                    break;
                case 1:
                    x=dimensao-1;
                    y=0;
                    break;
                case 2:
                    x=dimensao-1;
                    y=dimensao-1;
                    break;
                case 3:
                    x=0;
                    y=dimensao-1;
                    break;
            }
            
            System.out.println("Insira o nome do jogador " + i + " :");
            
            String n = entrada.nextLine();
            Jogador j = new Jogador(n, x, y);
            jogadores.add(j);
        }
        
        
        Dado d = new Dado();
        Tabuleiro t = new Tabuleiro(dimensao);
        int escolha;
        
        
        JogoDaExplosao jogo = new JogoDaExplosao(d, t, jogadores);
        
        while(true) {
            System.out.println("Estado do tabuleiro: ");
            jogo.getTabuleiro().printBoardOnConsole();
            System.out.println("Estado dos jogadores: ");
            jogo.getPosicoesJogadores();
            System.out.println("\nJogador atual: " + jogo.getJogadorAtual().getNome());

            System.out.println("\n");

            System.out.println(jogo.getMenu());
            System.out.print(">");
            escolha = entrada.nextByte();
            jogo.tratarEscolha(escolha);
            if(jogo.getGanhador() != null) {
                System.out.println(jogo.getGanhador().getNome() + " GANHOU!!");
                break;
            }
            
            jogo.mudarJogador();
        }    
    }
    
}