# exercicio-api-compras

# enunciado:

API de Pagamentos

A Let's Code em parceria com o Banco do Brasil está lançando a API Pague Certo! Assim como outras APIs de pagamentos existentes no mercado, 
o objetivo é terceirizar a validação e pagamento de uma compra. 
De forma que o lojista não precisa se preocupar com tal funcionalidade em seu site.

As formas de pagamento aceitas são: débito, crédito a vista, crédito parcelado, carteira virtual. 

Compras no débito tem 10% de desconto. 
Cartão à vista, 5%. 
Cartão parcelado tem acréscimo de 1% por parcela. 

O frete para a mesma cidade, é grátis. 
Mesmo estado, custo de 5% da compra. 
Estados diferentes, +10% da compra. 

Empregados da Let's Code ou do Banco do Brasil têm direito ao desconto de funcionário, correspondente a 20% da compra.

Desenvolva a funcionalidade para realizar compra. 
Considere que o cliente tem uma conta única e o saldo é compartilhado por todas as formas de pagamento.

- Não é necessário desenvolver nada web (apesar do nome API)
- Armazene os dados em coleções (não usaremos bancos de dados nem arquivos)



Cliente (nome, email, cpf, data de nascimento, endereço)
Conta (cliente, saldo)
Forma de Pagamento (débito, crédito a vista, crédito parcelado, carteira virtual)
Lojista (nome fantasia, razão social, cnpj, endereço)
Empregado (nome, email, cpf, matrícula)
Endereço (logradouro, número, cidade, cep, estado, complemento)
Produto (nome, código, preço unitário)
Compra (lojista, cliente, forma de pagamento, quantidade de parcelas, total, produtos e quantidades)
