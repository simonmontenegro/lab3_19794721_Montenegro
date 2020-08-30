package laboratorio3_19794721;

import java.util.ArrayList;

public class RemoteRepository {
    public ArrayList<Commit> remoteRepository = new ArrayList<Commit>();
    
    //Atributos
    public ArrayList<Commit> getRemoteRepository() {
        return remoteRepository;
    }
    
    //Metodos
    public void setRemoteRepository(ArrayList<Commit> remoteRepository) {
        this.remoteRepository = remoteRepository;
    }
    
    //Constructor
    public void crearRemoteRepository(ArrayList<Commit> arc){
        this.remoteRepository = arc;
    }
}
