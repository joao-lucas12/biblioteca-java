package biblioteca;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		
		Livro l = new Livro("O Hobbit", "Tolkien", "999", 1);
		Livro l2 = new Livro("Dom Casmurro", "Machado de Assis", "111", 1);
		Usuario u = new Usuario("Joao Lucas", "teste@gmail.com", 1234);
		BibliotecaService b = new BibliotecaService();
		b.cadastrarLivro(l);
		b.cadastrarLivro(l2);
		b.cadastrarUsuario(u);
		
		try {
		    b.emprestar("000", 1234);
		    System.out.println("Empréstimo Realizado com sucesso");
		} catch (LivroIndisponivelException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		} catch (LivroNaoEncontradoException ex) {
		    System.out.println("Erro: " + ex.getMessage()); 
		} catch (UsuarioNaoEncontradoException ex) {
		    System.out.println("Erro: " + ex.getMessage()); 
		}

		
		try {
		    b.emprestar("999", 5555);
		    System.out.println("Empréstimo Realizado com sucesso");
		} catch (LivroIndisponivelException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		} catch (LivroNaoEncontradoException ex) {
		    System.out.println("Erro: " + ex.getMessage()); 
		} catch (UsuarioNaoEncontradoException ex) {
		    System.out.println("Erro: " + ex.getMessage()); 
		}
		

	}

}
