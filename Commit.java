//@author Simon Alonso Montenegro Bastias
//Rut 19.794.721-7
//Ultimo Edit: 06/09/2020
//@version 1.8

package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Una clase para representar la segunda unidad de información basica: Commit.
 * Cada commit esta determinado por el autor, fecha de creacion, mensaje y archivos asociados.
 * @version 1.8
 * @author Simón Montenegro
 */
public class Commit {
    public String autor;
    public String mensaje;
    public String tiempo;
    public ArrayList<Archivo> archivos = new ArrayList<Archivo>();
    
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
      * @param aut autor del commit.
      * @param mens mensaje asociado al commit.
      * @param arc archivos asociados al commit.
      */
    public void crearCommit(String aut, String mens, ArrayList<Archivo> arc){
        this.autor = aut;
        this.mensaje = mens;
        this.tiempo = obtenerFechaActual();
        this.archivos = arc;
    }
}
