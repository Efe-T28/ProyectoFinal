/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.igproyecto;

import co.edu.unicesar.igproyecto.entidades.Ruta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class VentanaAdminController implements Initializable {
    
    @FXML
    private TableView<Ruta> tablaRutas;
    @FXML
    private TableColumn<Ruta, String> columnaOrigen;
    @FXML
    private TableColumn<Ruta, String> columnaDestino;
    @FXML
    private TableColumn<Ruta, LocalTime> columnaHora;
    @FXML
    private TableColumn<Ruta, LocalDate> columnaFechaSalida;
    @FXML
    private TableColumn<Ruta, Double> columnaPrecio;
    @FXML
    private TableColumn<Ruta, Integer> columnaCodigo;

    @FXML
    private ComboBox<String> cbboxBusOrigen, cbboxBusDestino;
    
    @FXML
    private Button btAgregar, btnBuscar;
    
    private ObservableList<String> listPlace = FXCollections.observableArrayList();
    
    public void clickBotonAgregar (ActionEvent e) throws IOException{
        App.newStage("VentanaAgregar", true,900, 690);
    }
    
    public void clickBotonSalir (ActionEvent e) throws IOException{
        App.newStage("VentanaInicio", true,750, 690);
    }
    
    public void clickBotonBuscar() throws IOException{
        
        String origenBusq = this.cbboxBusOrigen.getSelectionModel().getSelectedItem();
        String destinoBusq = this.cbboxBusDestino.getSelectionModel().getSelectedItem();
        // Define las columnas de la tabla
        columnaOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        columnaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        // Crea una lista para almacenar las rutas
        ObservableList<Ruta> data = FXCollections.observableArrayList();

        // Lee las rutas del archivo .txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ruta.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if(origenBusq.equals(parts[0]) && destinoBusq.equals(parts[1])){
                    String origen = parts[0];
                    String destino = parts[1];
                    LocalTime hora = LocalTime.parse(parts[2]);
                    LocalDate fechaSalida = LocalDate.parse(parts[3]);
                    Double precio = Double.valueOf(parts[4]);
                    int codigo = Integer.parseInt(parts[5]);
                    Ruta ruta = new Ruta(origen, destino, hora, fechaSalida, precio, codigo);
                    data.add(ruta);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Muestra las rutas en la tabla
        tablaRutas.setItems(data);
    }
    
    @FXML
    private void clickBotonEliminar() {
        // Obtiene la ruta seleccionada
        Ruta rutaSeleccionada = tablaRutas.getSelectionModel().getSelectedItem();

        // Muestra una ventana de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de eliminación");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que quieres eliminar este registro?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Si el usuario confirma la eliminación, elimina el registro
            eliminarRegistro(rutaSeleccionada);
        }
    }
    
    private void eliminarRegistro(Ruta ruta) {
        try {
            // Lee todas las líneas del archivo
            List<String> lines = Files.readAllLines(Paths.get("ruta.txt"));

            // Filtra las líneas para excluir la línea que quieres eliminar
            lines = lines.stream()
                    .filter(line -> !line.equals(ruta.toString()))
                    .collect(Collectors.toList());

            // Escribe las líneas restantes de nuevo en el archivo
            Files.write(Paths.get("ruta.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        this.cbboxBusDestino.setItems(listPlace);
        this.cbboxBusOrigen.setItems(listPlace);
        

        // Define las columnas de la tabla
        columnaOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        columnaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        // Crea una lista para almacenar las rutas
        ObservableList<Ruta> data = FXCollections.observableArrayList();

        // Lee las rutas del archivo .txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ruta.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String origen = parts[0];
                String destino = parts[1];
                LocalTime hora = LocalTime.parse(parts[2]);
                LocalDate fechaSalida = LocalDate.parse(parts[3]);
                Double precio = Double.valueOf(parts[4]);
                int codigo = Integer.parseInt(parts[5]);
                Ruta ruta = new Ruta(origen, destino, hora, fechaSalida, precio, codigo);
                data.add(ruta);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Muestra las rutas en la tabla
        tablaRutas.setItems(data);
    }
    
}

