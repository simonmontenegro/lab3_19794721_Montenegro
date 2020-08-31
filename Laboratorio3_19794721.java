package laboratorio3_19794721;

import java.util.ArrayList;

public class Laboratorio3_19794721 {

    public static void main(String[] args) {
        Zonas zonas = new Zonas();
        zonas.gitInit("Primer Repositorio", "Simon Montenegro");
        System.out.println(zonas.autorRepositorio);
        zonas.crearNuevoArchivo("Archivo 1", "Este es el contenido\ndel Archivo 1.", zonas);
        System.out.println(zonas.workSpace.archivos.get(0).nombre);
        System.out.println(zonas.workSpace.archivos.get(0).fecha);
        System.out.println(zonas.workSpace.archivos.get(0).contenido);
    }

    
}


 