package br.com.osCalabreiz.models;

public class Pizza {

	private static int numero = 1;
	private int numCardapio;
	private String sabor;
	private double preco;
	private String ingredientes;

	public Pizza(String sabor, double preco, String ingredientes) {
		this.numCardapio = Pizza.numero++;
		this.sabor = sabor;
		this.preco = preco;
		this.ingredientes = ingredientes;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public int getNumCardapio() {
		return numCardapio;
	}

	public String getSabor() {
		return sabor;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String numeroFormatado = Integer.toString(this.numCardapio);

		return numeroFormatado + " - " + this.sabor + " - " + "R$: " + this.preco + "||" + this.ingredientes + "\n\n";
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
