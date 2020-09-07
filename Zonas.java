//@author Simon Alonso Montenegro Bastias
//Rut 19.794.721-7
//Ultimo Edit: 06/09/2020
//@version 1.8

package laboratorio3_19794721;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Una clase para representar las zonas de trabajo.
 * Cada Zonas esta determinado un nombreRepositorio, autorRepositorio, fechaCreacion,
 * workSpace, index, localRepository, remoteRepository.
 * @version 1.8
 * @author Simón Montenegro
 */
public class Zonas {
    public String nombreRepositorio;
    public String autorRepositorio;
    public String fechaCreación;
    public WorkSpace workSpace;
    public Index index;
    public LocalRepository localRepository;
    public RemoteRepository remoteRepository;
    
    /** 
      * metodo que obtiene la fecha actual del sistema
      * @return fecha actual del sistema
      */
    public String obtenerFechaActual() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date fechaActual = new Date();
        return df.format(fechaActual);
    }
    
    /** 
      * Constructor de la clase.
      * @param nombre nombre del repositorio.
      * @param autor autor del repositorio.
      * @param workSpace zona workSpace.
      * @param index zona index.
      * @param localrepository zona localRepository.
      * @param remoterepository zona remoteRepository.
      */
    private void crearZonas(String nombre, String autor, WorkSpace workspace, Index index,
        LocalRepository localrepository, RemoteRepository remoterepository){
        this.nombreRepositorio = nombre;
        this.autorRepositorio = autor;
        this.fechaCreación = obtenerFechaActual();
        this.workSpace = workspace;
        this.index = index;
        this.localRepository = localrepository;
        this.remoteRepository = remoterepository;
    }
   
    /** 
      * Metodo de clase que a partir de un nombre y autor de repositorio ingresado
      * por el usuario, se instancia la clase.
      */
    public void gitInit(){
        WorkSpace ws = new WorkSpace();
        Index ind = new Index();
        LocalRepository lr = new LocalRepository();
        RemoteRepository rr = new RemoteRepository();
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************************************");
        System.out.print("Ingrese nombre del repositorio:\t");
        String nombre = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Ingrese autor del repositorio:\t");
        String autor = input2.nextLine();
        
        this.crearZonas(nombre, autor, ws, ind, lr, rr);
    }
    
    /** 
      * Metodo de clase que a partir de un nombre y contenido de un archivo ingresado
      * por el usuario, se instancia un Archivo con dichos parametros y luego
      * se añade al workSpace.
      */
    public void crearNuevoArchivo(){
        Archivo nuevoArchivo = new Archivo();
        
        Scanner input = new Scanner(System.in);
        System.out.println("********************************************************************");
        System.out.print("Ingrese nombre del archivo:\t");
        String nombre = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Ingrese contenido del archivo:\t");
        String contenido = input2.nextLine();
        
        nuevoArchivo.crearArchivo(nombre, contenido);
        this.workSpace.archivos.add(nuevoArchivo);
        System.out.println("********************************************************************");
        System.out.println("******************* Archivo creado correctamente *******************");
    }
    
    /** 
      * Metodo de clase que añade archivos ingresados por el usuario desde la zona
      * workSpace a la zona Index.
      */
    public void gitAdd(){
        if(this.workSpace.archivos.size() > 0){
            Scanner input = new Scanner(System.in);
            try{
                System.out.println("********************************************************************");
                System.out.println("¿Cuantos archivos desea añadir? ('-1' para añadir todos)");
                int cantidadArchivos = input.nextInt();
                while(cantidadArchivos > this.workSpace.archivos.size()){
                    System.out.println("********************************************************************");
                    System.out.println("***** Esta intentando ingresar mas archivos de los que existen.*****");
                    System.out.println("********************************************************************");
                    System.out.println("¿Cuantos archivos desea añadir? ('-1' para añadir todos)");
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
                        System.out.print("Ingrese nombre de archivo:\t");
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
            System.out.println("********************************************************************");
            System.out.println("***************** Add realizado satisfactoriamente *****************");
            }catch(Exception e){
                System.out.println("Error, no se ingresó un caracter valido.");
            }
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("\tNo hay archivos para añadir, intente crear un archivo.");
        }
        
    }
    /** 
      * Metodo de clase que instancia un Commit a partir de los archivos de la
      * zona index y un mensaje ingresado por el usuario, dicho commit lo añade
      * a la zona localRepository, luego vacía la zona index.
      */
    public void gitCommit(){
        if(this.index.archivos.size() > 0){
            Scanner input = new Scanner(System.in);
            System.out.println("********************************************************************");
            System.out.print("Ingrese mensaje asociado a su commit:\t");
            String mensaje = input.nextLine();

            Commit nuevoCommit = new Commit();
            nuevoCommit.crearCommit(this.autorRepositorio, mensaje, this.index.archivos);
            this.localRepository.commits.add(nuevoCommit);
            Index nuevo = new Index();
            this.index = nuevo;
            System.out.println("********************************************************************");
            System.out.println("*************** Commit realizado satisfactoriamente ****************");
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("\tNo hay archivos suficientes para realizar un commit.");
        }
    }
    
    /** 
      * Metodo de clase que copia todos los commits de la zona localRepository
      * a la zona remoteRepository.
      */
    public void gitPush(){
        if(this.localRepository.commits.size() > 0){
            for (int i = 0; i < this.localRepository.commits.size(); i++) {
                this.remoteRepository.commits.add(this.localRepository.commits.get(i));
            }
            System.out.println("********************************************************************");
            System.out.println("***************** Push realizado satisfactoriamente ****************");
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("No hay commits en el repositorio local, intente generar un commit.");
        }
        
    }
    
    /** 
      * Metodo de clase que copia todos los archivos de la zona remoteRepository
      * a la zona workSpace
      */
    public void gitPull(){
        if(this.remoteRepository.commits.size() > 0){
            for (int i = 0; i < this.remoteRepository.commits.size(); i++) {
                for (int j = 0; j < this.remoteRepository.commits.get(i).archivos.size(); j++) {
                    this.workSpace.archivos.add(this.remoteRepository.commits.get(i).archivos.get(j));
                }
            }
            System.out.println("********************************************************************");
            System.out.println("***************** Pull realizado satisfactoriamente ****************");
        }
        else{
            System.out.println("********************************************************************");
            System.out.println("\tNo hay commits en el repositorio remoto.");
        }
        
    }
    
    /** 
      * Metodo de clase que entrega el estado del repositorio, indicando su nombre,
      * autor, cantidad de archivos en la zona workSpace, cantidad de archivos en 
      * la zona index, cantidad de commits en la zona localRepository e indica
      * si el remoteRepository esta actualizado.
      */
    public void gitStatus(){
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        System.out.println("Información del repositorio:");
        System.out.println("\tNombre del repositorio: " + this.nombreRepositorio);
        System.out.println("\tAutor del repositorio: " + this.autorRepositorio);
        System.out.println("\tCantidad de archivos en el WorkSpace: " + this.workSpace.archivos.size());
        System.out.println("\tCantidad de archivos en el Index: " + this.index.archivos.size());
        System.out.println("\tCantidad de commits en el LocalRepository: " + this.localRepository.commits.size());
        if(this.remoteRepository.commits.size() == this.localRepository.commits.size()){
            System.out.println("\t¿RemoteRepository actualizado?: Si");
        }
        else{
            System.out.println("\t¿RemoteRepository actualizado?: No");
        }
        System.out.println("********************************************************************");
    }
    /** 
      * Metodo de clase que entrega los ultimos 5 commits ingresados a la zona
      * localRepository, indicando fecha, mensaje y archivos asociados a cada commit,
      * en caso de no existir al menos 5 commits, muestra todos los existentes.
      */
    public void gitLog(){
        System.out.println("********************************************************************");
        System.out.println("********************************************************************");
        if(this.localRepository.commits.size() < 5){
            if(this.localRepository.commits.size() == 1)System.out.println("El localRepository posee 1 commit:");
            else System.out.println("El localRepository posee " + this.localRepository.commits.size() + " commits:");
            for (int i = 0; i < this.localRepository.commits.size(); i++) {
                System.out.println("\tFecha: " + this.localRepository.commits.get(i).tiempo);
                System.out.println("\tMensaje: " + this.localRepository.commits.get(i).mensaje);
                System.out.print("\tArchivos -> ");
                for (int j = 0; j < this.localRepository.commits.get(i).archivos.size(); j++) {
                    System.out.print(this.localRepository.commits.get(i).archivos.get(j).nombre + "  ");
                }
                System.out.println();
                System.out.println();
            }
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
                System.out.println();
                System.out.println();
            }
        }
        System.out.println("********************************************************************");
    }
}
