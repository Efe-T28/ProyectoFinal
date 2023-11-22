/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.igproyecto;

import co.edu.unicesar.igproyecto.entidades.Ruta;
import co.edu.unicesar.igproyecto.logica.IAgregarRutas;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class VentanaAgregarController implements Initializable {
    
    @FXML
    private ComboBox<String> cbboxDestino, cbboxOrigen;
    
    @FXML
    private TextField txtHoraSalida, txtCodigo, txtPrecio;
    
    @FXML
    private DatePicker dpFechaSalida;
    
    //private IAgregarRutas habla;
    private ObservableList<String> listPlace = FXCollections.observableArrayList();
    private ObservableList<String> listPlace2 = FXCollections.observableArrayList();
    
    private int codigo = 0;
    
    @FXML
    private void clickBotonGuardar(){
        
        
        Ruta nuevaRuta;
        String origen = this.cbboxOrigen.getSelectionModel().getSelectedItem();
        String destino = this.cbboxDestino.getSelectionModel().getSelectedItem();
        LocalTime hora = LocalTime.parse(this.txtHoraSalida.getText());
        LocalDate fechaSalida = this.dpFechaSalida.getValue();
        Double precio = Double.valueOf(this.txtPrecio.getText());
        //nuevaRuta = new Ruta(origen, destino, hora, fechaSalida, precio);
        //Aqui solo falta agregar la ruta
        nuevaRuta = new Ruta(origen, destino, hora, fechaSalida, precio, codigo);
        codigo++; // Incrementar el código

        // Guardar la información en un archivo .txt
        try {
            FileWriter writer = new FileWriter("ruta.txt", true);
            writer.write(origen + ";" + destino + ";" + hora + ";" + fechaSalida + ";" + precio + ";" + codigo + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Agregacion exitosa");
        alert.setHeaderText(null);
        alert.setContentText("La ruta ha sido agregada con exito");
        alert.initOwner(null);
        alert.showAndWait();
        this.limpiarEspacios();
    }
    
    @FXML
    private void clickBotonVolver() throws IOException{
        App.newStage("VentanaAdmin", true,900, 640);
    }
    
    @FXML
    private void clickBotonCancelar() {
        this.limpiarEspacios();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.listPlace.add("Valledupar");
        this.listPlace.add("Pueblo Bello");
        this.listPlace.add("Bosconia");
        this.listPlace.add("Astrea");
        this.listPlace.add("Aguachica");
        this.listPlace.add("La Paz");
        this.listPlace.add("La Mina");
        this.listPlace.add("Manaure");
        this.listPlace.add("Nabuzimake");
        this.listPlace.add("Chimichagua");
        this.listPlace.add("Codazzi");
        this.listPlace.add("San Alberto");
        this.listPlace.add("La Jagua de Ibirico");
        this.listPlace.add("San Diego");
        this.listPlace.add("Urumita");
        this.listPlace.add("Villanueva");
        this.listPlace.add("El Molino");
        
//        this.listPlace2.add("Josh vonderhart");
//        this.listPlace2.add("Fabio Orozco");
//        this.listPlace2.add("Sebastian Paredes");
//        this.listPlace2.add("Bob Carrillo");
//        this.listPlace2.add("Menes Hernandez");
        this.cbboxDestino.setItems(listPlace);
        this.cbboxOrigen.setItems(listPlace);
        //this.cbboxConductor.setItems(listPlace2);
        this.txtCodigo.setDisable(true);
    }    
    
    public void limpiarEspacios(){
        this.cbboxDestino.setItems(listPlace);
        this.cbboxOrigen.setItems(listPlace);
        this.dpFechaSalida.setValue(null);
        this.txtCodigo.setText(null);
        this.txtHoraSalida.setText(null);
        this.txtPrecio.setText(null);
        this.cbboxOrigen.requestFocus();
    }
    
}
