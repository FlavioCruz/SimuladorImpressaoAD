import java.util.List;

public class Impressora{
    public static int tamanhoFila = 0;
    public void print(List<Cliente> clientes, int posicao, int tempoSaida) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            return;
        }
        clientes.get(posicao).setSaidaFila(tempoSaida);
        System.out.println(clientes.get(posicao).getInicioFila() + " - "
                + clientes.get(posicao).getSaidaFila() + " Tempo de Espera: " + clientes.get(posicao).getTempoEspera());
    }
}
