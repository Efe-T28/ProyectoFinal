/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;


public class Reserva {
    private String infoUsuario;
    private String infoRuta;
    private String encargo;
    private String carga;
    private int codigo;

    public Reserva() {
    }

    public Reserva(String infoUsuario, String infoRuta, String encargo, String carga, int codigo) {
        this.infoUsuario = infoUsuario;
        this.infoRuta = infoRuta;
        this.encargo = encargo;
        this.carga = carga;
        this.codigo = codigo;
    }

    public String getInfoUsuario() {
        return infoUsuario;
    }

    public void setInfoUsuario(String infoUsuario) {
        this.infoUsuario = infoUsuario;
    }

    public String getInfoRuta() {
        return infoRuta;
    }

    public void setInfoRuta(String infoRuta) {
        this.infoRuta = infoRuta;
    }

    public String getEncargo() {
        return encargo;
    }

    public void setEncargo(String encargo) {
        this.encargo = encargo;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "Datos de la reserva guardada: \n    -Usuario:"+infoUsuario+"\n   -Ruta:"+infoRuta+"\n   -Encargo:"+encargo+"\n   -Carga:"+carga+"\n   -Codigo de reserva:"+codigo;
 }
}

