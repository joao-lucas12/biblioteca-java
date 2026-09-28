package biblioteca.model;

import java.util.Objects;

public class Usuario {
	
	private String nome;
    private String email;
    private int id;
    
    public Usuario(String nome, String email, int id) {
    	this.nome = nome;
    	this.email = email;
    	this.id = id;
    	
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
@Override
    
    public String toString() {
    	 return "Usuario{" +
    	            "nome='" + nome + '\'' +
    	            ", email='" + email + '\'' +
    	            ", id=" + id + 
    	            '}';
    }

@Override
    public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Usuario usuario = (Usuario) o;
         return id == usuario.id;
}

@Override
    public int hashCode() {
         return Objects.hash(id);
}

  

}
