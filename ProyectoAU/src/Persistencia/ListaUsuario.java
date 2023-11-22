/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class ListaUsuario implements IUsuario {
    private List<Usuario> listaUsuario;
    
    public ListaUsuario(){
        this.listaUsuario =  new ArrayList();
    }
    
    @Override
    public void agregarUsuario(Usuario T){
        this.listaUsuario.add(T);
    }
    
    public ArrayList<Usuario> mostrarDatos(){
        ArrayList<Usuario> ListaU = new ArrayList(this.listaUsuario);
        return ListaU;
    }
    
    @Override
    public Usuario consultarUsuario(String infoUsuario){
        Usuario usuarioConsultado =null;
        for(Usuario T: this.listaUsuario){
            if(T.getCc() == null ? infoUsuario == null : T.getCc().equals(infoUsuario)){
                usuarioConsultado = T;
                break;
            }
        }
        return usuarioConsultado;
    }

    public ArrayList<Usuario> mostrarDatosUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
