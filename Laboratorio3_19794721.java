package laboratorio3_19794721;

import java.util.ArrayList;

public class Laboratorio3_19794721 {
    
    public static void main(String[] args) {
        Archivo arch1 = new Archivo();
        arch1.crearArchivo("Simon Montenegro", "Este es mi primer archivo.");
        
        Archivo arch2 = new Archivo();
        arch2.crearArchivo("Maria Canoles", "Este es mi segundo archivo.");        
        
        ArrayList<Archivo> lista = new ArrayList<Archivo>();
        lista.add(arch1);
        lista.add(arch2);
        
        System.out.println(arch1.fecha);
        
        Commit comm1 = new Commit();
        comm1.crearCommit("Simon", "Mensaje del commit", lista);
        System.out.println(comm1.mensaje);
        
        
    }
    
    
}


 