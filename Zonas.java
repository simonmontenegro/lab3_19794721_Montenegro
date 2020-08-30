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
    
    //Metodos
    public String getNombreRepositorio() {
        return nombreRepositorio;
    }

    public void setNombreRepositorio(String nombreRepositorio) {
        this.nombreRepositorio = nombreRepositorio;
    }

    public String getAutor() {
        return autorRepositorio;
    }

    public void setAutor(String autor) {
        this.autorRepositorio = autorRepositorio;
    }

    public String getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(String fechaCreación) {
        this.fechaCreación = fechaCreación;
    }
    
    public WorkSpace getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public LocalRepository getLocalRepository() {
        return localRepository;
    }

    public void setLocalRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public RemoteRepository getRemoteRepository() {
        return remoteRepository;
    }

    public void setRemoteRepository(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
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
}
