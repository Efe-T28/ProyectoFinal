/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.IUsuario;
import Persistencia.ListaUsuario;
import entidades.Usuario;
import persistencia.*; 
import java.util.List;
/**
 *
 * @author User
 */
public class LogicaUsuario {
    private IUsuario datos ; 

    public LogicaUsuario() {
        this.datos = (IUsuario) new ListaUsuario() ;
    }
    public void registroUsuario(Usuario T) {
        this.datos.agregarUsuario(T);   
    }
    public List<Usuario> mostrarDatosUsuarios () {
        return this.datos.mostrarDatosUsuarios();
    }
   
    public Usuario consultarUsuario (String infoUsuario){
        return this.datos.consultarUsuario(infoUsuario);
    }
}
