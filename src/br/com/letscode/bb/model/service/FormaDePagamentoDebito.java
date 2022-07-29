package br.com.letscode.bb.model.service;

import br.com.letscode.bb.model.compra.Compra;

import java.math.BigDecimal;

public class FormaDePagamentoDebito implements FormaDePagamentoCalculavel{

    @Override
    public BigDecimal calcularFormaPGTO(Compra compra, BigDecimal valorTotalCompra) {
        return  valorTotalCompra.subtract(valorTotalCompra.multiply(new BigDecimal(0.10)));
    }
}
