package com.nunespc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {
	private Scanner entrada;
	private boolean executar;
	private List<Dados> dados;
	
	public static void main(String[] args) {
		new CadastroCliente();
		
	}
	private CadastroCliente() {
		entrada = new Scanner(System.in);
		executar = true;
		dados = new ArrayList<Dados>();
		System.out.println("BEM VINDO AO CADASTRO DE USUARIO");
		
		while(executar) {
			String opcao = menu();
			if(opcao.equalsIgnoreCase("n")){
				cadastrar();	
				
			}else if(opcao.equalsIgnoreCase("l")) {
				listar();
			
			}else if(opcao.equalsIgnoreCase("x")) {
				executar = false;
				
			}else {
				System.out.println("Opção invalida!");
			}
		}
	}
		private String menu() {
			System.out.println("Selecione a opção");
			System.out.println("N - Novo cadastro");
			System.out.println("L - Lista Cadastro");
			System.out.println("X - Sair");
			System.out.printf("Digite (N), (L) ou (X): ");
			
		return entrada.nextLine();
			
		}
		private void cadastrar() {
			boolean cadastrando = true;
			
			while(cadastrando) {
				System.out.println("Cadastro de Usuário");
				Dados dado = new Dados();
				dado.setNome(textInput("Nome:"));
				dado.setLogin(textInput("Login:"));
				dado.setCargo(textInput("Cargo:"));
				
				String cadastrar = textInput("Adicionar cadastro (S/N) ?");
				if(cadastrar.equalsIgnoreCase("s")) {
					System.out.println("Cadastro adicionado");
					dados.add(dado);
				}else if (cadastrar.equalsIgnoreCase("n")){
					System.out.println("Cadastro ignorado !!!");
				}else {
					System.out.println("\n Opção inválida, digite denovo!!! \n");
				}
				
			String continua = textInput("Continuar cadastrando (S/N) ?");
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("s")){
				
			} else {
				System.out.println("\n Opção inválida, eu vou sair!!! \n");
				cadastrando = false;
			}
		}
	}
		
		private void listar() {
			if (dados.size() == 0) {
				System.out.println("\n Não existem cadastros!!! \n");
			} else {
				System.out.println("\n Lista de Cadastros \n");
				for (int i = 0; i < dados.size(); i++) {
					Dados d = dados.get(i);
					System.out.println("Cadastro número: " + (i + 1));
					System.out.println("\tNome: " + d.getNome());
					System.out.println("\tLogin: " + d.getLogin());
					System.out.println("\tCargo: " + d.getCargo()+"\n");
				}
				System.out.println("\n Fim da lista \n");
			}
			
		}
		private String textInput(String label) {
			System.out.println(label);
			return entrada.nextLine();
		}
			
}
