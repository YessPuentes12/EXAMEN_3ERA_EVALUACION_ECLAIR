/*

 */
package PROBLEMA1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class StudentManagementSystem {
 
  private List<Estudiante> estudiantes;
  private int student =0;

    public StudentManagementSystem() {
        estudiantes = new ArrayList<>();
    }

    public void addStudent(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
   
 public Estudiante getStudent(int rollNumber) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNoLista() == rollNumber) {
                return estudiante;
            }
        }
        return null;
    }   
    
    
 public void storeData(String filename) {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
        outputStream.writeObject(estudiantes);
        System.out.println("Datos guardados en el archivo: " + filename);
   } catch (IOException e) {
        System.out.println("Error al guardar los datos en el archivo: " + filename);
        e.printStackTrace();
      }
  }   
    
 public void loadData(String filename) {
     try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
         estudiantes = (List<Estudiante>) inputStream.readObject();
         System.out.println("Datos cargados desde el archivo: " + filename);
    } catch (IOException | ClassNotFoundException e) {
       System.out.println("Error al cargar los datos desde el archivo: " + filename);
        e.printStackTrace();
        }
    }
   
public void printStudentList() {
    for (Estudiante estudiante : estudiantes) {
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Número de lista: " + estudiante.getNoLista());
        System.out.println("Grado: " + estudiante.getGrado());
        System.out.println("----------");
    }
    
} 
    
    
    
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

