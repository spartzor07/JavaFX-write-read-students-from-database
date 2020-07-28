/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class Update {

    public static void update() {

        Stage stage = new Stage();
        Label ime = new Label("Ime");
        Label prezime = new Label("Prezime");
        Label indeks = new Label("Broj indeksa");
        Label predmet = new Label("Naziv predmeta");
        Label bodovi = new Label("Broj bodova");
        Label ocena = new Label("Ocena");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        Button prepravi = new Button("Prepravi");
        prepravi.setOnAction(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/baza", "root", "");
                Statement st = con.createStatement();

                PreparedStatement ps = con.prepareStatement("update studenti set ime = ?, prezime = ?, indeks = ?, predmet = ?, bodovi = ?, ocena = ? where indeks = ?");

                ps.setString(1, tf1.getText().substring(0, 1).toUpperCase() + tf1.getText().substring(1));
                ps.setString(2, tf2.getText().substring(0, 1).toUpperCase() + tf2.getText().substring(1));
                ps.setString(3, (tf3.getText().substring(0, 1).toUpperCase() + tf3.getText().substring(1)));
                ps.setString(4, tf4.getText().substring(0, 1).toUpperCase() + tf4.getText().substring(1));
                ps.setString(5, (tf5.getText().substring(0, 1).toUpperCase() + tf5.getText().substring(1)));
                ps.setString(6, (tf6.getText().substring(0, 1).toUpperCase() + tf6.getText().substring(1)));
                ps.setString(7, (tf3.getText().substring(0, 1).toUpperCase() + tf3.getText().substring(1)));
//                ps.setString(1, sv.getIme());
//                ps.setString(2, sv.getPrezime());
//                ps.setString(3, String.valueOf(sv.getIndeks()));
//                ps.setString(4, sv.getPredmet());
//                ps.setString(5, String.valueOf(sv.getBodovi()));
//                ps.setString(6, String.valueOf(sv.getOcena()));
//                ps.setString(7, String.valueOf(sv.getIndeks()));

                ps.execute();
                AlertBox.alert();
            } catch (SQLException ex) {
                Logger.getLogger(Upis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Upis.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        HBox hb1 = new HBox(15);
        hb1.getChildren().addAll(ime, tf1);
        HBox hb2 = new HBox(15);
        hb2.getChildren().addAll(prezime, tf2);
        HBox hb3 = new HBox(15);
        hb3.getChildren().addAll(indeks, tf3);
        HBox hb4 = new HBox(15);
        hb4.getChildren().addAll(predmet, tf4);
        HBox hb5 = new HBox(15);
        hb5.getChildren().addAll(bodovi, tf5);
        HBox hb6 = new HBox(15);
        hb6.getChildren().addAll(ocena, tf6);
        HBox hb7 = new HBox(15);
        hb7.getChildren().addAll(prepravi);

        VBox vb2 = new VBox(15);
        vb2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, hb6, hb7);

        Pane sp = new Pane();
        sp.getChildren().addAll(vb2);

        Scene scene = new Scene(sp, 450, 400);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
}
