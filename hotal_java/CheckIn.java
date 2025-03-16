import java.util.ArrayList;


public class CheckIn {
    private Reserva reserva;
    private String dataCheckIn;
    private String observacoes;

    public CheckIn(Reserva reserva, String dataCheckIn, String observacoes) {
        this.reserva = reserva;
        this.dataCheckIn = dataCheckIn;
        this.observacoes = observacoes;
    }

    public void registrarEntrada() {
        System.out.println("Check-in realizado para a reserva " + reserva.getCodigoReserva());
    }

    public void verificarReserva() {
        System.out.println("Verificando reserva " + reserva.getCodigoReserva());
    }

    public void informarNumeroQuarto() {
        System.out.println("Quarto número " + reserva.getQuarto().getNumero());
    }

    // Getters e Setters (Encapsulamento)
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}