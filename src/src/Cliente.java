import java.io.File;

public class Cliente {

    private int inicioFila;
    private int saidaFila;
    private int tempoEspera;

    public Cliente(int inicioFila) {
        this.inicioFila = inicioFila;
        this.saidaFila = 0;
        tempoEspera = 0;
    }

    public Cliente(int inicioFila, int saidaFila) {
        this.inicioFila = inicioFila;
        this.saidaFila = saidaFila;
        tempoEspera = saidaFila - inicioFila;
    }

    public int getInicioFila() {
        return inicioFila;
    }

    public void setInicioFila(int inicioFila) {
        this.inicioFila = inicioFila;
    }

    public int getSaidaFila() {
        return saidaFila;
    }

    public void setSaidaFila(int saidaFila) {
        this.saidaFila = saidaFila;
        this.tempoEspera = this.saidaFila - this.inicioFila;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }
}
