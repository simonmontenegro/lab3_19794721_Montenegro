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
    
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public void crearArchivo(String nom, String con){
        nombre = nom;
        fecha = obtenerFechaActual();
        contenido = con;
    }
    
}
