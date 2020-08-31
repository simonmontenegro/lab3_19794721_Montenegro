package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Commit {
    //Atributos
    public String autor;
    public String mensaje;
    public String tiempo;
    public ArrayList<Archivo> archivos = new ArrayList<Archivo>();
    
    
    public String obtenerFechaActual() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
     
    //Constructor
    public void crearCommit(String aut, String mens, ArrayList<Archivo> arc){
        this.autor = aut;
        this.mensaje = mens;
        this.tiempo = obtenerFechaActual();
        this.archivos = arc;
    }
}
