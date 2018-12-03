import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in);
        System.out.println("Deseja executar a simulação por quanto tempo? ");
        int limite = tc.nextInt();
        System.out.println("Qual o tamanho máximo da fila? ");
        int tamanhoFila = tc.nextInt();
        Ambiente.setTamanhoFila(tamanhoFila);
        executaSimulacao(limite);
    }

    public static void executaSimulacao(int limite){
        List<Cliente> clientes = new ArrayList<>();
        Impressora impressora = new Impressora();
        for (int i = 0; i < 1; i++){
            clientes.add(new Cliente(0));
        }

        int j = 0, k = 0, maiorEspera = 0, menorEspera = 999;
        for(int i = 0; i <= limite; i++){
            k++;
            if(Ambiente.numClientesNaoAtendidos(clientes) > 0){
                impressora.print(clientes, j, k);
                maiorEspera = maiorEspera < clientes.get(j).getTempoEspera() ? clientes.get(j).getTempoEspera() : maiorEspera;
                menorEspera = menorEspera > clientes.get(j).getTempoEspera() ? clientes.get(j).getTempoEspera() : menorEspera;
                j++;
            }
            int randomModValue = Ambiente.geraAleatorio(i) % (clientes.size() * k);

            if(Ambiente.clientesRetornados.isEmpty()){
                if(randomModValue % 2 == 0){
                    Ambiente.adicionaNaFila(clientes, k);
                    if(randomModValue % 3 == 0){
                        Ambiente.adicionaNaFila(clientes, k);
                    }
                }
            }else{
                while(Ambiente.isFilaCheia){
                    Ambiente.adicionaNaFila(clientes, k);
                    Ambiente.clientesRetornados.remove(0);
                }
            }
        }
        int media = 0;

        for(Cliente c : clientes){
            media += c.getTempoEspera();
        }
        media /= clientes.size();

        System.out.println("Maior espera foi: " + maiorEspera + " e menor espera foi: " + menorEspera);
        System.out.println("Tempo médio de espera na fila: " + media);
    }
}
