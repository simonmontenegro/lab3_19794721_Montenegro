package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Archivo {
    //Atributos
    public String nombre;
    public String fecha;
    public String contenido;
    
    public String obtenerFechaActual() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
    
    //Constructor
    public void crearArchivo(String nom, String con){
        this.nombre = nom;
        this.fecha = obtenerFechaActual();
        this.contenido = con;
    }
    
}
