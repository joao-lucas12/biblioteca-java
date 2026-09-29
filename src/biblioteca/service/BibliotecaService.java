package biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import biblioteca.exception.EmprestimoNaoEncontradoException;
import biblioteca.exception.LivroIndisponivelException;
import biblioteca.exception.LivroJaCadastradoException;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioJaCadastradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

public class BibliotecaService {
	
	private Map<String, Livro> livros = new HashMap<>();
	private Map<Integer, Usuario> usuarios = new HashMap<>();
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	public void cadastrarLivro(Livro livro) throws LivroJaCadastradoException{
		if(livros.containsKey(livro.getIsbn())) {
			throw new LivroJaCadastradoException ("Este livro já foi cadastrado");
		}
		livros.put(livro.getIsbn(), livro);
	}
	
	public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastradoException {
		if(usuarios.containsKey(usuario.getId())) {
			throw new UsuarioJaCadastradoException("Este usuário já foi cadastrado");
		}
		usuarios.put(usuario.getId(), usuario);
	}
	
	public void emprestar(String isbn, int idUsuario) throws LivroIndisponivelException, UsuarioNaoEncontradoException, LivroNaoEncontradoException {
		Livro livro = livros.get(isbn);
		if (livro == null) {
			throw new LivroNaoEncontradoException ("Este livro não consta no sistema");
		}
		Usuario usuario = usuarios.get(idUsuario);
		
		if (usuario == null) {
			throw new UsuarioNaoEncontradoException ("Este usuário não consta no sistema");
		}
		
		if(!livro.reservarCopia()) {
			throw new LivroIndisponivelException("Sem Cópias dísponiveis deste livro");
		} else {
			Emprestimo e = new Emprestimo(livro, usuario);
			emprestimos.add(e);
		}
		
	}
	
	
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
	
	public List<Emprestimo> listarTodosEmprestimos() {
	    return new ArrayList<>(emprestimos);
	}
	
	public void carregarDados(List<Livro> livros, List<Usuario> usuarios, List<Emprestimo> emprestimos) {
	    for (Livro l : livros) {
	        this.livros.put(l.getIsbn(), l);
	    }
	    for (Usuario u : usuarios) {
	        this.usuarios.put(u.getId(), u);
	    }
	    this.emprestimos.addAll(emprestimos);
	}
	
	
		
}


