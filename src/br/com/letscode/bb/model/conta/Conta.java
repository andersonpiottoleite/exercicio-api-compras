package br.com.letscode.bb.model.conta;

import br.com.letscode.bb.model.pessoa.*;

import java.math.BigDecimal;

public class Conta {

    private Pessoa pessoa;
    private BigDecimal saldo;

    public Conta(Pessoa pessoa, BigDecimal saldo){
        this.pessoa = pessoa; // sombreamento
        this.saldo = saldo;
    }

    public Conta(){
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
