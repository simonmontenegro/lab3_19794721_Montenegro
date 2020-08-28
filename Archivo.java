package laboratorio3_19794721;

public class Archivo {
    //Atributos
    public String nombre;
    public String fecha;
    public String contenido;
    
    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public void crearArchivo(String nom, String fec, String con){
        nombre = nom;
        fecha = fec;
        contenido = con;
    }
    
}
