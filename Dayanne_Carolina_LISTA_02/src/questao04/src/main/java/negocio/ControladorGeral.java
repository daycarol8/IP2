package negocio;

import exception.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import exception.ElementoJaExisteException;
import models.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ControladorGeral {

    private IRepositorioGenerico<AlertaPreco> repositorioAlertaPreco = new RepositorioGenerico();
    private IRepositorioGenerico<Produto> repositorioProduto = new RepositorioGenerico();
    private IRepositorioGenerico<Loja> repositorioLoja = new RepositorioGenerico();
    private IRepositorioGenerico<Usuario> repositorioUsuario = new RepositorioGenerico();

    private IRepositorioGenerico<OfertaProduto> repositorioOfertaProduto = new RepositorioGenerico();

    private Usuario usuarioLogado;

    public void Login(Usuario usuario){
        for (Usuario temp: repositorioUsuario.listar()){
            if(temp.getEmail().equals(usuario.getEmail()) && temp.getSenha().equals(usuario.getSenha())){
                usuarioLogado = usuario;
            } else{
                System.out.println("Usuario não existe");
            }
        }
    }

    public List<OfertaProduto> listarOfertasOrdenadasPorPrecoNaData(Produto param, LocalDate dataAtual){
        List<OfertaProduto> lista = new ArrayList<>();
        for(OfertaProduto temp: repositorioOfertaProduto.listar()){
            if(temp.getProduto().equals(param) && temp.getData().equals(dataAtual)){
                lista.add(temp);
            }
        }
        Collections.sort(lista);
        return lista;
    }

    public Map<LocalDate, List<OfertaProduto>> montarHistoricoDeOfertasDoProdutoNoPeriodo(Produto param, LocalDate dataInicial, LocalDate dataFinal){
        List<OfertaProduto> ofertas = new ArrayList<>();

        for(OfertaProduto temp: repositorioOfertaProduto.listar()){
            if(temp.getProduto().equals(param)){
                ofertas.add(temp);
            }
        }
        Map<LocalDate, List<OfertaProduto>> historico= ofertas.stream().collect(
                Collectors.groupingBy(
                        ofertaProduto -> ofertaProduto.getData(),
                        TreeMap::new,
                        Collectors.mapping(ofertaProduto -> ofertaProduto, Collectors.toCollection(ArrayList::new))
                )
        );
        List<LocalDate> remove = new ArrayList<>();
        for (Map.Entry<LocalDate, List<OfertaProduto>> be : historico.entrySet()) {
            if(!estaNoPeriodo(dataInicial,dataFinal,be.getKey())){
                remove.add(be.getKey());
            }
        }
        for(LocalDate date: remove){
            historico.remove(date);
        }

        return historico;
    }

    public boolean estaNoPeriodo(LocalDate inicio, LocalDate fim, LocalDate data) {
        return data.isAfter(inicio) && data.isBefore(fim) || data.equals(fim) || data.equals(inicio);
    }

    public List<AlertaPreco> verificarAlertasDePrecoAtingido(Usuario u){
        List<AlertaPreco> listaDeAlertas = new ArrayList<>();

        for(AlertaPreco temp: repositorioAlertaPreco.listar()){
            if(temp.getUsuario().equals(u)){
                for(OfertaProduto oferta: repositorioOfertaProduto.listar()){
                    if(temp.getProduto().equals(oferta.getProduto()) && oferta.getData().equals(LocalDate.now())    &&temp.getPrecoAlvo() <= oferta.getPreco()){
                        listaDeAlertas.add(temp);
                    }
                }
            }
        }

        return listaDeAlertas;
    }

    public void inserirAlertaPreco(AlertaPreco obj) throws ElementoJaExisteException {
        repositorioAlertaPreco.inserir(obj);
    }

    public List<AlertaPreco> listarAlertaPreco() {
        return repositorioAlertaPreco.listar();
    }

    public void removerAlertaPreco(AlertaPreco obj) throws ElementoNaoExisteException {
        repositorioAlertaPreco.remover(obj);
    }

    public void atualizarAlertaPreco(AlertaPreco newObj) throws ElementoNaoExisteException {
        repositorioAlertaPreco.atualizar(newObj);
    }

    public void inserirProduto(Produto obj) throws ElementoJaExisteException {
        repositorioProduto.inserir(obj);
    }

    public List<Produto> listarProduto() {
        return repositorioProduto.listar();
    }

    public void removerProduto(Produto obj) throws ElementoNaoExisteException {
        repositorioProduto.remover(obj);
    }

    public void atualizarProduto(Produto newObj) throws ElementoNaoExisteException {
        repositorioProduto.atualizar(newObj);
    }

    public void inserirLoja(Loja obj) throws ElementoJaExisteException {
        repositorioLoja.inserir(obj);
    }

    public List<Loja> listarLoja() {
        return repositorioLoja.listar();
    }

    public void removerLoja(Loja obj) throws ElementoNaoExisteException {
        repositorioLoja.remover(obj);
    }

    public void atualizarLoja(Loja newObj) throws ElementoNaoExisteException {
        repositorioLoja.atualizar(newObj);
    }


    public void inserirUsuario(Usuario obj) throws ElementoJaExisteException {
        repositorioUsuario.inserir(obj);
    }

    public List<Usuario> listarUsuario() {
        return repositorioUsuario.listar();
    }

    public void removerUsuario(Usuario obj) throws ElementoNaoExisteException {
        repositorioUsuario.remover(obj);
    }

    public void atualizarUsuario(Usuario newObj) throws ElementoNaoExisteException {
        repositorioUsuario.atualizar(newObj);
    }


    public void inserirOfertaProduto(OfertaProduto obj) throws ElementoJaExisteException {
        repositorioOfertaProduto.inserir(obj);
    }

    public List<OfertaProduto> listarOfertaProduto() {
        return repositorioOfertaProduto.listar();
    }

    public void removerOfertaProduto(OfertaProduto obj) throws ElementoNaoExisteException {
        repositorioOfertaProduto.remover(obj);
    }

    public void atualizarOfertaProduto(OfertaProduto newObj) throws ElementoNaoExisteException {
        repositorioOfertaProduto.atualizar(newObj);
    }
}
