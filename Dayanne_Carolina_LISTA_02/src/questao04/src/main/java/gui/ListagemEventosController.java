package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Loja;
import models.OfertaProduto;
import models.Produto;
import negocio.ControladorGeral;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ListagemEventosController implements Initializable {

    ControladorGeral controladorGeral = MainLaunch.controladorGeral;

    @FXML
    DatePicker dataInputListagem;

    @FXML
    TableView<OfertaProduto> tableOfertas;
    @FXML
    TableColumn<OfertaProduto, Produto> produtoColumn;
    @FXML
    TableColumn<OfertaProduto, Float> precoColumn;
    @FXML
    TableColumn<OfertaProduto, Loja> lojaColumn;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void pesquisarOfertas(){

    }

    @FXML
    public void irTelaInsercao(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("insercao-ofertas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dataInputListagem.setValue(LocalDate.now());
        produtoColumn.setCellValueFactory(new PropertyValueFactory<OfertaProduto,Produto>("Produto"));
        lojaColumn.setCellValueFactory(new PropertyValueFactory<OfertaProduto,Loja>("Loja"));
        precoColumn.setCellValueFactory(new PropertyValueFactory<OfertaProduto,Float>("Float"));

        ObservableList<OfertaProduto> ofertasLista = FXCollections.observableArrayList();
        ofertasLista.addAll(controladorGeral.listarOfertaProduto());
        System.out.println(ofertasLista);
        tableOfertas.setItems(ofertasLista);

    }
}
