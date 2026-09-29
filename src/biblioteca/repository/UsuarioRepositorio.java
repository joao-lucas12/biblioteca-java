package biblioteca.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.model.Usuario;

public class UsuarioRepositorio implements Repositorio<Usuario> {

    @Override
    public void salvar(List<Usuario> itens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt"))) {
        	for (Usuario p : itens) {
        		writer.write(p.getNome() + ";" + p.getEmail() + ";" + p.getId());
        		writer.newLine();
        		
        	}
        } catch (IOException e) {
        	System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> carregar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                String nome = campos[0];
                String email = campos[1];
                int id = Integer.parseInt(campos[2]);
                usuarios.add(new Usuario(nome, email, id));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

        return usuarios;
    }

}