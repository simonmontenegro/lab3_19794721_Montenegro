package laboratorio3_19794721;

import java.util.ArrayList;

public class LocalRepository {
    //Atributos
    public ArrayList<Commit> commits = new ArrayList<Commit>();
    
    //Constructor
    public void crearLocalRepository(ArrayList<Commit> arc){
        this.commits = arc;
    }
}
