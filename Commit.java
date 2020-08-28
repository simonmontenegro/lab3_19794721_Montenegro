package laboratorio3_19794721;

import java.*;
import java.util.ArrayList;

public class Commit {
    //Atributos
    public String autor;
    public String mensaje;
    public String tiempo;
    public ArrayList<Archivo> archivos = new ArrayList<Archivo>();
    
    //Metodos
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }
    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }
    public void crearCommit(String aut, String mens, String tiem, ArrayList<Archivo> arc){
        autor = aut;
        mensaje = mens;
        tiempo = tiem;
        archivos = arc;
    }
}
