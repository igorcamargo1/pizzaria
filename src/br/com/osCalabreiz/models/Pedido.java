package br.com.osCalabreiz.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {

	private Cliente cliente;
	private List<Pizza> cardapio;
	private List<Pizza> carrinho;
	private double precoTotal;
	private Scanner scan;
	private String tipoPagamento;

	public Pedido(List<Pizza> cardapio, Cliente cliente) {
		// TODO Auto-generated constructor stub
		this.scan = new Scanner(System.in);
		this.cliente = cliente;
		this.cardapio = cardapio;
		this.carrinho = new ArrayList<Pizza>();
		this.precoTotal = 0;
	}

	public void recibo() {
		limpaTela();
		System.out.println();
		System.out.println("======== RECIBO ========");
		System.out.println("== DADOS DO CLIENTE ==");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Cpf: " + this.cliente.getCpf());
		System.out.println("Endereço: " + this.cliente.getEndereco());
		System.out.println("=======================");
		System.out.println("== DADOS DA COMPRA ====");
		for (Pizza pizza : this.carrinho) {
			System.out.println("=");
			System.out.println((this.carrinho.indexOf(pizza) + 1) + " - " + pizza.getSabor());
			System.out.println("R$: " + pizza.getPreco());
			System.out.println("=");
		}
		System.out.println("=======================");
		System.out.println("TOTAL: " + this.precoTotal + " reais");
		System.out.println("Tipo pagamento: " + this.tipoPagamento);
		System.out.println("=======================");
		System.out.println();
	}

	public void adicionaPedido() throws InterruptedException {

		int maisPizza = 1;

		while (maisPizza == 1) {
			int tipoPizza = tipoPizza();
			Pizza pizzaEscolhida = pizzaEscolhida(tipoPizza);
			this.carrinho.add(pizzaEscolhida);
			this.precoTotal += pizzaEscolhida.getPreco();
			int opcao = 2;
			while (opcao != 1 && opcao != 0) {
				System.out.println();
				System.out.println("===== DESEJA ADICIONAR MAIS UMA PIZZA AO SEU PEDIDO? =====");
				System.out.println("=== 1 - SIM");
				System.out.println("=== 0 - NÃO");
				opcao = scan.nextInt();
				maisPizza = opcao;
			}

		}
		limpaTela();
		menu();
	}

	public void removeItemCarrinho() throws InterruptedException {
		System.out.println();
		System.out.println("===== DIGITE QUAL ITEM DESEJA REMOVER =====");
		int i = 1;
		for (Pizza pizza : this.carrinho) {
			System.out.println((i++) + " - " + pizza.getSabor());
			System.out.println("R$: " + pizza.getPreco());
		}
		int numero = scan.nextInt();
		Pizza pizza = this.carrinho.get(numero - 1);
		this.precoTotal -= pizza.getPreco();
		this.carrinho.remove(numero - 1);
		menu();
	}

	public void verCarrinho() throws InterruptedException {
		limpaTela();
		System.out.println();
		System.out.println("===== CARRINHO =====");
		int i = 1;
		for (Pizza pizza : this.carrinho) {
			System.out.println((i++) + " - " + pizza.getSabor());
			System.out.printf("R$: %.2f%n", pizza.getPreco());
		}
		System.out.println("TOTAL: " + this.precoTotal + " reais");
		System.out.println("=======================");
		Thread.sleep(1500);
		menu();
	}

	public void pagamento() throws InterruptedException {
		System.out.println();
		System.out.println("===== ESCOLHA O TIPO DE PAGAMENTO");
		System.out.println("=== 1 - Cartão de Debito");
		System.out.println("=== 2 - Cartão Crédito");
		System.out.println("=== 3 - Dinheiro");
		System.out.println("=== 4 - PIX (10% de desconto)");

		int opcao = scan.nextInt();
		switch (opcao) {
		case (1):
			System.out.println("Conectando ao sistema...");
			Thread.sleep(3000);
			System.out.println("Aproxime ou insira seu cartão...");
			Thread.sleep(2000);
			System.out.println("Pagamento realizado, retire seu cartão.");
			this.tipoPagamento = "Cartão de Débito";
			break;

		case (2):
			System.out.println("Conectando ao sistema...");
			Thread.sleep(3000);
			System.out.println("Aproxime ou insira seu cartão...");
			Thread.sleep(2000);
			System.out.println("Pagamento realizado, retire seu cartão.");
			this.tipoPagamento = "Cartão de Crédito";
			break;

		case (3):
			int opcaoTroco = 0;
			while (opcaoTroco != 1 && opcaoTroco != 2) {
				System.out.println("===== PRECISA DE TROCO?");
				System.out.println("===== 1 - SIM");
				System.out.println("===== 2 - NÃO");
				opcaoTroco = scan.nextInt();
			}
			if (opcaoTroco == 1) {
				double troco = 0;
				while (troco < this.precoTotal) {
					System.out.println("===== TROCO PARA QUANTO?");
					System.out.printf("Valor total: %.2f%n", this.precoTotal);
					troco = scan.nextInt();
					if (troco < this.precoTotal) {
						System.out.println(
								"Valor menor que o preço total do pedido, por favor, adicione mais dinheiro...");
					}
				}
				double trocoTotal = troco - this.precoTotal;
				System.out.printf("===== SEU TROCO FOI DE: R$ %.2f%n", trocoTotal);
				this.tipoPagamento = "Dinheiro";
				Thread.sleep(3000);
			}
			break;
		case (4):
			this.precoTotal -= (this.precoTotal * 0.10);
			System.out.println("===== CHAVE PIX =====");
			System.out.println("OsCalabreiz LTDA");
			System.out.println("11933455567");
			System.out.printf("===== VALOR: R$ %.2f%n", this.precoTotal);
			Thread.sleep(3000);
			System.out.println("Pagamento Recebido!");
			this.tipoPagamento = "Pix";
			Thread.sleep(3000);
			break;
		}
		recibo();
	}

	public void menu() throws InterruptedException {
		System.out.println();
		System.out.println("===== ESCOLHA A PRÓXIMA ETAPA =====");
		System.out.println("=== 1 - VER CARRINHO ");
		System.out.println("=== 2 - ADICIONAR ITEM AO CARRINHO ");
		System.out.println("=== 3 - REMOVER ITEM DO CARRINHO ");
		System.out.println("=== 4 - IR PARA PAGAMENTO ");
		int numero = scan.nextInt();
		switch (numero) {
		case (1):
			verCarrinho();
			break;
		case (2):
			adicionaPedido();
			break;
		case (3):
			if (this.carrinho.size() == 1) {
				System.out.println("Você tem apenas um item no seu carrinho, não é possível remover");
				menu();
				break;
			}
			removeItemCarrinho();
			break;
		case (4):
			try {
				pagamento();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public int tipoPizza() {
		limpaTela();
		System.out.println();
		System.out.println("===== ESCOLHA SUA PIZZA =====");
		int tipoPizza = 0;
		while (tipoPizza != 1 && tipoPizza != 2) {
			System.out.println("Por favor, escolha entre:");
			System.out.println("=== 1 - PIZZA INTEIRA");
			System.out.println("=== 2 - PIZZA MEIO A MEIO");
			tipoPizza = scan.nextInt();
		}
		limpaTela();
		return tipoPizza;

	}

	public Pizza pizzaEscolhida(int tipoPizza) {
		limpaTela();
		Pizza pizzaEscolhida = new Pizza();

		if (tipoPizza == 1) {
			int sabor = 0;
			while (sabor < 1 || sabor > 10) {
				System.out.println();
				System.out.println("===== ESCOLHA O SABOR =====");
				System.out.println("selecione o número do sabor desejado");
				System.out.println(this.cardapio);
				sabor = scan.nextInt();
			}
			pizzaEscolhida = this.cardapio.get(sabor - 1);
			return pizzaEscolhida;
		} else {
			int sabor1 = 0;
			while (sabor1 < 1 || sabor1 > 10) {
				System.out.println();
				System.out.println("====== ESCOLHA O SABOR =====");
				System.out.println("selecione o número da 1ª metade");
				System.out.println(this.cardapio);
				sabor1 = scan.nextInt();
			}
			limpaTela();
			int sabor2 = 0;
			while (sabor2 < 1 || sabor2 > 10) {
				System.out.println();
				System.out.println("====== ESCOLHA O SABOR =====");
				System.out.println("selecione o número da 2ª metade");
				System.out.println(this.cardapio);
				sabor2 = scan.nextInt();
			}

			Pizza pizzaMetade1 = this.cardapio.get(sabor1 - 1);
			Pizza pizzaMetade2 = this.cardapio.get(sabor2 - 1);
			if (pizzaMetade1.getSabor().compareTo(pizzaMetade2.getSabor()) == 0) {
				pizzaEscolhida.setSabor(pizzaMetade1.getSabor());
			} else {
				pizzaEscolhida.setSabor("meia " + pizzaMetade1.getSabor() + "e meia " + pizzaMetade2.getSabor());
			}
			if (pizzaMetade1.getPreco() > pizzaMetade2.getPreco()) {
				pizzaEscolhida.setPreco(pizzaMetade1.getPreco());
			}
			pizzaEscolhida.setPreco(pizzaMetade2.getPreco());

		}
		return pizzaEscolhida;
	}

	public void limpaTela() {
		List<String> limpaTela = new ArrayList<String>();
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}
}
