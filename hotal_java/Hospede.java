

public class Hospede {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Hospede(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public void atualizarEndereco(String novoEndereco) {
        System.out.println("Endereço atualizado para: " + novoEndereco);
    }

    public void visualizarReservas() {
        System.out.println("Visualizando reservas do hóspede " + nome);
    }

    public void cancelarReserva(int codigoReserva) {
        System.out.println("Reserva " + codigoReserva + " cancelada.");
    }

    // Getters e Setters (Encapsulamento)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}