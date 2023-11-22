package vista;

import Logica.IGuardadoRuta;
import entidades.Administrador;
import entidades.Ruta;
import Persistencia.ListaRuta;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VistaAdministrador {

    private Administrador administrador;
    private ListaRuta listaRuta;
    private IGuardadoRuta guardadoRuta;

    private static final String CONTRASENA_CORRECTA = "admin";

    
    public VistaAdministrador(Administrador administrador, ListaRuta listaRuta, IGuardadoRuta guardadoRuta) {
        this.administrador = administrador;
        this.listaRuta = listaRuta;
        this.guardadoRuta = guardadoRuta;
    }

    
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.print("Ingrese la clave: ");
            String contraseña = scanner.nextLine();

            if (contraseña.equals(CONTRASENA_CORRECTA)) {
                System.out.println("Acceso permitido.");

                while (!salir) {
                    mostrarMenu();
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            modificarPrecioRuta();
                            break;
                        case 2:
                            agregarRuta();
                            break;
                        case 3:
                            consultarRuta();
                            break;
                        case 4:
                            eliminarRuta();
                            break;
                        case 5:
                            mostrarRutas();
                            break;
                        case 6:
                            mostrarUsuario();
                        case 7:
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                    }
            } else {
                System.out.println("Contraseña incorrecta");
            }
        }
    }

    
    private void mostrarMenu() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║    Menu del Administrador   ║");
        System.out.println("║═══════════════════════════════════║");
        System.out.println("║ 1. Modificar precio de ruta ║");
        System.out.println("║ 2. Ingresar una nueva Ruta  ║");
        System.out.println("║ 3. Consultar una ruta       ║");
        System.out.println("║ 4. Eliminar ruta            ║");
        System.out.println("║ 5. Mostrar todas las rutas  ║");
        System.out.println("║ 6. Mostrar al usuario       ║");
        System.out.println("║ 7. Salir                    ║");
        System.out.println("║═══════════════════════════════════║");
        System.out.print("Seleccione una opcion: ");
    }

    
    public void agregarRuta() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese los datos de la nueva ruta:");
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Hora (HH:mm): ");
        String horaStr = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaStr);
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Ruta nuevaRuta = new Ruta(origen, destino, hora, fecha, precio);

        this.guardadoRuta.agregarRuta(nuevaRuta);

        //listaRuta.mostrarRutas();

        //scanner.close();
    }
    
    public void modificarPrecioRuta(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el código de la ruta a la que desea modificar: ");
    int codigoRuta = scanner.nextInt();
    scanner.nextLine();

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    List<String> lineas = new ArrayList<>();
    
    try {
    archivo = new File("rutas.txt");
    fr = new FileReader(archivo);
    br = new BufferedReader(fr);

    String linea;
    while ((linea = br.readLine()) != null) {
        String lineaConsultada[] = linea.split(";");
        if (lineaConsultada.length > 4 && Integer.parseInt(lineaConsultada[4]) == codigoRuta) {
            System.out.println("ingrese el nuevo precio de la ruta");
            String nuevoPrecio = scanner.nextLine();
            lineaConsultada[5] = nuevoPrecio;
            linea = String.join(";", lineaConsultada); // Actualiza la línea con el nuevo precio
        }
        lineas.add(linea); // Añade todas las líneas (modificadas y no modificadas) a la lista
    }

    // Volver a escribir las líneas al archivo, incluyendo la línea modificada
    FileWriter fw = new FileWriter(archivo); // Sobrescribe el archivo
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    for (String l : lineas) {
        pw.println(l);
    }

    pw.close();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (fr != null) {
            fr.close();
        }
    } catch (IOException e2) {
        e2.printStackTrace();
    }
}
}

    
    
    public void consultarRuta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de la ruta a consultar: ");
        String codigo = scanner.nextLine();
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("rutas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaConsultada[] = linea.split(";");
                if(lineaConsultada[4].equals(codigo)){
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    


public void eliminarRuta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el código de la ruta que desea eliminar: ");
    int codigoRuta = scanner.nextInt();

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    List<String> lineas = new ArrayList<>();

    try {
        archivo = new File("rutas.txt");
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            String lineaConsultada[] = linea.split(";");
            if (Integer.parseInt(lineaConsultada[4]) == codigoRuta) {
                System.out.println("Ruta con código: " + codigoRuta + " eliminada correctamente.");
            } else {
                lineas.add(linea); // Conserva las líneas que no deben eliminarse
            }
        }

        // Volver a escribir las líneas al archivo, excluyendo la línea eliminada
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (String l : lineas) {
            pw.println(l);
        }

        pw.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}


 
 
    public void mostrarRutas() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("rutas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //listaRuta.mostrarRutas();
    }
    
    
    public void mostrarUsuario(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la fecha de la ruta (yyyy-MM-dd): ");
    String fechaStr = scanner.nextLine();
    LocalDate fecha = LocalDate.parse(fechaStr);
    System.out.println("Ingrese el origen de la ruta: ");
    String origen = scanner.nextLine();
    System.out.println("Ingrese el destino de la ruta: ");
    String destino = scanner.nextLine();
    
    List<Ruta> rutas = listaRuta.consultarRutaOP(origen, destino, fecha);

    if (rutas.isEmpty()) {
      System.out.println("No se encontraron rutas con las características ingresadas.");
    } else {
      for (Ruta ruta : rutas) {
        System.out.println(ruta.toString());
      }
    }
    
    }
}    
    
    