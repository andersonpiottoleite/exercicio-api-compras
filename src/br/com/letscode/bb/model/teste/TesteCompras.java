package br.com.letscode.bb.model.teste;

import br.com.letscode.bb.model.compra.Compra;
import br.com.letscode.bb.model.conta.Conta;
import br.com.letscode.bb.model.enumerador.FormaPagamentoEnum;
import br.com.letscode.bb.model.exception.SaldoInsuficienteException;
import br.com.letscode.bb.model.factory.CompraFactory;
import br.com.letscode.bb.model.factory.ContaFactory;
import br.com.letscode.bb.model.pessoa.*;
import br.com.letscode.bb.model.produto.Produto;
import br.com.letscode.bb.model.service.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TesteCompras {

    public static void main(String[] args) {
        Endereco endereco = new Endereco(
                "0622646",
                "Rua eldorado",
                "08",
                "Travessa 8",
                "Rochdalle",
                "Osasco",
                "SP"
        );

        Endereco enderecoLojista = new Endereco(
                "0622646",
                "Rua eldorado",
                "08",
                "Travessa 8",
                "Rochdalle",
                "Três Corações",
                "MG"
        );


        Pessoa cliente = new Cliente("Anderson", "piottok10@gmail.com", "35461848826", "12/03/1985", endereco);
        Pessoa empregado = new Empregado("Anderson", "piottok10@gmail.com", "35461848826", "ABC50");

        Conta contaCliente = ContaFactory.criaConta(cliente, new BigDecimal(1000));
        Conta contaEmpregado = ContaFactory.criaConta(empregado, new BigDecimal(1000));

        Lojista logista = new Lojista("Empresa LTDA", "Minha Empresa Nota 10", "58.553.630/0001-73", endereco);

        Produto produto1 = new Produto("Playstation 1", "R80", new BigDecimal(100));
        Produto produto2 = new Produto("Playstation 2", "R99", new BigDecimal(100));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Compra compra = CompraFactory.criaCompra(logista, cliente, 0, produtos);

        CalculoService calculo = new CalculoService();

        try {
            calculo.calculaValorTotal(new FormaDePagamentoPix(),compra, contaCliente);
            CompraService compraService = new CompraService();
            BigDecimal saldoAtualizado = compraService.finalizaCompra(compra, contaCliente);

            System.out.println(NumberFormat
                            .getCurrencyInstance(new Locale("pt", "br"))
                            .format(compra.getValorTotal()));

            System.out.println(NumberFormat
                            .getCurrencyInstance(new Locale("pt", "br"))
                            .format(saldoAtualizado));

        }catch (SaldoInsuficienteException e){
            System.out.println("Ocorreu um erro".concat(e.getMessage()));
        }
    }
}
