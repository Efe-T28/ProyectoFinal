/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.igproyecto;

import co.edu.unicesar.igproyecto.logica.InicioAdmin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class VentanaInicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private PasswordField txtPasswordAdmin;
    private TextField txtNameUser;
    
    @FXML
    private Button btmLoginAdmin,btmLoginNameUser;
    
    @FXML
    public void clickBtmLoginAdmin (ActionEvent e) throws IOException{
        String password = this.txtPasswordAdmin.getText();
        InicioAdmin.validarAdmin(password);
        if(InicioAdmin.getAdminEnt()!=null){
            App.newStage("VentanaAdmin", true,900, 640);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inicio denegado");
            alert.setHeaderText(null);
            alert.setContentText("Lo que usted ingreso no es la contraseña de administrador");
            alert.initOwner(null);
            alert.showAndWait();
        }
    }
            
    @FXML
    public void clickBtmNameUser (ActionEvent e) throws IOException{
        //String nombre = this.txtNameUser.getText();
        App.newStage("VentanaUsuario", true,900, 640);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
