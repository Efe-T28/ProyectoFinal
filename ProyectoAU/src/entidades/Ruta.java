
package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ruta {
    private static int noConsecutivo = 0;
    private String origen;
    private String destino;
    private LocalTime hora;
    private LocalDate fecha;
    private int codigo;
    private double precio;

    public Ruta() {
    }

    public Ruta(String origen, String destino, LocalTime hora, LocalDate fecha, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.fecha = fecha;
        this.codigo = codigoConsecutivo();
        this.precio = precio;
    }

    public static int getNoConsecutivo() {
        return noConsecutivo;
    }

    public static void setNoConsecutivo(int noConsecutivo) {
        Ruta.noConsecutivo = noConsecutivo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    private int codigoConsecutivo(){
    noConsecutivo++;
    return noConsecutivo;
    
    }
    
    @Override
    public String toString() {
        return "Ruta = " + "origen:" + origen + ", destino:" + destino + ", hora:" + hora + ", fecha:" + fecha + ", codigo:" + codigo + ", precio:" + precio ;
    }
    
}
