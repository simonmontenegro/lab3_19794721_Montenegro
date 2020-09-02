package laboratorio3_19794721;

import java.util.ArrayList;
import java.util.Scanner;

public class Laboratorio3_19794721 {

    public static void main(String[] args) {
        Zonas zonas = new Zonas();
        zonas.gitInit();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.gitAdd();
        for (int i = 0; i < zonas.index.archivos.size(); i++) {
            System.out.println(zonas.index.archivos.get(i).nombre);
        }
    }
    
}


 