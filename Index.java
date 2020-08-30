package laboratorio3_19794721;

import java.util.ArrayList;

public class Index {
    //Atributos
    public ArrayList<Archivo> archivos = new ArrayList<Archivo>();

    //Metodos
    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }
    
    //Constructor
    public void crearIndex(ArrayList<Archivo> arc){
        this.archivos = arc;
    }
}
