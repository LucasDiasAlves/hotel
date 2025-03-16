

public class CheckOut {
    private Reserva reserva;
    private String dataCheckOut;
    private double valorTotal;

    public CheckOut(Reserva reserva, String dataCheckOut, double valorTotal) {
        this.reserva = reserva;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
    }

    public void registrarSaida() {
        System.out.println("Check-out realizado para a reserva " + reserva.getCodigoReserva());
    }

    public void calcularConsumo(double consumo) {
        this.valorTotal += consumo;
    }

    public void gerarNotaFiscal() {
        System.out.println("Nota fiscal gerada no valor de: " + valorTotal);
    }

    // Getters e Setters (Encapsulamento)
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}