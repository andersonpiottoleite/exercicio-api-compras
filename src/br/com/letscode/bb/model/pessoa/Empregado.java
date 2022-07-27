package br.com.letscode.bb.model.pessoa;

public class Empregado extends Pessoa {

    private String matricula;

    public Empregado(String nome, String email, String cpf, String matricula) {
       super(nome, email, cpf);
       this.matricula = matricula;
    }

    public Empregado(){

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
