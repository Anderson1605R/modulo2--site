package agenciaCrud;

import java.util.Scanner;

import agenciaCrud.DAO.PacoteDeViagemDAO;
import agenciaCrud.DAO.UserDAO;

public class Main {
	 


	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int usuario;
		
		System.out.println("Digite 1 para usuário ou 2 para Agencia de Viagens ");
		usuario = scan.nextInt();
		
		
		
		if(usuario == 1) {
			int res = 0;
			do {

				  

				  

				  System.out.println("\nMenu - RochaTour\n");

				  System.out.println("1. Cadastrar Usuários");

				  System.out.println("2. Listar Usuários");

				  System.out.println("3. Atualizar Usuários");

				  System.out.println("4. Deletar Usuários");

				  System.out.println("5. Sair");


				  
				  
				  int opcao = scan.nextInt();
				  scan.nextLine();

				  

				  switch (opcao) {

				  

				  case 1:
					  System.out.println("Crie um usuário\n");
					  User usuarioCadastro = new User();
					  
					  System.out.println("Digite seu nome: ");
					  usuarioCadastro.setNome(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite seu email: ");
					  usuarioCadastro.setEmail(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite seu CPF: ");
					  usuarioCadastro.setCpf(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite sua senha: ");
					  usuarioCadastro.setSenha(scan.nextLine().trim());
					  scan.nextLine();
					  

					  UserDAO.create(usuarioCadastro);
					  System.out.println("Cadastro criado com sucesso!");

					  break;

					  

				  case 2:
					  
					  for (User u : UserDAO.getUsers()) {
						System.out.println("=== Usuário ===\n");
					
						System.out.println("Id: " + u.getId());
						System.out.println("Nome " + u.getNome());
						System.out.println("Email " + u.getEmail());
						System.out.println("CPF " + u.getCpf());
					
						System.out.println("\n==================\n");
						
					}

					
					  break;

					  

				  case 3:

					  System.out.println("Atualize seu cadastro.");
					  User usuarioUpdate = new User();
					  
					  System.out.println("Digite seu Id (Seu id pode ser visto em listar): ");
					  usuarioUpdate.setId(scan.nextInt());
					  scan.nextLine();
					  
					  System.out.println("Digite seu novo nome: ");
					  usuarioUpdate.setNome(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite novo email: ");
					  usuarioUpdate.setEmail(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite novo CPF: ");
					  usuarioUpdate.setCpf(scan.nextLine().trim());
					  scan.nextLine();
					  
					  System.out.println("Digite sua nova senha: ");
					  usuarioUpdate.setSenha(scan.nextLine().trim());
					  scan.nextLine();
					  
					  

					  UserDAO.update(usuarioUpdate);
					  System.out.println("Atualizado com sucesso!");

					  break;

					  

				  case 4:

					  System.out.println("Delete o usuário\n");
					  System.out.println("Digite o id para deletar: ");
					  UserDAO.remove(scan.nextInt());
					  scan.nextLine();
					  System.out.println("\nDeletado com sucesso! ");
					

					  break;

					  	  

				  case 5:

					  System.out.println("Você saiu do menu!");
					  
					  res = 5;

					  break;
					  
					  

				  default:

					  System.out.println("Digite um número de 1 à 5");

				  }
				}while (res!= 5);
		}else if(usuario == 2) {
			int res = 0;
			do {

				  

				  

				  System.out.println("\nMenu - RochaTour\n");		  
				  
				  System.out.println("1. Cadastrar Pacotes");

				  System.out.println("2. Listar Pacotes");

				  System.out.println("3. Atualizar Pacotes");

				  System.out.println("4. Deletar Pacotes");
				  
				  System.out.println("5. Sair");

				  
				  
				  int opcao = scan.nextInt();
				  scan.nextLine();
				  

				  switch (opcao) {

				  

				  case 1:
					  int isPromocao;
					  System.out.println("Cadastre seu pacote de viagem\n");
					  PacoteDeViagem pacoteCadastro = new PacoteDeViagem();
					  
					  System.out.println("Digite o destino: ");
					  pacoteCadastro.setDestino(scan.nextLine());
					  scan.nextLine();
					  
					  System.out.println("Digite o valor do pacote: ");
					  pacoteCadastro.setPreco(scan.nextDouble());
					  scan.nextLine();
					  
					  System.out.println("É uma promoção? Digite 1 para SIM. 2 para NÃO. ");
					  isPromocao = scan.nextInt();
					 
					  if(isPromocao == 1) {
						pacoteCadastro.setPromocao(true);
					  }else if (isPromocao == 2) {
						  pacoteCadastro.setPromocao(false);
						 
					  }else {
						  System.out.println("Selecione 1 ou 2");
					  }
					  scan.nextLine();
					  
					
					  

					  PacoteDeViagemDAO.create(pacoteCadastro);
					  System.out.println("\nPacote de viagem criado com sucesso!");

					  break;

					  

				  case 2:

					  for (PacoteDeViagem p : PacoteDeViagemDAO.getPacote()) {
							System.out.println("=== Pacote de Viagem ===\n");
						
							System.out.println("Id: " + p.getIdPacote());
							System.out.println("Destino " + p.getDestino());
							if(p.isPromocao()) {
								System.out.println("Preço Promocional: " + (p.getPreco() - p.getPreco() * 0.25));
							}else {
								System.out.println("Preço: " + p.getPreco());
							}
							
						
							System.out.println("\n==================\n");
							
						}

					  break;

					  

				  case 3:

					  System.out.println("Atualize seu Pacote de Viagem ");
					  PacoteDeViagem pacoteUpdate = new PacoteDeViagem();
					  
					  System.out.println("Digite seu Id (Seu id pode ser visto em listar): ");
					  pacoteUpdate.setIdPacote(scan.nextInt());
					  scan.nextLine();
					  
					  System.out.println("Digite seu novo Destino: ");
					  pacoteUpdate.setDestino(scan.nextLine());
					  scan.nextLine();
					  
					  System.out.println("Digite seu novo preço: ");
					  pacoteUpdate.setPreco(scan.nextDouble());
					  scan.nextLine();
					  
					  System.out.println("É uma promoção? Digite 1 para SIM. 2 para NÃO. ");
					  int isPromocaoUpdate = scan.nextInt();
					 
					  if(isPromocaoUpdate == 1) {
						pacoteUpdate.setPromocao(true);
					  }else if (isPromocaoUpdate == 2) {
						  pacoteUpdate.setPromocao(false);
						 
					  }else {
						  System.out.println("Selecione 1 ou 2");
					  }
					  scan.nextLine();
					 

					  PacoteDeViagemDAO.update(pacoteUpdate);
					  System.out.println("Atualizado com sucesso!");

					  break;

					  

				  case 4:

					  System.out.println("Delete seu Pacote de Viagem\n");
					  System.out.println("Digite o id para deletar: ");
					  PacoteDeViagemDAO.remove(scan.nextInt());
					  scan.nextLine();
					  System.out.println("\nDeletado com sucesso! ");

					  break;

					  


					  	  

				  case 5:

					  System.out.println("Você saiu do menu!");
					  
					  res = 5;

					  break;
					  
					  

				  default:

					  System.out.println("Digite um número de 1 à 5");

				  }
				}while (res!= 5);
		}
		scan.close();
		
	
		}

		 


				  
		
}
