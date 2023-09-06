package util;

public class Fluxo {
    private double saldo = 237.48;

    public double getValorConta() {
        return saldo;
    }
    public Fluxo() {
    }
    public void addValorC(double entradaConta){
    this.saldo += entradaConta;
    }
    public void removeValorC(double saidaConta){
    this.saldo -= saidaConta+5;
    }

}
// Rodrigo Rodrigues R Dutra - copyright