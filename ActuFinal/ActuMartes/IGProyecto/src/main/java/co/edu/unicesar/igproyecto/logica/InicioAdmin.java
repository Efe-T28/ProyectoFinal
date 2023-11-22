/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.igproyecto.logica;

/**
 *
 * @author luism
 */
public class InicioAdmin {

    private static String contraseña = "Root";
    private static String adminEnt;
    
    public static void validarAdmin(String password) {
        
        if(contraseña.equals(password)){
            adminEnt = "Cuenta admin";
        }else{
            adminEnt = null;
        }
    }
    
    public static void setAdminEnt(String AdminEnt) {
        adminEnt = AdminEnt;
    }
    
    public static String getAdminEnt() {
        return adminEnt;
    } 
    
}
