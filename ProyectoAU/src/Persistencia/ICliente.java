/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author User
 */
public interface ICliente {
    public void InicioSesion();

    public void elegirRuta();

    public void elegirFecha(LocalDate fecha);

    public void elegirHora(LocalTime hora);

    public void elegirCarga();

    public void elegirEncargo();

    public void calificarConductor();

    public void mostrarInfoCliente();
}

