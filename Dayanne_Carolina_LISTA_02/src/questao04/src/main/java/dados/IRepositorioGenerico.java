package dados;

import java.util.List;

import exception.ElementoNaoExisteException;
import exception.ElementoJaExisteException;

public interface IRepositorioGenerico<T> {

    void inserir(T obj) throws ElementoJaExisteException;

    List<T> listar();

    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;

}