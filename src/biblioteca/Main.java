package biblioteca;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.exception.LivroJaCadastradoException;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		
		Livro l = new Livro("O Hobbit", "Tolkien", "999", 1);
		Livro l2 = new Livro("Dom Casmurro", "Machado de Assis", "999", 1);
		Usuario u = new Usuario("Joao Lucas", "teste@gmail.com", 1234);
		BibliotecaService b = new BibliotecaService();
		
		try {
			b.cadastrarLivro(l);
		    System.out.println("Cadastro Realizado com sucesso");
		} catch (LivroJaCadastradoException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}
		
		try {
			b.cadastrarLivro(l2);
		    System.out.println("Cadastro Realizado com sucesso");
		} catch (LivroJaCadastradoException ex) {
		    System.out.println("Erro: " + ex.getMessage());
		}

	}

}
