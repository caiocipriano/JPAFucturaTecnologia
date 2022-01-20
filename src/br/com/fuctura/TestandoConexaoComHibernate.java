package br.com.fuctura;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.models.Conta;
import br.com.fuctura.models.Usuario;
import br.com.fuctura.repository.ContaRepository;
import br.com.fuctura.repository.UsuarioRepository;

public class TestandoConexaoComHibernate {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		EntityManager em = fabrica.createEntityManager();
		
		UsuarioRepository usuRepo = new UsuarioRepository();
		Usuario novoUsuario = new Usuario();
		
		System.out.println("Oque você deseja?");
		System.out.println("1-Gerenciar Usuário");
		System.out.println("2-Gerenciar Conta");
		System.out.println("3-Gereniar Banco");
		System.out.print("Digite:");
		Scanner scanner = new Scanner(System.in);
		int escolha = scanner.nextInt();
		
		if(escolha == 1) {
			System.out.println("Oque deseja fazer com ele?");
			System.out.println("1-Cadastrar");
			System.out.println("2-Excluir");
			System.out.println("3-Pesquisar por Email");
			System.out.println("4-Pesquisar por Idade");
			System.out.println("5-Pesquisar por Nome");
			System.out.println("6-Listar Todos");
			
			Scanner scannerM = new Scanner(System.in);
			int escolhaCad = scanner.nextInt();
			
			switch(escolhaCad) {
				case 1:
					Scanner scannerCadastro = new Scanner(System.in);
		
					System.out.println("Nome:");
					String nome = scannerCadastro.nextLine();
					
					System.out.println("Email:");
					String email = scannerCadastro.nextLine();
					
					System.out.println("CPF:");
					String cpf = scannerCadastro.nextLine();
		
					System.out.println("Idade:");
					int idade = scannerCadastro.nextInt();
					
					novoUsuario.setNome(nome);
					novoUsuario.setEmail(email);
					novoUsuario.setCpf(cpf);
					novoUsuario.setIdade(idade);
					
					usuRepo.incluir(novoUsuario, em);
				break;
				//Excluir
				case 2:
					break;
					
				case 3:
					Scanner scannerEmail = new Scanner(System.in);

					System.out.println("Email:");
					String emailF = scannerEmail.nextLine();
					
					Usuario resultadoEmail = usuRepo.pesquisarPorEmail(emailF, em);
					System.out.println(resultadoEmail);
				break;
				
				case 4 :
					Scanner scannerIdade = new Scanner(System.in);

					System.out.println("Idade");
					int idadeUser = Integer.valueOf(scannerIdade.nextLine());

					List<Usuario> resultadoIdade = usuRepo.pesquisarPorIdade(idadeUser, em);
					for(Usuario u : resultadoIdade) {
						System.out.println("Nome:" + u.getNome());
						System.out.println("Email:" + u.getEmail());
						System.out.println("CPF:"+ u.getCpf());
						System.out.println("Idade:" + u.getIdade());
					}
				break;
				
				case 5:
					Scanner scannerNome = new Scanner(System.in);

					System.out.println("Nomes:");
					String nomeUser = scannerNome.nextLine();

					List<Usuario> resultadoNome = usuRepo.pesquisarPorNome(nomeUser, em);
						for(Usuario u : resultadoNome) {
							System.out.println("Nome:" + u.getNome());
							System.out.println("Email:" + u.getEmail());
							System.out.println("CPF:"+ u.getCpf());
							System.out.println("Idade:" + u.getIdade());
						}
				break;
				
				case 6:
					System.out.println("Usuários:");
					List<Usuario> resultadoTodos= usuRepo.pesquisarPorTodos(em);
						for(Usuario u : resultadoTodos) {
							System.out.println("Nome:" + u.getNome());
							System.out.println("Email:" + u.getEmail());
							System.out.println("CPF:"+ u.getCpf());
							System.out.println("Idade:" + u.getIdade());
						}
				break;
				
			}

		
		
		}else if(escolha == 2) {
			
			
			
			
		}
				

		
		

		
	
		

		//Cadastrar conta
		/*ContaRepository contaRepo = new ContaRepository();
		System.out.println("Saldo:");
		double saldo = entrada.nextDouble();
		
		System.out.println("Numero:");
		long numero = entrada.nextLong();
		
		System.out.println("Tipo:");
		String tipo = entrada.nextLine();
		
		Conta novaConta = new Conta();
		novaConta.setSaldo(saldo);
		novaConta.setNumero(numero);
		novaConta.setTipo(tipo);
		
		contaRepo.incluir(novaConta, em);*/
		
		em.close();
		fabrica.close();
		
	}
	
	/*if(usuarioDaBase != null) {
	System.out.println("Nome:" + usuarioDaBase.getNome());
	
}*/

//List<Usuario> resultado = consultar(em);

}
