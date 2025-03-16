
import java.util.ArrayList;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private String dataInicio;
    private String dataFim;
    private int codigoReserva;

    public Reserva(Hospede hospede, Quarto quarto, String dataInicio, String dataFim, int codigoReserva) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.codigoReserva = codigoReserva;
    }

    public void confirmarReserva() {
        System.out.println("Reserva " + codigoReserva + " confirmada para o hóspede " + hospede.getNome());
    }

    public void alterarDatas(String novaDataInicio, String novaDataFim) {
        this.dataInicio = novaDataInicio;
        this.dataFim = novaDataFim;
        System.out.println("Datas da reserva " + codigoReserva + " alteradas.");
    }

    public void gerarComprovante() {
        System.out.println("Gerando comprovante da reserva " + codigoReserva);
    }

    // Getters e Setters (Encapsulamento)
    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
}