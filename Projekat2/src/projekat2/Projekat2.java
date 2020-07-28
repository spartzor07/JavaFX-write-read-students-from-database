/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class Projekat2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Button ispis = new Button("Citanje studenata iz baze");
        Button upis = new Button("Upisi poene studenta");
        Button licni = new Button("Upisi licne podatke studenta");
        Button indeks = new Button("Izbrisi studenta");
        ispis.setOnAction(e->{
            Ispis.ispisi();
        });
        upis.setOnAction(e->{
           Upis.upisi();   
           
        });
        indeks.setOnAction(e->{
           
            Izbrisi.izbrisi();
            
        });
        licni.setOnAction(e->{
           
            UpisLicnih.upisi();
            
        });
        VBox vb1 = new VBox(20);
        vb1.getChildren().addAll(ispis,upis,licni,indeks);
        StackPane root = new StackPane();
        root.getChildren().addAll(vb1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Baza Podataka Studenata");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
