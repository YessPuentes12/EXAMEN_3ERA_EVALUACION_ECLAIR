/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROBLEMA2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dell
 */
public class Inventario {
    private Producto[] arrProducto=new Producto[10];
//    private String[]arrPersonas=new String[10];

    
    private int elementosExistentes=0;

    //Producto producto
    public void addProduct(Producto producto){
//        System.out.println(arrPersonas[0]);


        try {
                arrProducto[elementosExistentes] = producto;
                System.out.println("Se añadio el elemento "+producto.getNombre()+" - id: "+producto.getId());
                elementosExistentes++;
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El inventario esta lleno, capacidad maxima 10");
        }
    }
    
    public void removeProduct(int productId){
        int tmp=0;

            if (productId >= 0 && productId < arrProducto.length) {
            for (int i = productId; i < arrProducto.length - 1; i++) {
                arrProducto[i] = arrProducto[i + 1];
            }
            arrProducto[arrProducto.length - 1] = null; 
            System.out.println("Elemento eliminado inventario");
            elementosExistentes--;
        }else{
                System.out.println("No se encuentra ese elemento");
            }
        
    }
    
    
    public Producto searchProduct(int productId){
        try {
            boolean seEncontro = false;
            Producto productoEncontrado = null;
            
            for (int i = 0; i < 10; i++) {
                if (arrProducto[i].getId() == productId) {
//                seEncontro=true;
//                productoEncontrado=arrPersonas[i];
                    return arrProducto[i];
                }
            }
//        if(seEncontro){
//            return productoEncontrado;
//        }
            
            return null;
        } catch (NullPointerException e) {
            System.out.println("No se encontro el producto");
            return null;
        }
    }
    
    
    public void displayInventory(){
        System.out.println("Mostrando elementos");
        if(elementosExistentes!=0){
            for (int i = 0; i < elementosExistentes; i++) {
            System.out.println("-------- Elemento: "+i+" --------");
            
            System.out.println("Nombre: "+arrProducto[i].getNombre());
            System.out.println("Precio: "+arrProducto[i].getPrecio());
            System.out.println("Cantidad: "+arrProducto[i].getCantidad());
            System.out.println("Id: "+arrProducto[i].getId());
        }
        }else{
            System.out.println("No hay elementos que mostrar aun");
        }
    }
    
    
    
    public void saveToFile(String filename) throws FileNotFoundException, IOException{
        //abrir archivo
        //guarda en binario??
        FileOutputStream abrirArc=new FileOutputStream("C:\\inventario\\"+filename);
        ObjectOutputStream outputStream=new ObjectOutputStream(abrirArc);
        
            outputStream.writeObject(arrProducto);

        
        System.out.println("Se ha guardado el inventario");
        
        outputStream.close();
    }   

    public void loadFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("C:\\inventario\\"+filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            Producto[] arrayProductos = (Producto[]) objectInputStream.readObject();
            

                            
            System.out.println("El inventario se ha cargado");
            
            for (Producto producto : arrayProductos) {
//                System.out.println(objeto.getNombre());
                try {
                    addProduct(new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCantidad()));
            
                } catch (NullPointerException e) {
                    //el error se da porque al cargar todos los objetos del array guardado, ya no encuentra mas y ahi se detiene
                    //asi que al terminar da el error, asi que no pasa nada y por eso el try esta vacio
                    //lo puse para que no imprima el error
                }
                }
            
            objectInputStream.close();
            fileInputStream.close();
            
    }
    
    
}
