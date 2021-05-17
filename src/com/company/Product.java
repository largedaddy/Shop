package com.company;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Product {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> TypeProduct;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField CompanyProduct;

    @FXML
    private TextField ModelProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField QuantityProduct;

    @FXML
    private Button ButtonProduct;

    @FXML
    private Button BackProduct;

    @FXML
    void BackPlay2(ActionEvent event) {
        try {
            Stage stage=(Stage) BackProduct.getScene().getWindow();
            Parent root1= FXMLLoader.load(getClass().getResource("MusicStore.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void ProductPlay(ActionEvent event) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
            PreparedStatement ps =connection.prepareStatement("INSERT INTO \"Инструменты\"(\"Наименование\",\"Фирма\",\"Модель\",\"Цена\",\"Количество\",\"Тип\") VALUES (?,?,?,?,?,?)");
            ps.setString(1,NameProduct.getText());
            ps.setString(2,CompanyProduct.getText());
            ps.setString(3,ModelProduct.getText());
            ps.setDouble(4,Double.parseDouble(PriceProduct.getText()));
            ps.setDouble(5,Double.parseDouble(QuantityProduct.getText()));
            ps.setString(6,TypeProduct.getSelectionModel().getSelectedItem());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void TypePlay(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert TypeProduct != null : "fx:id=\"TypeProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert NameProduct != null : "fx:id=\"NameProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert CompanyProduct != null : "fx:id=\"CompanyProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert ModelProduct != null : "fx:id=\"ModelProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert PriceProduct != null : "fx:id=\"PriceProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert QuantityProduct != null : "fx:id=\"QuantityProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert ButtonProduct != null : "fx:id=\"ButtonProduct\" was not injected: check your FXML file 'Product.fxml'.";
        assert BackProduct != null : "fx:id=\"BackProduct\" was not injected: check your FXML file 'Product.fxml'.";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
            PreparedStatement ps = connection.prepareStatement("SELECT \"Тип\" FROM \"ТипыИнструментов\" ");
            List<String> list=new ArrayList();
            ResultSet res =ps.executeQuery();
            while (res.next()){

                list.add(res.getString(1));
            }
            TypeProduct.setItems(FXCollections.observableList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


