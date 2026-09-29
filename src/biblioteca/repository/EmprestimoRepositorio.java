package biblioteca.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;



public class EmprestimoRepositorio  {

    public void salvar(List<Emprestimo> itens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emprestimos.txt"))) {
        	for (Emprestimo p : itens) {
        		writer.write(p.getLivro().getIsbn() + ";" + p.getUsuario().getId() + ";" + p.getDataEmprestimo() + ";" + p.isDevolvido());
        		writer.newLine();
        		
        	}
        } catch (IOException e) {
        	System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    public List<Emprestimo> carregar(List<Livro> livros, List<Usuario> usuarios) {
    	List<Emprestimo> emprestimos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("emprestimos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                String isbn = campos[0];
                int id = Integer.parseInt(campos[1]);
                LocalDate dataEmprestimo = LocalDate.parse(campos[2]);
                Boolean devolvido = Boolean.parseBoolean(campos[3]);
                
                Livro livroEncontrado = null;
                for (Livro l : livros) {
                    if (l.getIsbn().equals(isbn)) {
                        livroEncontrado = l;
                    }
                }
                Usuario usuarioEncontrado = null;
                for (Usuario u : usuarios) {
                    if (u.getId() == id) {
                        usuarioEncontrado = u;
                    }
                }
                
                
                Emprestimo e = new Emprestimo(livroEncontrado, usuarioEncontrado, dataEmprestimo, devolvido);
                emprestimos.add(e);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

        return emprestimos;
    }
    
}
