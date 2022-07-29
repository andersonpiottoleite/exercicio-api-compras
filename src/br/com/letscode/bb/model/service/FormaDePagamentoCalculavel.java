package br.com.letscode.bb.model.service;

import br.com.letscode.bb.model.compra.Compra;

import java.math.BigDecimal;

public interface FormaDePagamentoCalculavel {

    BigDecimal calcularFormaPGTO(Compra compra, BigDecimal valorTotalCompra);
}
