/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Felipe
 */
import java.util.Random;
import java.util.Scanner;
public class Craps {
    private static final Random randomNumbers = new Random();
    
    private enum Status { CONTINUE, GANHOU, PERDEU};
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_ELEVEN = 11;
    private static final int BOX_CARS = 12;
    
    
    
    public void Play() {
        int meusPontos = 0;
        Status statusdoJogo;
        
        int somadePontos = jogaOsDados();
        
        switch (somadePontos) {
            case SEVEN:
            case YO_ELEVEN:
                statusdoJogo = Status.GANHOU;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                statusdoJogo = Status.PERDEU;
                break;
                
            default:
                statusdoJogo = Status.CONTINUE;
                meusPontos = somadePontos;
                System.out.printf("Seus pontos sao :  %d\n",meusPontos);
                break;
               
        }
        while (statusdoJogo == Status.CONTINUE) {
            somadePontos = jogaOsDados();
            
            if (somadePontos == meusPontos) 
                statusdoJogo = Status.GANHOU;
            else
                if (somadePontos == SEVEN)
                    statusdoJogo = Status.PERDEU;
            
        }
        if(statusdoJogo == Status.GANHOU)
            System.out.println("Voce ganhou!! :)");
        else
            System.out.println("Voce perdeu!!");
            
        
        
        }
        
    


public int jogaOsDados() {

int dado1 = 1 + randomNumbers.nextInt(6);
int dado2 = 1+ randomNumbers.nextInt(6);

int soma = dado1 + dado2;

System.out.printf("Sua jogada: %d + %d = %d\n",dado1,dado2,soma);
aposta(soma);
return soma;        
}


public int aposta(int meusPontos){
    int p,n;
    Scanner input = new Scanner(System.in);
    if(meusPontos > 0) {
        System.out.println("Você pode apostar, pois os seus pontos são : !"+meusPontos);
        System.out.println("Quanto você quer apostar ?  ");
        p = input.nextInt();
        n = meusPontos - p;
        meusPontos = n;
        return p;
      
    }
    else 
        System.out.println("Voce não pode apostar :)");
    return 0;
    
    
}


}



