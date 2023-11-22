package co.edu.unicesar.igproyecto.logica;

import co.edu.unicesar.igproyecto.entidades.Ruta;
import co.edu.unicesar.igproyecto.persistencia.ArchivoGuardadoRuta;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class IGuardadoRuta {

    private List<Ruta> rutas;
    private ArchivoGuardadoRuta archivoGuardadoRuta;
    private String ARCHIVO_RUTAS;

    public IGuardadoRuta() {
        ARCHIVO_RUTAS = "rutas.txt";
        archivoGuardadoRuta = new ArchivoGuardadoRuta();
        rutas = archivoGuardadoRuta.cargarRutas();
    }

    public List<Ruta> mostrarRuta() {
        return rutas;

    }

    public Ruta consultarRuta(int codigo) {
        for (Ruta ruta : rutas) {
            if (ruta.getCodigo() == codigo) {
                return ruta;
            }
        }
        return null;

    }

    public void modificarRuta(int codigo, Ruta nuevaRuta) {
        for (int i = 0; i < rutas.size(); i++) {
            Ruta ruta = rutas.get(i);
            if (ruta.getCodigo() == codigo) {
                // Actualiza los atributos de la ruta con los de la nuevaRuta
                ruta.setOrigen(nuevaRuta.getOrigen());
                ruta.setDestino(nuevaRuta.getDestino());
                ruta.setHora(nuevaRuta.getHora());
                ruta.setFecha(nuevaRuta.getFecha());
                ruta.setPrecio(nuevaRuta.getPrecio());
                return;

            }
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

    public void guardarRutas() {
        archivoGuardadoRuta.guardarRutas(rutas);
    }

    public void agregarRuta(Ruta nuevaRuta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_RUTAS, true))) {
            String linea = nuevaRuta.getOrigen() + ";" + nuevaRuta.getDestino() + ";"
                    + nuevaRuta.getHora() + ";" + nuevaRuta.getFecha() + ";"
                    + nuevaRuta.getCodigo() + ";" + nuevaRuta.getPrecio();
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
        }
    }
}
