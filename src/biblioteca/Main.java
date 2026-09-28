package biblioteca;

import java.util.Scanner;

import biblioteca.exception.EmprestimoNaoEncontradoException;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.exception.LivroJaCadastradoException;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean continuar = true;
		
		BibliotecaService service = new BibliotecaService();
		
		while (continuar) {

			System.out.println("1- Cadastrar livro");
			System.out.println("2- Cadastrar usuário");
			System.out.println("3- Emprestar livro");
			System.out.println("4- Devolver livro");
			System.out.println("5- Listar livros, usuários e empréstimos ativos");
			System.out.println("6- Buscar livro");
			System.out.println("7- Sair");
			int decisao = scanner.nextInt();
			scanner.nextLine();
			
			switch (decisao) {
			   case 1: 
				   System.out.println("Insira o título do livro: ");
				   String titulo = scanner.nextLine();
				   System.out.println("Insira o autor do livro: ");
				   String autor = scanner.nextLine();
				   System.out.println("Insira o ISBN do livro: ");
				   String isbn = scanner.nextLine();
				   System.out.println("Insira a quantidade de copias do livro: ");
				   int copias = scanner.nextInt();
				   scanner.nextLine();
				   
				   try {
					   Livro livro = new Livro(titulo, autor, isbn, copias);
					   service.cadastrarLivro(livro);
					   System.out.println("Livro Cadastrado com sucesso!");
					   
				   } catch (LivroJaCadastradoException ex){
					   System.out.println("Erro: " + ex.getMessage());
				   }
				 
				   break;
				   
			   case 2: 
				   System.out.println("Insira o nome do usuário: ");
				   String nome = scanner.nextLine();
				   System.out.println("Insira o email do usuário: ");
				   String email = scanner.nextLine();
				   System.out.println("Insira o Id do usuário: ");
				   int id = scanner.nextInt();
				   scanner.nextLine();
				 
				   Usuario usuario = new Usuario(nome, email, id);
				   service.cadastrarUsuario(usuario);
				   System.out.println("Usuário Cadastrado com sucesso!");
					   
				   break;
				   
			   case 3: 
				   System.out.println("Insira o ISBN do livro a ser emprestado: ");
				   String isbnE = scanner.nextLine();
				   System.out.println("Insira o Id do usuário: ");
				   int idE = scanner.nextInt();
				   scanner.nextLine();
				   
				   try {
					   service.emprestar(isbnE, idE);
					   System.out.println("Empréstimo realizado com Sucesso!");
				   } catch (LivroNaoEncontradoException ex) {
					   System.out.println("Erro: " + ex.getMessage());
				   } catch (UsuarioNaoEncontradoException ex) {
					   System.out.println("Erro: " + ex.getMessage());
				   } catch (LivroIndisponivelException ex) {
					   System.out.println("Erro: " + ex.getMessage());
				   }
				   
				   
				   break;
				   
			   case 4: 
				   System.out.println("Insira o ISBN do livro a ser devolvido: ");
				   String isbnD = scanner.nextLine();
				   System.out.println("Insira o Id do usuário que está devolvendo: ");
				   int idD = scanner.nextInt();
				   scanner.nextLine();
				   
				   try {
					   service.devolver(isbnD, idD);
					   System.out.println("Devolução realizada com Sucesso!");
				   } catch (EmprestimoNaoEncontradoException ex) {
					   System.out.println("Erro: " + ex.getMessage());
				   }
				   
				   break;
				   
			   case 5: 
				   System.out.println("Livros cadastrados: ");
				   System.out.println(service.listarLivros());
				   
				   System.out.println("Usuários cadastrados: ");
				   System.out.println(service.listarUsuarios());
				   
				   System.out.println("Empréstimos ativos: ");
				   System.out.println(service.listarEmprestimosAtivos());
				   
				   break;
				   
			   case 6: 
				   System.out.println("Insira o título ou autor do livro que deseja: ");
				   String busca = scanner.nextLine();

				   
				   System.out.println("Livro Encontrado: " + service.buscarLivro(busca));
				   
				   break;
				   
			   case 7: 
				   continuar = false;
				   break;
			
			}
			
		}
		
scanner.close();
		
		
	}
}
