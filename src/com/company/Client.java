package com.company;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Client {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NameClient;

    @FXML
    private TextField SurnameClient;

    @FXML
    private Button ButtonClient;

    @FXML
    private Button BackClient;

    @FXML
    void BackPlay1(ActionEvent event) {
        try {
            Stage stage=(Stage) BackClient.getScene().getWindow();
            Parent root1= FXMLLoader.load(getClass().getResource("MusicStore.fxml"));
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void ClientPlay(ActionEvent event) {
try{
    Class.forName("org.postgresql.Driver");
    Connection connection= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MusicalShop", "postgres", "master123!");
    PreparedStatement ps =connection.prepareStatement("INSERT INTO \"Клиенты\"(\"Имя\",\"Фамилия\") VALUES (?,?)");
    ps.setString(1,NameClient.getText());
    ps.setString(2,SurnameClient.getText());
    ps.execute();
}catch (Exception e){
    e.printStackTrace();
}
    }

    @FXML
    void initialize() {
        assert NameClient != null : "fx:id=\"NameClient\" was not injected: check your FXML file 'Client.fxml'.";
        assert SurnameClient != null : "fx:id=\"SurnameClient\" was not injected: check your FXML file 'Client.fxml'.";
        assert ButtonClient != null : "fx:id=\"ButtonClient\" was not injected: check your FXML file 'Client.fxml'.";
        assert BackClient != null : "fx:id=\"BackClient\" was not injected: check your FXML file 'Client.fxml'.";

    }
}


