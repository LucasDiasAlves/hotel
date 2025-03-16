import java.util.ArrayList;

public class Hotel {
    private ArrayList<Hospede> hospedes;
    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;
    private ArrayList<CheckIn> checkins;
    private ArrayList<CheckOut> checkouts;

    public Hotel() {
        this.hospedes = new ArrayList<>();
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.checkins = new ArrayList<>();
        this.checkouts = new ArrayList<>();
    }

    

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public void cancelarHospede(String cpf) {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                hospedes.remove(hospede);
                System.out.println("Hóspede cancelado com sucesso.");
                return;
            }
        }
        System.out.println("Hóspede não encontrado.");
    }
    
    public void atualizarHospede(String cpf, String novoNome, String novoTelefone, String novoEmail) {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                hospede.setNome(novoNome);
                hospede.setTelefone(novoTelefone);
                hospede.setEmail(novoEmail);
                System.out.println("Dados do hóspede atualizados com sucesso.");
                return;
            }
        }
        System.out.println("Hóspede não encontrado.");
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }
    
    public void atualizarQuarto(int numero, String novoTipo, int novaCapacidade, double novoPreco) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quarto.setTipo(novoTipo);
                quarto.setCapacidade(novaCapacidade);
                quarto.setPreco(novoPreco);
                System.out.println("Dados do quarto atualizados com sucesso.");
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public void realizarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Getters e Setters (Encapsulamento)
    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public void mostrarHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("Nenhum hóspede cadastrado.");
        } else {
            System.out.println("Lista de Hóspedes:");
            for (Hospede hospede : hospedes) {
                System.out.println("Nome: " + hospede.getNome() + ", CPF: " + hospede.getCpf() +
                        ", Telefone: " + hospede.getTelefone() + ", Email: " + hospede.getEmail());
            }
        }
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public void mostrarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            System.out.println("Lista de Quartos:");
            for (Quarto quarto : quartos) {
                System.out.println("Número: " + quarto.getNumero() + ", Tipo: " + quarto.getTipo() +
                        ", Capacidade: " + quarto.getCapacidade() + ", Preço: " + quarto.getPreco());
            }
        }
    }

    public void cancelarQuarto(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quartos.remove(quarto);
                System.out.println("Quarto cancelado com sucesso.");
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            System.out.println("Lista de Reservas:");
            for (Reserva reserva : reservas) {
                System.out.println("Código: " + reserva.getCodigoReserva() + ", Hóspede: " + reserva.getHospede().getNome() +
                        ", Quarto: " + reserva.getQuarto().getNumero() + ", Data Início: " + reserva.getDataInicio() +
                        ", Data Fim: " + reserva.getDataFim());
            }
        }
    }

    public void cancelarReserva(int codigoReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva() == codigoReserva) {
                reservas.remove(reserva);
                System.out.println("Reserva cancelada com sucesso.");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public ArrayList<CheckIn> getCheckins() {
        return checkins;
    }

    public ArrayList<CheckOut> getCheckouts() {
        return checkouts;
    }
}