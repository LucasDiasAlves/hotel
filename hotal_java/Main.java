import java.util.Scanner;

// As classes Hospede, Quarto, Reserva, CheckIn, CheckOut e Hotel permanecem as mesmas.

public class Main {
    public static void main(String[] args) {
        // Inicializando o hotel
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Menu interativo com switch-case
        do {
            System.out.println("\n--- Menu do Hotel ---");
            System.out.println("1. Adicionar Hóspede");
            System.out.println("2. Adicionar Quarto");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Check-in");
            System.out.println("5. Check-out");
            System.out.println("6. Atualizar Dados do Hóspede");
            System.out.println("7. Atualizar Dados do Quarto");
            System.out.println("8. Mostrar Lista de Hóspedes");
            System.out.println("9. Mostrar Lista de Quartos");
            System.out.println("10. Mostrar Lista de Reservas");
            System.out.println("11. Cancelar Reserva");
            System.out.println("12. Cancelar Quarto");
            System.out.println("13. Cancelar Hóspede");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    adicionarHospede(hotel, scanner);
                    break;
                case 2:
                    adicionarQuarto(hotel, scanner);
                    break;
                case 3:
                    realizarReserva(hotel, scanner);
                    break;
                case 4:
                    realizarCheckIn(hotel, scanner);
                    break;
                case 5:
                    realizarCheckOut(hotel, scanner);
                    break;
                case 6:
                    System.out.print("Digite o CPF do hóspede: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    hotel.atualizarHospede(cpf, novoNome, novoTelefone, novoEmail);
                    break;
                case 7:
                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha
                    System.out.print("Novo tipo: ");
                    String novoTipo = scanner.nextLine();
                    System.out.print("Nova capacidade: ");
                    int novaCapacidade = scanner.nextInt();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    hotel.atualizarQuarto(numeroQuarto, novoTipo, novaCapacidade, novoPreco);
                    break;
                case 8:
                    hotel.mostrarHospedes();
                    break;
                case 9:
                    hotel.mostrarQuartos();
                    break;
                case 10:
                    hotel.mostrarReservas();
                    break;
                case 11:
                    System.out.print("Digite o código da reserva: ");
                    int codigoReserva = scanner.nextInt();
                    hotel.cancelarReserva(codigoReserva);
                    break;
                case 12:
                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    hotel.cancelarQuarto(numeroQuarto);
                    break;
                case 13:
                    System.out.print("Digite o CPF do hóspede: ");
                    String cpf = scanner.nextLine();
                    hotel.cancelarHospede(cpf);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void adicionarHospede(Hotel hotel, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Hospede hospede = new Hospede(nome, cpf, telefone, email);
        hotel.adicionarHospede(hospede);
        System.out.println("Hóspede " + nome + " adicionado com sucesso.");
    }

    public static void adicionarQuarto(Hotel hotel, Scanner scanner) {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Tipo do quarto: ");
        String tipo = scanner.nextLine();
        System.out.print("Capacidade do quarto: ");
        int capacidade = scanner.nextInt();
        System.out.print("Preço por noite: ");
        double preco = scanner.nextDouble();

        Quarto quarto = new Quarto(numero, tipo, capacidade, preco);
        hotel.adicionarQuarto(quarto);
        System.out.println("Quarto número " + numero + " adicionado com sucesso.");
    }

    public static void realizarReserva(Hotel hotel, Scanner scanner) {
        System.out.print("Digite o CPF do hóspede: ");
        String cpf = scanner.nextLine();
        Hospede hospede = null;

        for (Hospede h : hotel.getHospedes()) {
            if (h.getCpf().equals(cpf)) {
                hospede = h;
                break;
            }
        }

        if (hospede == null) {
            System.out.println("Hóspede não encontrado.");
            return;
        }

        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        Quarto quarto = null;

        for (Quarto q : hotel.getQuartos()) {
            if (q.getNumero() == numeroQuarto) {
                quarto = q;
                break;
            }
        }

        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        System.out.print("Data de início (yyyy-mm-dd): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de fim (yyyy-mm-dd): ");
        String dataFim = scanner.nextLine();
        int codigoReserva = (int) (Math.random() * 10000); // Gerar um código aleatório para a reserva

        Reserva reserva = new Reserva(hospede, quarto, dataInicio, dataFim, codigoReserva);
        hotel.realizarReserva(reserva);
        System.out.println("Reserva confirmada com código: " + codigoReserva);
    }

    public static void realizarCheckIn(Hotel hotel, Scanner scanner) {
        System.out.print("Digite o código da reserva: ");
        int codigoReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        Reserva reserva = null;

        for (Reserva r : hotel.getReservas()) {
            if (r.getCodigoReserva() == codigoReserva) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        System.out.print("Data do Check-in (yyyy-mm-dd): ");
        String dataCheckIn = scanner.nextLine();
        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();

        CheckIn checkIn = new CheckIn(reserva, dataCheckIn, observacoes);
        hotel.getCheckins().add(checkIn);
        System.out.println("Check-in realizado com sucesso.");
    }

    public static void realizarCheckOut(Hotel hotel, Scanner scanner) {
        System.out.print("Digite o código da reserva: ");
        int codigoReserva = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        Reserva reserva = null;

        for (Reserva r : hotel.getReservas()) {
            if (r.getCodigoReserva() == codigoReserva) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Reserva não encontrada.");
            return;
        }

        System.out.print("Data do Check-out (yyyy-mm-dd): ");
        String dataCheckOut = scanner.nextLine();
        System.out.print("Valor total da estadia: ");
        double valorTotal = scanner.nextDouble();

        CheckOut checkOut = new CheckOut(reserva, dataCheckOut, valorTotal);
        hotel.getCheckouts().add(checkOut);
        System.out.println("Check-out realizado com sucesso.");
        System.out.println("Nota fiscal gerada no valor de: " + valorTotal);
    }
}
