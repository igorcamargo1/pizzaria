package br.com.osCalabreiz.models;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	private List<Pizza> pizzas = new ArrayList<>();

	public Cardapio() {
		// TODO Auto-generated constructor stub
		this.pizzas = new ArrayList<Pizza>();
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void adiciona(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getPizzas().toString();
	}


}
