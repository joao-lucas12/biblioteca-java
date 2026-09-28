package biblioteca;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;
import biblioteca.exception.EmprestimoNaoEncontradoException;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.model.Emprestimo;

public class Main {

	public static void main(String[] args) {
		
		Livro l = new Livro("O Hobbit", "Tolkien", "999", 1);
		Livro l2 = new Livro("Dom Casmurro", "Machado de Assis", "111", 1);
		Usuario u = new Usuario("Joao Lucas", "teste@gmail.com", 1234);
		BibliotecaService b = new BibliotecaService();
		b.cadastrarLivro(l);
		b.cadastrarLivro(l2);
		b.cadastrarUsuario(u);
		
		System.out.println(b.listarLivros());
		System.out.println(b.listarUsuarios());
		
		try {
		    b.emprestar("999", 1234);
		    System.out.println("Empréstimo Realizado com sucesso");
		} catch (LivroIndisponivelException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}

		
		System.out.println(b.listarEmprestimosAtivos());
		
		try {
		    b.devolver("999", 1234);
		    System.out.println("Devolução Realizada com sucesso");
		} catch (EmprestimoNaoEncontradoException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}

		
		System.out.println(b.listarEmprestimosAtivos());
		
		System.out.println(b.buscarLivro("hobbit"));
		System.out.println(b.buscarLivro("Machado"));
		System.out.println(b.buscarLivro("xyz"));
		
		
		
		
		
		

	}

}
