import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Random rdn = new Random();
        int initialPush = 1;
        List<Cliente> clientes = new ArrayList<>();
        List<Cliente> listaSaida = new ArrayList<>();
        Impressora impressora = new Impressora();

//        JFrame frame = new JFrame("CUZOES");
//
//        //2. Optional: What happens when the frame closes?
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JFrame.setDefaultLookAndFeelDecorated(true);
//
//        Label l = new Label();
//        frame.getContentPane().add( l, BorderLayout.CENTER);
//
//        frame.pack();
//        frame.setVisible(true);

        for (int i = 0; i < 5; i++){
            clientes.add(new Cliente(0));
        }

        int j = 0;
        for(int i = initialPush; i < (clientes.size() + initialPush); i++){
            int randomModValue = Ambiente.geraAleatorio(i) % (clientes.size() * i);
            impressora.print(clientes, j, i);

            if(randomModValue % 2 == 0){
                Ambiente.adicionaNaFila(clientes, i);
                if(randomModValue % 3 == 0){
                    Ambiente.adicionaNaFila(clientes, i);
                }
            }
            j++;
        }

        int media = 0;

        for(Cliente c : clientes){
            media += c.getTempoEspera();
        }
        media /= clientes.size();

        System.out.println("Tempo médio de espera na fila: " + media);
    }
}
