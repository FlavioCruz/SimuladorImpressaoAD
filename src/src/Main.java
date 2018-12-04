import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner tc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Deseja executar a simulação por quanto tempo? ");
        int limite = tc.nextInt();
        System.out.println("Qual o tamanho máximo da fila? ");
        int tamanhoFila = tc.nextInt();
        System.out.println("Qual a taxa de entrada na fila? ");
        int entradaFila = tc.nextInt();
        System.out.println("Qual a taxa de serviço? ");
        Double servico = tc.nextDouble();
        Ambiente.setTamanhoFila(tamanhoFila);
        executaSimulacao(limite, entradaFila, servico);
    }

    public static void executaSimulacao(int limite, int entrada, Double servico){
        List<Cliente> clientes = new ArrayList<>();
        Impressora impressora = new Impressora();
        for (int i = 0; i < 1; i++){
            clientes.add(new Cliente(0));
        }

        int j = 0, k = 0, maiorEspera = 0, menorEspera = 999;
        for(int i = 0; i <= limite; i++){
            k++;
            Double randomModValue = Ambiente.geraAleatorio(i) % (clientes.size() * k);
            //Integer temp = randomModValue.toString().length() >= 5 ? 5 : randomModValue.toString().length();
            //Integer iRandomMod = Integer.parseInt(randomModValue.toString().substring(0, temp).replace(".", ""));
            //Integer iServico = (randomModValue * servico) < 0 ? 2 : (int)(randomModValue * servico);
            if(Ambiente.clientesRetornados.isEmpty()){
//                if(randomModValue % 2 == 0){
//                    Ambiente.adicionaNaFila(clientes, k);
//                    if(randomModValue % 3 == 0){
//                    }
//                }
                for(int n = 0; n < randomModValue % entrada; n++){
                    Ambiente.adicionaNaFila(clientes, k);
                }
            }else{
                do{
                    if(!Ambiente.clientesRetornados.isEmpty()){
                        Ambiente.adicionaNaFila(clientes, k);
                        Ambiente.clientesRetornados.remove(0);
                    }else{
                        break;
                    }
                }while(!Ambiente.isFilaCheia);
            }
            if(Ambiente.numClientesNaoAtendidos(clientes) > 0){
                int tempCNA = Ambiente.numClientesNaoAtendidos(clientes);
                for(int t = 0; t < randomModValue % servico; t++){
                    if(!clientes.isEmpty() || j < clientes.size()){
                        try{
                            impressora.print(clientes, j, k);
                            maiorEspera = maiorEspera < clientes.get(j).getTempoEspera() ? clientes.get(j).getTempoEspera() : maiorEspera;
                            menorEspera = menorEspera > clientes.get(j).getTempoEspera() ? clientes.get(j).getTempoEspera() : menorEspera;
                            if(tempCNA != Ambiente.numClientesNaoAtendidos(clientes)){
                                j++;
                            }
                        }catch (Exception e){

                        }
                    }
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
        System.out.println("Clientes não antendidos: " + Ambiente.numClientesNaoAtendidos(clientes));
    }
}
