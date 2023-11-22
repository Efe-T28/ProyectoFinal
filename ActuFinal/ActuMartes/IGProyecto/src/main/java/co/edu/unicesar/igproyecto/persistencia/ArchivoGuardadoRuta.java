package co.edu.unicesar.igproyecto.persistencia;

import co.edu.unicesar.igproyecto.persistencia.IRuta;
import java.io.*;
import co.edu.unicesar.igproyecto.entidades.Ruta;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ArchivoGuardadoRuta implements IRuta {
    private static final String ARCHIVO_RUTAS = "rutas.txt"; 

    
    public ArchivoGuardadoRuta() {
        crearArchivo();
    }
    
    
    
    public void crearArchivo() {
        try {
            File archivo = new File(ARCHIVO_RUTAS);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
            }
        } catch (IOException e) {
        }
    }

    @Override
    public List<Ruta> cargarRutas() {
        List<Ruta> rutas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_RUTAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5) {
                    String origen = datos[0].trim();
                    String destino = datos[1].trim();
                    LocalTime hora = LocalTime.parse(datos[2].trim());
                    LocalDate fecha = LocalDate.parse(datos[3].trim());
                    double precio = Double.parseDouble(datos[5].trim());
                    int codigo = Integer.parseInt(datos[6]);

                    rutas.add(new Ruta(origen, destino, hora, fecha, precio,codigo));
                }
            }
            return rutas;
        } catch (IOException e) {
               throw new IllegalStateException("Error al leer archivo de rutas");
        }

        
    }

    @Override
    public void guardarRutas(List<Ruta> rutas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_RUTAS))) {
            for (Ruta ruta : rutas) {
                String linea = ruta.getOrigen() + ";" + ruta.getDestino() + ";" +
                              ruta.getHora() + ";" + ruta.getFecha() + ";" +
                              ruta.getCodigo() + ";" + ruta.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
             throw new IllegalStateException("Error al guardar archivo de rutas");
        }
    }
}
