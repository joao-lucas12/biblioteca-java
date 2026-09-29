package biblioteca.repository;

import java.util.List;

public interface Repositorio<T> {

    void salvar(List<T> itens);

    List<T> carregar();

}