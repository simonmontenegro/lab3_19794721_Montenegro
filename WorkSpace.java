package laboratorio3_19794721;

import java.util.ArrayList;

public class WorkSpace {
    //Atributos
    public ArrayList<Archivo> archivos = new ArrayList<Archivo>();
    
    //Constructor
    public void crearWorkSpace(ArrayList<Archivo> arc){
        this.archivos = arc;
    }
}
