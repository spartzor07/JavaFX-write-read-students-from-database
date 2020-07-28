/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author cwiki
 */
public class Izbrisi {

    public static void izbrisi() {
   
        Stage stage = new Stage();
        Button indeks = new Button("Izbrisi");
        TextField tf1 = new TextField();
        tf1.setMaxSize(100, 20);
        Label lb1 = new Label("Ukucajte broj indeksa studenta za brisanje iz baze podataka");
        
        indeks.setOnAction(e->{ 
                 try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/baza", "root", "");
                Statement st = con.createStatement();
              
                PreparedStatement ps = con.prepareStatement("delete from studenti where indeks = ?");

                ps.setString(1, tf1.getText());
               

                ps.execute();
                AlertBoxIzbrisi1.alertIzbrisi1();
            } catch (SQLException ex) {
                Logger.getLogger(Upis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Upis.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }) ;

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(lb1,tf1,indeks);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 350, 300);
        stage.setTitle("Izbrisi studenta");
        stage.setScene(scene);
        stage.show();
      
    }
}
