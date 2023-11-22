package co.edu.unicesar.igproyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaInicio"));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void newStage(String fxml, boolean modo, int w, int h) throws IOException{
        
        Window window = scene.getWindow();
        Stage actual = (Stage)window;
        
        if(modo){
            actual.hide();
        }
        
        Parent rootNode = loadFXML(fxml);
        scene = new Scene(rootNode);
        
        Stage nueva = new Stage();
        nueva.setScene(scene);
        nueva.setWidth(w);
        nueva.setHeight(h);
        nueva.centerOnScreen();
        nueva.setTitle("Ruta Segura - Aplicacion");
        nueva.show();
        
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}