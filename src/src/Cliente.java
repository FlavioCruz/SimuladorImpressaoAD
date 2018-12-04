import java.io.File;

public class Cliente {

    private int inicioFila;
    private int saidaFila;
    private int tempoEspera;
    private int flag;

    public Cliente(int inicioFila) {
        this.inicioFila = inicioFila;
        this.saidaFila = 0;
        tempoEspera = 0;
    }

    public Cliente(int inicioFila, int flag) {
        this.inicioFila = inicioFila;
        this.flag = flag;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
