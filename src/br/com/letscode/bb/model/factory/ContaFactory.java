package br.com.letscode.bb.model.factory;

import br.com.letscode.bb.model.conta.Conta;
import br.com.letscode.bb.model.pessoa.Pessoa;

import java.math.BigDecimal;

public class ContaFactory {

    public static Conta criaConta(Pessoa pessoa, BigDecimal saldo){
        return new Conta(pessoa, saldo);
    }
}
