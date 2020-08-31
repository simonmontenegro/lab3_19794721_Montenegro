package laboratorio3_19794721;

import java.util.ArrayList;

public class RemoteRepository {
    //Atributos
    public ArrayList<Commit> commits = new ArrayList<Commit>();
    
    //Constructor
    public void crearRemoteRepository(ArrayList<Commit> arc){
        this.commits = arc;
    }
}
