package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zonas {
    //Atributos
    public String nombreRepositorio;
    public String autorRepositorio;
    public String fechaCreación;
    public WorkSpace workSpace;
    public Index index;
    public LocalRepository localRepository;
    public RemoteRepository remoteRepository;
    
    public String obtenerFechaActual() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
    
    //Constructor
    public void crearZonas(String nombre, String autor, WorkSpace workspace, Index index,
        LocalRepository localrepository, RemoteRepository remoterepository){
        this.nombreRepositorio = nombre;
        this.autorRepositorio = autor;
        this.fechaCreación = obtenerFechaActual();
        this.workSpace = workspace;
        this.index = index;
        this.localRepository = localrepository;
        this.remoteRepository = remoterepository;
    }
    
    //Metodos
    public void gitInit(String nombre, String autor){
        WorkSpace ws = new WorkSpace();
        Index ind = new Index();
        LocalRepository lr = new LocalRepository();
        RemoteRepository rr = new RemoteRepository();
        
        this.crearZonas(nombre, autor, ws, ind, lr, rr);
    }
    
    public void crearNuevoArchivo(String nombre, String contenido, Zonas zona){
        Archivo nuevoArchivo = new Archivo();
        nuevoArchivo.crearArchivo(nombre, contenido);
        this.workSpace.archivos.add(nuevoArchivo);
    }
}
