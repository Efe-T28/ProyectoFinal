
package Vista;

import entidades.Administrador;
import Persistencia.ListaRuta;
import Logica.IGuardadoRuta;
import vista.VistaAdministrador;

public class Main {
    public static void main(String[] args) {
        Administrador administrador = new Administrador("NombreAdmin", "123456", "Dirección", "123456789", "contraseña", "admin");
        ListaRuta listaRuta = new ListaRuta(new IGuardadoRuta());
        
        IGuardadoRuta guardadoRuta = new IGuardadoRuta(); 
        
        VistaAdministrador vistaAdmin = new VistaAdministrador(administrador, listaRuta, guardadoRuta);

        
       //vistaAdmin.ejecutarMenu();
        vistaAdmin.menuPrincipal();
      
    }
}
