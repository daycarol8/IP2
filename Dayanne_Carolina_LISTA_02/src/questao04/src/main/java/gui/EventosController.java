package gui;

import exception.ElementoJaExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Loja;
import models.OfertaProduto;
import models.Produto;
import negocio.ControladorGeral;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EventosController implements Initializable {

    ControladorGeral controladorGeral = MainLaunch.controladorGeral;

    @FXML
    DatePicker dataInput;

    @FXML
    ChoiceBox<Loja> lojaBox;

    @FXML
    ChoiceBox<Produto> produtoBox;

    @FXML
    TextField precoInput;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void btnPressed(){
        LocalDate date = this.dataInput.getValue();
        Float preco = Float.parseFloat( this.precoInput.getText());
        Loja loja = lojaBox.getValue();
        Produto produto = produtoBox.getValue();
        OfertaProduto ofertaProduto = new OfertaProduto(produto,preco,loja,date);

        try {
            controladorGeral.inserirOfertaProduto(ofertaProduto);
        } catch (ElementoJaExisteException e) {
            throw new RuntimeException(e);
        }

        System.out.println(controladorGeral.listarOfertaProduto());

    }
    @FXML
    public void irTelaOfertas(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("listagem-ofertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Loja> lojasLista = FXCollections.observableArrayList();
        lojaBox.setItems(lojasLista);
        lojasLista.addAll(controladorGeral.listarLoja());
        lojaBox.setValue(lojasLista.get(0));

        ObservableList<Produto> produtosLista = FXCollections.observableArrayList();
        produtoBox.setItems(produtosLista);
        produtosLista.addAll(controladorGeral.listarProduto());
        produtoBox.setValue(produtosLista.get(0));

        dataInput.setValue(LocalDate.now());

    }
}
