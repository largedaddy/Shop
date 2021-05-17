package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

    public static void main(String[] args){launch();}
        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl=getClass().getResource("MusicStore.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

