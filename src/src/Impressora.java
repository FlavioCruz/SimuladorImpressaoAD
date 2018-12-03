import java.util.List;

public class Impressora{
    public static final int TAMANHO_FILA = 32;
    public void print(List<Cliente> clientes, int posicao, int tempoSaida) {
        clientes.get(posicao).setSaidaFila(tempoSaida);
        System.out.println(clientes.get(posicao).getInicioFila() + " - "
                + clientes.get(posicao).getSaidaFila() + " Tempo de Espera: " + clientes.get(posicao).getTempoEspera());
    }
}
