package laboratorio3_19794721;

import java.util.ArrayList;

public class LocalRepository {
    //Atributos
    public ArrayList<Commit> localRepository = new ArrayList<Commit>();

    //Metodos
    public ArrayList<Commit> getLocalRepository() {
        return localRepository;
    }

    public void setLocalRepository(ArrayList<Commit> localRepository) {
        this.localRepository = localRepository;
    }
    
    //Constructor
    public void crearLocalRepository(ArrayList<Commit> arc){
        this.localRepository = arc;
    }
}
