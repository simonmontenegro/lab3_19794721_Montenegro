//@author Simon Alonso Montenegro Bastias
//Rut 19.794.721-7
//Ultimo Edit: 06/09/2020
//@version 1.8

package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Una clase para representar la unidad basica de informacion de git: Archivo.
 * Cada archivo esta determinado por el nombre, fecha de creacion y contenido.
 * @version 1.8
 * @author Simón Montenegro
 */
public class Archivo {
    public String nombre;
    public String fecha;
    public String contenido;
    
    /** 
      * metodo que obtiene la fecha actual del sistema
      * @return fecha actual del sistema
      */
    public String obtenerFechaActual() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
    
    /** 
      * Constructor de la clase.
      * @param nom nombre del archivo
      * @param con contenido del archivo
      */
    public void crearArchivo(String nom, String con){
        this.nombre = nom;
        this.fecha = obtenerFechaActual();
        this.contenido = con;
    }
    
    
}
