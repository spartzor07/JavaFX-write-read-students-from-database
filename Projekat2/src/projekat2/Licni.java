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
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class Licni extends StudentLicni{

    //    private Connection con;
//    private Statement st;
//    private ResultSet rs;
//    private PreparedStatement ps;
    public static void licniPodaci() {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Label ime = new Label("Ime");
        Label prezime = new Label("Prezime");
        Label indeks = new Label("Broj indeksa");
        Label ulica = new Label("Naziv ulice");
        Label grad = new Label("Naziv grada");
        Label jmbg = new Label("JMBG");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        Button izbrisi = new Button("Izbrisi");
        Button prepravi = new Button("Prepravi");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/baza", "root", "");
            st = con.createStatement();
            System.out.println("Uspesno povezano");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Nije uspelo povezivanje");
        }

        TableView tv = new TableView();

        TableColumn<String, Student> column1 = new TableColumn<>("Ime");
        column1.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<String, Student> column2 = new TableColumn<>("Prezime");
        column2.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<String, Student> column3 = new TableColumn<>("Indeks");
        column3.setCellValueFactory(new PropertyValueFactory<>("indeks"));

        TableColumn<String, Student> column4 = new TableColumn<>("Ulica");
        column4.setCellValueFactory(new PropertyValueFactory<>("ulica"));

        TableColumn<String, Student> column5 = new TableColumn<>("Grad");
        column5.setCellValueFactory(new PropertyValueFactory<>("grad"));

        TableColumn<String, Student> column6 = new TableColumn<>("JMBG");
        column6.setCellValueFactory(new PropertyValueFactory<>("jmbg"));

        tv.getColumns().addAll(column1, column2, column3, column4, column5, column6);

        try {

            String query = "select * from studentilicni";
            rs = st.executeQuery(query);
            System.out.println("Uspesno iscitani");
            while (rs.next()) {

                tv.getItems().addAll(new StudentLicni(rs.getString("ime"), rs.getString("prezime"), rs.getInt("indeks"), rs.getString("ulica"), rs.getString("grad"),
                        rs.getString("jmbg")));

            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nisu dodati ucenici");
        }
         tv.setOnMouseClicked(e -> {

            StudentLicni student = (StudentLicni) tv.getSelectionModel().getSelectedItem();
            String ime1 = student.getIme();
            String prezime1 = student.getPrezime();
            int indeks1 = student.getIndeks();
            String ulica1 = student.getUlica();
            String grad1 = student.getGrad();
            String jmb1 = student.getJmbg();
            tf1.setText(ime1);
            tf2.setText(prezime1);
            tf3.setText(String.valueOf(indeks1));
            tf4.setText(ulica1);
            tf5.setText(String.valueOf(grad1));
            tf6.setText(String.valueOf(jmb1));

        });

         
         izbrisi.setOnAction(e -> {
            IzbrisiLicni.izbrisi();
            tv.getItems().removeAll(tv.getSelectionModel().getSelectedItem());

        }); 
          prepravi.setOnAction(e -> {
          
            UpdateLicnih.updateLicnih();

        });
        
        Stage stage = new Stage();
        HBox hb1 = new HBox(15);
        hb1.getChildren().addAll(ime, tf1);
        HBox hb2 = new HBox(15);
        hb2.getChildren().addAll(prezime, tf2);
        HBox hb3 = new HBox(15);
        hb3.getChildren().addAll(indeks, tf3);
        HBox hb4 = new HBox(15);
        hb4.getChildren().addAll(ulica, tf4);
        HBox hb5 = new HBox(15);
        hb5.getChildren().addAll(grad, tf5);
        HBox hb6 = new HBox(15);
        hb6.getChildren().addAll(jmbg, tf6);
        HBox hb7 = new HBox(15);
        hb7.getChildren().addAll(prepravi,izbrisi);
        VBox vb2 = new VBox(15);
        vb2.getChildren().addAll(hb1, hb2, hb3, hb4, hb5, hb6, hb7);
       
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(tv);
        HBox hb8 = new HBox(15);
        hb8.getChildren().addAll(vb2, vb1);
        Pane sp = new Pane();
        sp.getChildren().addAll(hb8);

        Scene scene = new Scene(sp, 700, 300);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

}
