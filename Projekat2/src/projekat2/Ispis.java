/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class Ispis {

    public static void ispisi() {
        Stage stage = new Stage();

        Button svi = new Button("Iscitaj sve studente");
        Button licni = new Button("Iscitaj licne podatke o studentima");
        Button poeni = new Button("Iscitaj poene predmeta o studentima");

        VBox vb1 = new VBox(20);
        vb1.getChildren().addAll(poeni, licni, svi);

        svi.setOnAction(e -> {
           SviJoin.svi();
           
        });
        licni.setOnAction(e -> {

            Licni.licniPodaci();
        });
        poeni.setOnAction(e -> {

            SviStudenti.execute();

        });
        StackPane sp = new StackPane();
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 300, 250);
        stage.setTitle("Ispis studenata");
        stage.setScene(scene);
        stage.show();

    }
}
