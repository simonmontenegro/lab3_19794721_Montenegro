package laboratorio3_19794721;

import java.util.ArrayList;

public class Laboratorio3_19794721 {
    public static Zonas gitInit(String nombre, String autor){
        ArrayList<Archivo> ws = new ArrayList<Archivo>();
        ArrayList<Archivo> ind = new ArrayList<Archivo>();
        ArrayList<Commit> lr = new ArrayList<Commit>();
        ArrayList<Commit> rr = new ArrayList<Commit>();
        
        WorkSpace workSpace = new WorkSpace();
        Index index = new Index();
        LocalRepository localRepository = new LocalRepository();
        RemoteRepository remoteRepository = new RemoteRepository();
        
        workSpace.crearWorkSpace(ws);   
        index.crearIndex(ind);
        localRepository.crearLocalRepository(lr);
        remoteRepository.crearRemoteRepository(rr);
        
        Zonas zonas = new Zonas();
        zonas.crearZonas(nombre, autor, workSpace, index, localRepository, remoteRepository);
        
        return zonas;
        
    }
    
    
    public static void main(String[] args) {
        Zonas zonas = new Zonas();
        zonas = gitInit("Primer Repositorio", "Simon Montenegro");
        Archivo arch = new Archivo();
        arch.crearArchivo("Simon.txt", "contenidooooo");
        zonas.workSpace.archivos.add(arch);
        System.out.println(zonas.workSpace.archivos.get(0).contenido);
    }

    
}


 