package br.com.letscode.bb.model.service;

import br.com.letscode.bb.model.compra.Compra;

import java.math.BigDecimal;

public class FormaDePagamentoCreditoParcelado implements FormaDePagamentoCalculavel{

    @Override
    public BigDecimal calcularFormaPGTO(Compra compra, BigDecimal valorTotalCompra) {
        Integer quantidadeParcelas = compra.getQuantidadeParcelas();
        BigDecimal parcela = valorTotalCompra.divide(new BigDecimal(quantidadeParcelas));

        for (int i = 0; i < quantidadeParcelas; i++) {
            valorTotalCompra = valorTotalCompra.add(parcela.multiply(new BigDecimal(0.01)));
        }

        return  valorTotalCompra;
    }
}
