/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author User
 */
public abstract class Usuario {
    
    
    //private static int usuarioCodigo=0;
    //private int cdSeguido;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String contraseña;
    private String username;

    public Usuario() {  
        //usuarioCodigo++;
        //this.cdSeguido=usuarioCodigo;
    }

    public Usuario(String nombre, String cedula, String direccion, String telefono, String contraseña, String username) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.username = username;
        //usuarioCodigo++;
        //this.cdSeguido=usuarioCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public abstract String toString();
    public abstract boolean inicioSesion();
        
    public String infoUsuario() {
       return String.format("Nombre: %s\nCedula: %s\nDirección: %s\nTelefono: %s\nUsername: %s",
            this.nombre, this.cedula, this.direccion, this.telefono, this.username);
}

    public Object getCc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
