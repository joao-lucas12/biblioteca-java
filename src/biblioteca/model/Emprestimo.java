package biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
	private Livro livro;
	private Usuario usuario;
	private LocalDate dataEmprestimo = LocalDate.now();
	private boolean devolvido = false;

	
	public Emprestimo(Livro livro, Usuario usuario) {
    	this.livro = livro;
    	this.usuario = usuario;
    	
    }
	
	public Livro getLivro() {
    	return livro;
    }

    
    public Usuario getUsuario() {
    	return usuario;
    }
    
    public LocalDate getDataEmprestimo() {
    	return dataEmprestimo;
    }
    
    public boolean isDevolvido() {
    	return devolvido;
    }
    
    public boolean marcarComoDevolvido() {
    	if (!devolvido) {
    		devolvido = true;
    		return true;
    	} else {
    		return false;
    	}
    }
    
@Override
    
    public String toString() {
    	 return "Emprestimo{" +
    	            "livro=" + livro  +
    	            ", usuario=" + usuario  +
    	            ", dataEmprestimo=" + dataEmprestimo  +
    	            ", devolvido=" + devolvido  +
    	            '}';
    }
	
	

}
