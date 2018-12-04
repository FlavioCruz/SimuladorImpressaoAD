import java.util.List;

public class Impressora{
    public static int tamanhoFila = 0;
    public void print(List<Cliente> clientes, int posicao, int tempoSaida) {
        try{
            if(clientes.get(posicao).getFlag() == 0){
                clientes.get(posicao).setSaidaFila(tempoSaida);
                System.out.println(clientes.get(posicao).getInicioFila() + " - "
                        + clientes.get(posicao).getSaidaFila() + " Tempo de Espera: " + clientes.get(posicao).getTempoEspera());
            }
            clientes.get(posicao).setFlag(clientes.get(posicao).getFlag() - 1);
        }catch (Exception e){
            return;
        }
    }
}
