package laboratorio3_19794721;

public class Laboratorio3_19794721 {

    public static void main(String[] args) {
        Zonas zonas = new Zonas();
        zonas.gitInit();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.crearNuevoArchivo();
        zonas.gitAdd();
        zonas.gitCommit();
        zonas.gitPush();
        zonas.gitStatus();
        zonas.gitLog();
    }
    
}


 