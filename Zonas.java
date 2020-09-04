package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
    public void gitInit(){
        WorkSpace ws = new WorkSpace();
        Index ind = new Index();
        LocalRepository lr = new LocalRepository();
        RemoteRepository rr = new RemoteRepository();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre del repositorio:");
        String nombre = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Ingrese autor del repositorio:");
        String autor = input2.nextLine();
        
        this.crearZonas(nombre, autor, ws, ind, lr, rr);
    }
    
    public void crearNuevoArchivo(){
        Archivo nuevoArchivo = new Archivo();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese nombre del archivo:");
        String nombre = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Ingrese contenido del archivo:");
        String contenido = input2.nextLine();
        
        nuevoArchivo.crearArchivo(nombre, contenido);
        this.workSpace.archivos.add(nuevoArchivo);
    }
    
    public void gitAdd(){
        Scanner input = new Scanner(System.in);
        System.out.println("¿Cuantos archivos desea añadir? ('-1' para añadir todos)");
        try{
            int cantidadArchivos = input.nextInt();
            while(cantidadArchivos > this.workSpace.archivos.size()){
                System.out.println("Esta intentando ingresar mas archivos de los que existen, intentelo denuevo.");
                cantidadArchivos = input.nextInt();
            }
            if(cantidadArchivos == -1){
                for (int i = 0; i < this.workSpace.archivos.size(); i++) {
                    this.index.archivos.add(this.workSpace.archivos.get(i));
                }
            }
            
            else{
                while(cantidadArchivos != 0){
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Ingrese nombre de archivo:");
                    String nombreArchivo = input2.nextLine();
                    int flag = 0;
                    for(int i = 0; i < this.workSpace.archivos.size(); i++) {
                        if(nombreArchivo.equals(this.workSpace.archivos.get(i).nombre)){
                            this.index.archivos.add(this.workSpace.archivos.get(i));
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        cantidadArchivos--;
                    }
                    else{
                        System.out.println("El archivo ingresado no existe.");
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error, no se ingresó un caracter valido.");
        }
        
    }
    public void gitCommit(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese mensaje asociado a su commit");
        String mensaje = input.nextLine();
        
        Commit nuevoCommit = new Commit();
        nuevoCommit.crearCommit(this.autorRepositorio, mensaje, this.index.archivos);
        this.localRepository.commits.add(nuevoCommit);
    }
    
    public void gitPush(){
        for (int i = 0; i < this.localRepository.commits.size(); i++) {
            this.remoteRepository.commits.add(this.localRepository.commits.get(i));
        }
    }
    public void gitStatus(){
        System.out.println("Información del repositorio:");
        System.out.println("Nombre del repositorio: " + this.nombreRepositorio);
        System.out.println("Autor del repositorio: " + this.autorRepositorio);
        System.out.println("Cantidad de archivos en el WorkSpace: " + this.workSpace.archivos.size());
        System.out.println("Cantidad de archivos en el Index: " + this.index.archivos.size());
        System.out.println("Cantidad de commits en el LocalRepository: " + this.localRepository.commits.size());
        if(this.remoteRepository.commits.size() == this.localRepository.commits.size()){
            System.out.println("¿RemoteRepository actualizado?: Si");
        }
        else{
            System.out.println("¿RemoteRepository actualizado?: No");
        }
    }
    public void gitLog(){
        if(this.localRepository.commits.size() < 5){
            System.out.println("El localRepository posee " + this.localRepository.commits.size() + " commits:");
            for (int i = 0; i < this.localRepository.commits.size(); i++) {
                System.out.println("\tFecha: " + this.localRepository.commits.get(i).tiempo);
                System.out.println("\tMensaje: " + this.localRepository.commits.get(i).mensaje);
                System.out.print("\tArchivos -> ");
                for (int j = 0; j < this.localRepository.commits.get(i).archivos.size(); j++) {
                    System.out.print(this.localRepository.commits.get(i).archivos.get(j).nombre + "  ");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("El localRepository posee " + this.localRepository.commits.size() + " commits:");
            for (int i = this.localRepository.commits.size() - 5; i < this.localRepository.commits.size(); i++) {
                System.out.println("\tFecha: " + this.localRepository.commits.get(i).tiempo);
                System.out.println("\tMensaje: " + this.localRepository.commits.get(i).mensaje);
                System.out.print("\tArchivos -> ");
                for (int j = 0; j < this.localRepository.commits.get(i).archivos.size(); j++) {
                    System.out.print(this.localRepository.commits.get(i).archivos.get(j).nombre + "  ");
                }
            }
            System.out.println();
        }
    }
}
