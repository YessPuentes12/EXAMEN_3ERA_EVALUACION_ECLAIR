/*

 */
package examen_3era_evaluacion_eclair;

import PROBLEMA1.Estudiante;
import PROBLEMA1.StudentManagementSystem;
import PROBLEMA2.Inventario;
import PROBLEMA2.Producto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class EXAMEN_3ERA_EVALUACION_ECLAIR {


    public static void main(String[] args) {
        
  System.out.println("\n-------------------------------Problema 1-----------------------------------\n"); 
    //Problema 1: Sistema simple de gestión de estudiantes      
        
   StudentManagementSystem sistema = new StudentManagementSystem();
    
     // Agregar estudiantes
        Estudiante estudiante1 = new Estudiante("Rubén Acosta", 1, "Segundo semestre");
        Estudiante estudiante2 = new Estudiante("Julio Jacinto", 19, "Segundo semestre");
        Estudiante estudiante3 = new Estudiante("Yessly Mayorga", 23, "Segundo semestre");
        Estudiante estudiante4 = new Estudiante("Juán Perez", 9, "Cuarto semestre");
    
        sistema.addStudent(estudiante1);
        sistema.addStudent(estudiante2);
        sistema.addStudent(estudiante3);
        sistema.addStudent(estudiante4);
        
        System.out.println("Estudiantes en el sistema.\n");
        sistema.printStudentList();
       
    // Almacenar datos de los estudiantes en un archivo
        String filename = "C:\\Estudiantes\\estudiantes.txt";
        sistema.storeData(filename);
    
    // Borrar datos 
        sistema = new StudentManagementSystem();

   // Cargar datos desde el archivo
        sistema.loadData(filename);
        
 // Recuperar información de un estudiante en específico
        Estudiante estudianteRec = sistema.getStudent(23);
        System.out.println("\nBuscando...");
        if (estudianteRec != null) {
            System.out.println("Estudiante en el sistema.");
            System.out.println("\nInformación del estudiante:");
            System.out.println("Nombre: " + estudianteRec.getNombre());
            System.out.println("Número de lista: " + estudianteRec.getNoLista());
            System.out.println("Grado: " + estudianteRec.getGrado());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
        
        Estudiante estudianteRec2 = sistema.getStudent(8);
        System.out.println("\nBuscando...");
        if (estudianteRec2 != null) {
            System.out.println("Estudiante en el sistema.");
            System.out.println("\nInformación del estudiante:");
            System.out.println("Nombre: " + estudianteRec.getNombre());
            System.out.println("Número de lista: " + estudianteRec.getNoLista());
            System.out.println("Grado: " + estudianteRec.getGrado());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
        
        
         // Borrar los datos de los estudiantes del sistema
         int noListaBuscado = 9;
        sistema = new StudentManagementSystem();

        // Mostrar los datos de los estudiantes después de borrarlos
        Estudiante estudianteBorrado = sistema.getStudent(noListaBuscado);
        if (estudianteBorrado == null) {
            System.out.println("Estudiante con número de lista " + noListaBuscado + " ha sido borrado del sistema.");
        } else {
            System.out.println("No se pudo borrar el estudiante con número de lista " + noListaBuscado);
        }
    
        System.out.println("\nLista actualizada.\n");
        
        
  System.out.println("\n\n-------------------------------Problema 2-----------------------------------\n");      
    //Problema 2: Sistema de gestión de inventario simple para una tienda  

     Inventario inv=new Inventario();
        
        
        inv.displayInventory();
        System.out.println("--------------------------------------------------");
        
        
        inv.addProduct(new Producto(1, "Sandia", 20, 1));
        inv.addProduct(new Producto(2, "Control Ps5", 1500, 2));
        inv.addProduct(new Producto(3, "Burrito de Asado", 22, 4));
        inv.addProduct(new Producto(4, "Galletas", 19, 7));

        
        System.out.println("--------------------------------------------------");
        inv.displayInventory();
        System.out.println("--------------------------------------------------");
    
         
            //al hacer la busqueda si encontro el producto, asi que retorna el objeto, si no lo encuentra retorna null, 
            //asi que si no lo encuentra y lo tratas de imprimir saldran muchos errores, por eso el try en caso de que no se encuentre
        try {
            System.out.println("Nombre: " + inv.searchProduct(3).getNombre());
            System.out.println("Precio: " + inv.searchProduct(3).getPrecio());
            System.out.println("Cantidad: " + inv.searchProduct(3).getCantidad());
            System.out.println("Id: " + inv.searchProduct(3).getId());
        } catch (NullPointerException e) {
            System.out.println("El objeto 3 no existe");
        }
        
        System.out.println("buscar elemento id= 5");
            System.out.println("Nombre: "+inv.searchProduct(5));
        System.out.println("No existe el elemento 5");

       System.out.println("--------------------------------------------------"); 
        inv.addProduct(new Producto(5, "Aguacate", 30, 3));
        
        System.out.println("--------------------------------------------------");
        inv.displayInventory();
        
        System.out.println("--------------------------------------------------");
        
        inv.removeProduct(3);
        
        System.out.println("--------------------------------------------------");
        
        inv.displayInventory();
        
        System.out.println("--------------------------------------------------");
        
        try {
            inv.saveToFile("inventario1.inv");
        } catch (IOException ex) {
            Logger.getLogger(EXAMEN_3ERA_EVALUACION_ECLAIR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                System.out.println("--------------------------------------------------");
//        inv.displayInventory();


        //crear una carpeta "inventario" en la raiz del sistema, algo asi C:\\inventario\\
        try {
            inv.loadFromFile("inventario1.inv");
        } catch (IOException ex) {
//            ex.printStackTrace();
            System.out.println("No se encontro el archivo");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
       System.out.println("--------------------------------------------------");
       inv.displayInventory();

    
    
    
    
    
    
    
    
    
    }
    
    }
    
    

