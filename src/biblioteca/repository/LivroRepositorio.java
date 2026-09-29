package biblioteca.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.model.Livro;

public class LivroRepositorio implements Repositorio<Livro> {

    @Override
    public void salvar(List<Livro> itens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt"))) {
        	for (Livro p : itens) {
        		writer.write(p.getTitulo() + ";" + p.getAutor() + ";" + p.getIsbn() + ";" + p.getCopiasDisponiveis());
        		writer.newLine();
        		
        	}
        } catch (IOException e) {
        	System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @Override
    public List<Livro> carregar() {
        List<Livro> livros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("livros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                String titulo = campos[0];
                String autor = campos[1];
                String isbn = campos[2];
                int copias = Integer.parseInt(campos[3]);
                livros.add(new Livro(titulo, autor, isbn, copias));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

        return livros;
    }

}