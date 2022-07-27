package br.com.letscode.bb.model.factory;

import br.com.letscode.bb.model.compra.Compra;
import br.com.letscode.bb.model.enumerador.FormaPagamentoEnum;
import br.com.letscode.bb.model.pessoa.Lojista;
import br.com.letscode.bb.model.pessoa.Pessoa;
import br.com.letscode.bb.model.produto.Produto;

import java.util.List;

public class CompraFactory {

    public static Compra criaCompra(Lojista lojista, Pessoa pessoa, FormaPagamentoEnum formaPagamento, Integer quantidadeParcelas, List<Produto> produtos){
        return new Compra(lojista, pessoa, formaPagamento, quantidadeParcelas, produtos);
    }
}
