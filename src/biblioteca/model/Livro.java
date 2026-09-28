package biblioteca.model;

import java.util.Objects;

public class Livro {
	private String titulo;
    private String autor;
    private String isbn;
    private int copiasDisponiveis;
    
    public Livro(String titulo, String autor, String isbn, int copiasDisponiveis) {
    	this.titulo = titulo;
    	this.autor = autor;
    	this.isbn = isbn;
    	this.copiasDisponiveis = copiasDisponiveis;
    	
    }
    
    public String getTitulo() {
    	return titulo;
    }
    
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }
    
    public String getAutor() {
    	return autor;
    }
    
    public void setAutor(String autor) {
    	this.autor = autor;
    }
    
    public String getIsbn() {
    	return isbn;
    }
    
    public void setIsbn(String isbn) {
    	this.isbn = isbn;
    }
    
    public int getCopiasDisponiveis() {
    	return copiasDisponiveis;
    }
    
    public boolean reservarCopia() {
    	if (copiasDisponiveis > 0 ) {
    		copiasDisponiveis -= 1;
    		return true;
    	} else {
    		return false;
    	}
		
    }
    
    public boolean liberarCopia() {
    	copiasDisponiveis += 1;
    	return true;
    }
    
    @Override
    
    public String toString() {
    	 return "Livro{" +
    	            "titulo='" + titulo + '\'' +
    	            ", autor='" + autor + '\'' +
    	            ", isbn='" + isbn + '\''+
    	            ", copiasDisponiveis=" + copiasDisponiveis + 
    	            '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }


}
