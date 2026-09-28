package biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import biblioteca.exception.EmprestimoNaoEncontradoException;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

public class BibliotecaService {
	
	private Map<String, Livro> livros = new HashMap<>();
	private Map<Integer, Usuario> usuarios = new HashMap<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	public void cadastrarLivro(Livro livro) {
		livros.put(livro.getIsbn(), livro);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}
	
	public void emprestar(String isbn, int idUsuario) throws LivroIndisponivelException {
		Livro livro = livros.get(isbn);
		Usuario usuario = usuarios.get(idUsuario);
		
		if(!livro.reservarCopia()) {
			throw new LivroIndisponivelException("Sem Cópias dísponiveis deste livro");
		} else {
			Emprestimo e = new Emprestimo(livro, usuario);
			emprestimos.add(e);
		}
		
	}
	//git teste
	
	
	public void devolver(String isbn, int idUsuario) throws EmprestimoNaoEncontradoException {
	    for (Emprestimo e : emprestimos) {
	        if (e.getLivro().getIsbn().equals(isbn) && e.getUsuario().getId() ==idUsuario && !e.isDevolvido()) {
	            e.marcarComoDevolvido();
	            e.getLivro().liberarCopia();
	            return;
	        }
	        	
	      }
	    throw new EmprestimoNaoEncontradoException("Nenhum emprestimo cadastrado nesse id");
	}
	
	public List<Livro> listarLivros() {
	    return new ArrayList<>(livros.values());
	}
	
	public List<Emprestimo> listarEmprestimosAtivos() {
	    return emprestimos.stream()
	        .filter(e -> !e.isDevolvido())
	        .collect(Collectors.toList());
	}
	
	public List<Livro> buscarLivro(String texto) {
	    List<Livro> encontrados = new ArrayList<>();

	    for (Livro livro : livros.values()) {
	    	if (livro.getTitulo().toLowerCase().contains(texto.toLowerCase())
	    	        || livro.getAutor().toLowerCase().contains(texto.toLowerCase())) {
	    	    encontrados.add(livro);
	    	}
	    }

	    return encontrados;
	}
	
	public List<Usuario> listarUsuarios() {
	    return new ArrayList<>(usuarios.values());
	}
	
	
		
}


