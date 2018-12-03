import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ambiente {

    private static List<Integer> numerosAleatorios = new ArrayList<>();

    public static List<Cliente> clientesRetornados = new ArrayList<>();
    public static Boolean isFilaCheia = false;

    public static void adicionaNaFila(List<Cliente> clientes, int horaEntrada){
        if(numClientesNaoAtendidos(clientes) >= Impressora.tamanhoFila){
            System.out.println("Fila cheia");
            clientesRetornados.add(new Cliente(horaEntrada));
            isFilaCheia = true;
            return;
        }
        isFilaCheia = false;
        clientes.add(new Cliente(horaEntrada));
    }

    public static int numClientesNaoAtendidos(List<Cliente> clientes){
        int retorno = 0;
        for(Cliente c : clientes){
            if(c.getSaidaFila() == 0){
                retorno++;
            }
        }
        return retorno;
    }

    public static int geraAleatorio(int c){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
        String dataFormatada = sdf.format(hora).substring(2).replace(":", "");
        int m = Integer.parseInt(dataFormatada),
                a = 16807;
        int seed = !numerosAleatorios.isEmpty() ? numerosAleatorios.get(numerosAleatorios.size() - 1) : 4;
        seed = metodoCongruenteLinear(m, a, c, seed);
        numerosAleatorios.add(seed);
        return seed;
    }

    private static int metodoCongruenteLinear(int m, int a, int c, int seed){
        return ((a * seed) + c) % m;
    }

    public static void setTamanhoFila(int tamanho){
        Impressora.tamanhoFila = tamanho;
    }
}
