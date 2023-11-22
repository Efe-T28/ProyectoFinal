
package co.edu.unicesar.igproyecto.persistencia;


import co.edu.unicesar.igproyecto.entidades.Ruta;
import co.edu.unicesar.igproyecto.logica.IGuardadoRuta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ListaRuta  {
    private static final String ARCHIVO_RUTAS = "rutas.txt"; 
    public List<Ruta> rutas;

    public ListaRuta(IGuardadoRuta rutaDT) {
        this.rutas = rutaDT.mostrarRuta();
    }

    
    public Ruta consultarRuta(String codigo) {
        for (Ruta ruta : rutas) {
            if (ruta.getCodigo() == Integer.parseInt(codigo)) {
                System.out.println("Ruta encontrada: " + ruta.toString());
                return ruta ;
            }
        }
        System.out.println("Ruta no encontrada.");
        return null;
    }
    
    
    
    public void mostrarRutas() {
        if(rutas.isEmpty()){
            System.out.println("No hay rutas disponibles.");
        }else{
        for (Ruta ruta : rutas) {
            System.out.println(ruta.toString());
        }
    }
 }
    
    public void guardarRutas() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_RUTAS))) {
        for (Ruta ruta : rutas) {
            String linea = ruta.getOrigen() + ";" + ruta.getDestino() + ";" +
                              ruta.getHora() + ";" + ruta.getFecha() + ";" +
                              ruta.getCodigo() + ";" + ruta.getPrecio();
            bw.write(linea);
            bw.newLine();
        }
    } catch (IOException e) {

    }
}

   
    public void eliminarRuta(int codigoRuta) {
        Ruta rutaAEliminar = null;
        for (Ruta ruta : rutas) {
            if (ruta.getCodigo() == codigoRuta) {
                rutaAEliminar = ruta;
                break;
            }
        }
        if (rutaAEliminar != null) {
            rutas.remove(rutaAEliminar);
            guardarRutas();
        }
    }
    
    public List<Ruta> consultarRutaOP(String origen, String destino, LocalDate fecha){
    List<Ruta> rutas = new ArrayList<>();    
        for (Ruta ruta : this. rutas) {
            if (ruta.getFecha().equals(fecha)&& 
                ruta.getOrigen().equals(origen)&&
                ruta.getDestino().equals(destino)) {
                rutas.add(ruta);
            }
        }
        if(rutas.isEmpty()){
        System.out.println("Ruta no encontrada.");
        }
        return rutas;
    }
}

    
