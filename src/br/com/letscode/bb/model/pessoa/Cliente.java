package br.com.letscode.bb.model.pessoa;

public class Cliente extends Pessoa {
    private String dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String email, String cpf, String dataNascimento, Endereco endereco) {
        super(nome, email, cpf);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Cliente(){

    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
