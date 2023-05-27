/*

 */
package PROBLEMA1;

import java.io.Serializable;


public class Estudiante implements Serializable {
   private String nombre;
   private int NoLista;
   private String grado;  

    public Estudiante(String nombre, int NoLista, String grado) {
        this.nombre = nombre;
        this.NoLista = NoLista;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNoLista() {
        return NoLista;
    }

    public void setNoLista(int NoLista) {
        this.NoLista = NoLista;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
   

    
    
   
}
