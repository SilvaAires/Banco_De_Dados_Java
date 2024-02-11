package SistemaBD_Consultorio.Modelo;

public class Paciente {
    private String cpf;
    private String nome;

    public Paciente() {
    }

    public Paciente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "cpf: " + this.cpf + " nome: " + this.nome ;
    }
}
