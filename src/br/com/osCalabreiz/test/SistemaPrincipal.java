package br.com.osCalabreiz.test;

import br.com.osCalabreiz.models.Cardapio;
import br.com.osCalabreiz.models.Cliente;
import br.com.osCalabreiz.models.Pedido;
import br.com.osCalabreiz.models.Pizza;

public class SistemaPrincipal {

	public static void main(String[] args) throws InterruptedException {
		//================== INSTANCIANDO VARIÁVEIS ========================
		
		Cliente c1 = new Cliente();
		
		Cardapio cardapio = new Cardapio();

		cardapio.adiciona(new Pizza("Toscana", 50.00, "Calabresa, mussarela e cebola"));
		cardapio.adiciona(new Pizza("Pepperoni", 60.55, "Mussarela e peperoni"));
		cardapio.adiciona(new Pizza("Portuguesa", 75.50, "Presunto, mussarela, ervilha, ovo cozido fatiado"));
		cardapio.adiciona(new Pizza("Mussarela", 66.20, "Mussarela crocante"));
		cardapio.adiciona(new Pizza("Calabrezza", 45, "Calabresa e cebola"));
		cardapio.adiciona(new Pizza("Lombo c/ catupiry", 60.50, "Lombo com catupiry"));
		cardapio.adiciona(new Pizza("Atum", 50, "Atum com cebola"));
		cardapio.adiciona(new Pizza("Chocolate c/ morango", 67.78, "Chocolate com morango"));
		cardapio.adiciona(new Pizza("Coco c/ leita condensado", 43, "Coco ralado com leite condensado"));
		cardapio.adiciona(new Pizza("Chocolate c/ banana", 50, "Chocolate derretido com banana"));
		
		//==============================================================
		//===================== INÍCIO DO FLUXO ========================
		//==============================================================
		
		c1.cadastraCliente();
		
		Pedido pedido1 = new Pedido(cardapio.getPizzas(), c1);
		
		pedido1.adicionaPedido();
	}

}
