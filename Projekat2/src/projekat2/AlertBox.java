/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

import javafx.scene.control.Alert;

/**
 *
 * @author cwiki
 */
public class AlertBox  {

    public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("Uspesno ste uneli studenta!");
        al.setTitle("Warning!");
        al.show();
    }

}
