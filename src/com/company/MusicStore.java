package com.company;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MusicStore {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShopButton;

    @FXML
    private Button ProductButton;

    @FXML
    private Button ClientButton;

    @FXML
    void Play1(ActionEvent event)  {
        try {
            Stage stage=(Stage) ShopButton.getScene().getWindow();
            Parent root1=FXMLLoader.load(getClass().getResource("Purchase.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Play2(ActionEvent event) {
        try {
            Stage stage=(Stage) ProductButton.getScene().getWindow();
            Parent root1=FXMLLoader.load(getClass().getResource("Product.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void Play3(ActionEvent event) throws Exception {
        try {
            Stage stage=(Stage) ClientButton.getScene().getWindow();
            Parent root1=FXMLLoader.load(getClass().getResource("Client.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert ShopButton != null : "fx:id=\"ShopButton\" was not injected: check your FXML file 'MusicStore.fxml'.";
        assert ProductButton != null : "fx:id=\"ProductButton\" was not injected: check your FXML file 'MusicStore.fxml'.";
        assert ClientButton != null : "fx:id=\"ClientButton\" was not injected: check your FXML file 'MusicStore.fxml'.";

    }
}
