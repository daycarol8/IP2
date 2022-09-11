package gui;

import exception.ElementoJaExisteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;
import negocio.ControladorGeral;

import java.time.LocalDate;

public class MainLaunch extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLaunch.class.getResource("insercao-ofertas.fxml"));

        Scene scene = new Scene(fxmlLoader.load() );
        stage.setScene(scene);

        stage.setTitle("Ofertas");
        stage.show();
    }
   static ControladorGeral controladorGeral = new ControladorGeral();

    public ControladorGeral controladorGeral2 = new ControladorGeral();

    public static void main(String[] args) throws ElementoJaExisteException {
        Produto produto1 = new Produto("23109", "telefone", "ELETRONICOS", CategoriaProdutoEnum.ELETRONICOS);
        Produto produto2 = new Produto("23149", "computador", "ELETRONICOS", CategoriaProdutoEnum.ELETRONICOS);

        controladorGeral.inserirProduto(produto1);
        controladorGeral.inserirProduto(produto2);

        Loja loja1 = new Loja("3129", "kabum", "loja.com.br");
        Loja loja2 = new Loja("3129", "fast", "loja.com.br");
        Usuario usuario1 = new Usuario("daskmd@dmaks.com", "Jose", LocalDate.now(), "k3op3p4");
        Usuario usuario2 = new Usuario("asd@dmaks.com", "Fulano", LocalDate.now(), "123190");

        AlertaPreco alerta1 = new AlertaPreco(usuario1, produto1, 15f);
        AlertaPreco alerta2 = new AlertaPreco(usuario2, produto2, 15f);

        controladorGeral.inserirLoja(loja1);
        controladorGeral.inserirLoja(loja2);
        controladorGeral.inserirUsuario(usuario1);
        controladorGeral.inserirUsuario(usuario2);
        controladorGeral.inserirAlertaPreco(alerta1);
        controladorGeral.inserirAlertaPreco(alerta2);

        launch();
    }


}
