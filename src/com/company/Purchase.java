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

class ProductStruct{
    public int ID;
    public String Наименование;
    @Override
    public String toString(){return Наименование;}
}

class ClientStruct{
public int ID;
public String Фамилия;
@Override
    public String toString(){return Фамилия;}
}
public class Purchase {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<ProductStruct> ProductPurchase;

    @FXML
    private ComboBox<ClientStruct> ClientPurchase;

    @FXML
    private TextField PricePurchase;

    @FXML
    private Button ButtonPurchase;

    @FXML
    private Button BackPurchase;

    @FXML
    void BackPlay3(ActionEvent event) {
        try {
            Stage stage=(Stage) BackPurchase.getScene().getWindow();
            Parent root1= FXMLLoader.load(getClass().getResource("MusicStore.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void ClientPlay(ActionEvent event) {
        ClientStruct selectedItem = ClientPurchase.getValue();
        System.out.println(selectedItem.ID);
    }

    @FXML
    void ProductPlay(ActionEvent event) {
        ProductStruct selectedItem = ProductPurchase.getValue();
        System.out.println(selectedItem.ID);
    }

    @FXML
    void PurchasePlay(ActionEvent event) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Продажи\"(\"Цена\",\"IDКлиента\",\"IDИнструмента\") VALUES (?,?,?)");
            ps.setDouble(1,Double.parseDouble(PricePurchase.getText()));
            ps.setInt(2,ClientPurchase.getSelectionModel().getSelectedItem().ID);
            ps.setInt(3,ProductPurchase.getSelectionModel().getSelectedItem().ID);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void initialize() {
        assert ProductPurchase != null : "fx:id=\"ProductPurchase\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert ClientPurchase != null : "fx:id=\"ClientPurchase\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert PricePurchase != null : "fx:id=\"PricePurchase\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert ButtonPurchase != null : "fx:id=\"ButtonPurchase\" was not injected: check your FXML file 'Purchase.fxml'.";
        assert BackPurchase != null : "fx:id=\"BackPurchase\" was not injected: check your FXML file 'Purchase.fxml'.";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
                        PreparedStatement ps = connection.prepareStatement("SELECT \"ID\",\"Фамилия\" FROM \"Клиенты\" ");
                        List<ClientStruct> list = new ArrayList();
                        ResultSet res = ps.executeQuery();
                        while (res.next()) {
                            ClientStruct cs = new ClientStruct();
                            cs.ID = res.getInt(1);
                            cs.Фамилия = res.getString(2);
                            list.add(cs);
                        }
                        ClientPurchase.setItems(FXCollections.observableList(list));

                    }catch (Exception e) {
            e.printStackTrace();
        }

                   try {
                        Class.forName("org.postgresql.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
                            PreparedStatement ps = connection.prepareStatement("SELECT \"ID\",\"Наименование\" FROM \"Инструменты\" ");
                            List<ProductStruct> list = new ArrayList();
                            ResultSet res = ps.executeQuery();
                            while (res.next()) {
                                ProductStruct Ps = new ProductStruct();
                                Ps.ID = res.getInt(1);
                                Ps.Наименование = res.getString(2);
                                list.add(Ps);
                            }
                            ProductPurchase.setItems(FXCollections.observableList(list));
                        }catch (Exception e){
                       e.printStackTrace();

                }



    }
}







