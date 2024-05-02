package br.com.osCalabreiz.models;

import java.util.Scanner;

public class Cliente {

	private String nome;
	private String cpf;
	private String endereco;
	private Scanner scan;

	public Cliente() {
		this.scan = new Scanner(System.in);
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void cadastraCliente() {

		System.out.println("===== CADASTRO =====");
		boolean validado = false;
		while (validado == false) {
			System.out.print("== DIGITE SEU NOME: ");
			this.nome = scan.nextLine();
			if (this.nome.isBlank() || this.nome.length() < 2) {
				System.out.println("Nome invalido, digite seu nome novamente...");
			} else {
				validado = true;
			}

		}
		validado = false;
		while (validado == false) {
			System.out.print("== DIGITE SEU CPF: ");
			this.cpf = scan.nextLine();
			if (this.cpf.isBlank() || this.cpf.length() != 11 ) {
				System.out.println("Cpf inválido(digite apenas números), digite seu cpf novamente...");
			} else {
				validado = true;
			}

		}
		validado = false;
		while (validado == false) {
			System.out.print("== DIGITE SEU ENDEREÇO(Rua/Nº): ");
			this.endereco = scan.nextLine();
			if (this.endereco.isBlank()) {
				System.out.println("Endereço inválido, digite seu endereço novamente...");
			} else {
				validado = true;
			}
		}
	}
}
