package br.com.letscode.bb.model.compra;

import br.com.letscode.bb.model.enumerador.FormaPagamentoEnum;
import br.com.letscode.bb.model.pessoa.Lojista;
import br.com.letscode.bb.model.pessoa.Pessoa;
import br.com.letscode.bb.model.produto.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private Lojista lojista;
    private Pessoa pessoa;
    private Integer quantidadeParcelas;
    private BigDecimal valorTotal;
    private List<Produto> produtos = new ArrayList<>();

    public Compra(Lojista lojista, Pessoa pessoa, Integer quantidadeParcelas, List<Produto> produtos) {
        this.lojista = lojista;
        this.pessoa = pessoa;
        this.quantidadeParcelas = quantidadeParcelas;
        this.produtos = produtos;
    }

    public Lojista getLojista() {
        return lojista;
    }

    public void setLojista(Lojista lojista) {
        this.lojista = lojista;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
