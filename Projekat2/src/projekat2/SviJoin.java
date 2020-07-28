/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class SviJoin {

    public static void svi() {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/baza", "root", "");
            st = con.createStatement();
            System.out.println("Uspesno povezano");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Nije uspelo povezivanje");
        }
//Button prepravi = new Button("Prepravi");
        Button izbrisi = new Button("Izbrisi");

        Label ime = new Label("Ime");
        Label prezime = new Label("Prezime");
        Label indeks = new Label("Broj indeksa");
        Label predmet = new Label("Naziv predmeta");
        Label bodovi = new Label("Broj bodova");
        Label ocena = new Label("Ocena");
        Label ulica = new Label("Uliac");
        Label grad = new Label("Grad");
        Label jmbg = new Label("JMBG");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();
        TextField tf8 = new TextField();
        TextField tf9 = new TextField();
//pravljenje tabele
        TableView tv = new TableView();

        TableColumn<String, StudentJoin> column1 = new TableColumn<>("Ime");
        column1.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<String, StudentJoin> column2 = new TableColumn<>("Prezime");
        column2.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<String, StudentJoin> column3 = new TableColumn<>("Indeks");
        column3.setCellValueFactory(new PropertyValueFactory<>("indeks"));

        TableColumn<String, StudentJoin> column4 = new TableColumn<>("Predmet");
        column4.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        TableColumn<String, StudentJoin> column5 = new TableColumn<>("Bodovi");
        column5.setCellValueFactory(new PropertyValueFactory<>("bodovi"));

        TableColumn<String, StudentJoin> column6 = new TableColumn<>("Ocena");
        column6.setCellValueFactory(new PropertyValueFactory<>("ocena"));

        TableColumn<String, StudentJoin> column7 = new TableColumn<>("Ulica");
        column7.setCellValueFactory(new PropertyValueFactory<>("ulica"));

        TableColumn<String, StudentJoin> column8 = new TableColumn<>("Grad");
        column8.setCellValueFactory(new PropertyValueFactory<>("grad"));

        TableColumn<String, StudentJoin> column9 = new TableColumn<>("JMBG");
        column9.setCellValueFactory(new PropertyValueFactory<>("jmbg"));

        tv.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
//iscitavanje iz baze i ubacivanje u tabelu
        try {

            String query = "SELECT studenti.ime,studenti.prezime,studenti.indeks,studenti.predmet,studenti.bodovi,studenti.ocena,\n"
                    + "studentilicni.ime, studentilicni.prezime, studentilicni.indeks, studentilicni.ulica, studentilicni.grad, studentilicni.jmbg \n"
                    + "FROM studenti RIGHT OUTER JOIN studentilicni ON studenti.indeks=studentilicni.indeks";
            rs = st.executeQuery(query);
            System.out.println("Uspesno iscitani");
            while (rs.next()) {

                tv.getItems().addAll(new StudentJoin(rs.getString("ime"), rs.getString("prezime"), rs.getInt("indeks"), rs.getString("predmet"), rs.getDouble("bodovi"),
                        rs.getInt("ocena"), rs.getString("ulica"), rs.getString("grad"), rs.getString("jmbg")));

            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nisu dodati ucenici");
        }
        tv.setOnMouseClicked(e -> {

            StudentJoin student = (StudentJoin) tv.getSelectionModel().getSelectedItem();
            String ime1 = student.getIme();
            String prezime1 = student.getPrezime();
            int indeks1 = student.getIndeks();
            String predmet1 = student.getPredmet();
            double bodovi1 = student.getBodovi();
            int ocena1 = student.getOcena();
            String ulica1 = student.getUlica();
            String grad1 = student.getGrad();
            String jmbg1 = student.getJmbg();
            tf1.setText(ime1);
            tf2.setText(prezime1);
            tf3.setText(String.valueOf(indeks1));
            tf4.setText(predmet1);
            tf5.setText(String.valueOf(bodovi1));
            tf6.setText(String.valueOf(ocena1));
            tf7.setText(String.valueOf(ulica1));
            tf8.setText(String.valueOf(grad1));
            tf9.setText(String.valueOf(jmbg1));
            tv.refresh();
        });

        izbrisi.setOnAction(e -> {
            Izbrisi.izbrisi();
            tv.getItems().removeAll(tv.getSelectionModel().getSelectedItem());

        });
//        prepravi.setOnAction(e -> {
//            String query = "update studenti set ime = :ime, prezime = :prezime, indeks=:indeks, predmet = :predmet, bodovi= :bodovi, ocena = :ocena"+"where indeks = :indeks ";
//            Query q = session.createQuery(query);
//            
//
//        });

        Stage stage = new Stage();
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
        HBox hb9 = new HBox(15);
        hb9.getChildren().addAll(ulica, tf7);
        HBox hb10 = new HBox(15);
        hb10.getChildren().addAll(grad, tf8);
        HBox hb11 = new HBox(15);
        hb11.getChildren().addAll(jmbg, tf9);
        HBox hb7 = new HBox(15);
        hb7.getChildren().addAll(izbrisi);
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(tv);
        VBox vb2 = new VBox(15);
        vb2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, hb6, hb9, hb10, hb11, hb7);
        HBox hb8 = new HBox(15);
        hb8.getChildren().addAll(vb2, vb1);

        Pane sp = new Pane();
        sp.getChildren().addAll(hb8);

        Scene scene = new Scene(sp, 900, 500);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

}
