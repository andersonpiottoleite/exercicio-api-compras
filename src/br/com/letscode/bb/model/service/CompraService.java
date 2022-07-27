package br.com.letscode.bb.model.service;

import br.com.letscode.bb.model.compra.Compra;
import br.com.letscode.bb.model.conta.Conta;

import java.math.BigDecimal;

public class CompraService {

    public BigDecimal finalizaCompra(Compra compra, Conta conta){
        conta.setSaldo(conta.getSaldo().subtract(compra.getValorTotal()));
        return conta.getSaldo();
    }
}
