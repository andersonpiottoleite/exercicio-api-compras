package br.com.letscode.bb.model.service;

import br.com.letscode.bb.model.compra.Compra;
import br.com.letscode.bb.model.conta.Conta;
import br.com.letscode.bb.model.enumerador.FormaPagamentoEnum;
import br.com.letscode.bb.model.exception.SaldoInsuficienteException;
import br.com.letscode.bb.model.pessoa.Cliente;
import br.com.letscode.bb.model.pessoa.Empregado;
import br.com.letscode.bb.model.produto.Produto;

import java.math.BigDecimal;

public class CalculoService {

    public void calculaValorTotal(FormaDePagamentoCalculavel formaDePagamentoCalculavel, Compra compra, Conta conta) throws SaldoInsuficienteException {

        BigDecimal valorTotalCompra = new BigDecimal(0);
        for (Produto produto: compra.getProdutos()) {
            valorTotalCompra = valorTotalCompra.add(produto.getPreco());
        }

        valorTotalCompra = calcularFormaPGTO(formaDePagamentoCalculavel , compra, valorTotalCompra);
        valorTotalCompra = calcularFrete(compra, valorTotalCompra);
        valorTotalCompra = calculaDescontoEmpregado(compra, valorTotalCompra);
        validaSaldo(valorTotalCompra, conta);
        compra.setValorTotal(valorTotalCompra);
    }

    private void validaSaldo(BigDecimal valorTotalCompra, Conta conta) throws SaldoInsuficienteException {
        int analiseSaldo = conta.getSaldo().compareTo(valorTotalCompra);
        if (analiseSaldo < 0){
            throw new SaldoInsuficienteException("Saldo insuficiente ".concat(String.valueOf(conta.getSaldo())));
        }
    }

    private BigDecimal calculaDescontoEmpregado(Compra compra, BigDecimal valorTotalCompra) {
        if (compra.getPessoa() instanceof Empregado){
            valorTotalCompra = valorTotalCompra.subtract(valorTotalCompra.multiply(new BigDecimal(0.20)));
        }
        
        return valorTotalCompra;
    }

    private BigDecimal calcularFrete(Compra compra, BigDecimal valorTotalCompra) {
        if(compra.getPessoa() instanceof Cliente){
            Cliente cliente = (Cliente) compra.getPessoa();

            boolean mesmaCidade = cliente.getEndereco().getCidade().equals(
                    compra.getLojista().getEndereco().getCidade());

            boolean mesmoEstado = cliente.getEndereco().getEstado().equals(
                    compra.getLojista().getEndereco().getEstado());

            if (!mesmaCidade && mesmoEstado){
                valorTotalCompra = valorTotalCompra.add(valorTotalCompra.multiply(new BigDecimal(0.05)));

            } else if (!mesmaCidade && !mesmoEstado){
                valorTotalCompra = valorTotalCompra.add(valorTotalCompra.multiply(new BigDecimal(0.10)));
            }

        }
        return valorTotalCompra;
    }

    private BigDecimal calcularFormaPGTO(FormaDePagamentoCalculavel formaDePagamentoCalculavel, Compra compra, BigDecimal valorTotalCompra) {
        return formaDePagamentoCalculavel.calcularFormaPGTO(compra, valorTotalCompra);
    }
}
