/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.tienda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import mundo.Producto;

/**
 *
 * @author marit
 */
public class Tienda {
    
private ArrayList<Producto> misProductos;
    private Scanner lector;
    
    public Tienda() {
        misProductos = new ArrayList<>();
        lector = new Scanner(System.in);
    }
    public void mostrarMenu() {
        boolean activo = true;
        do{
            
            System.out.println("-----Menu de opciones--------------");
            System.out.println("-----1.Agregar producto------------");
            System.out.println("-----2.Mostrar inventario----------");
            System.out.println("-----3.Organizar productos---------");
            System.out.println("-----4.Eliminar productos----------");
            System.out.println("-----5.Terminar programa-----------");
            System.out.println("-----Seleccione una opcion---------");
            System.out.println("-----------------------------------"); 
            int opcion = lector.nextInt();
            switch(opcion){
                case 1:
                    agregarProducto();
                    
                    case 2:
                    mostrarProductos();
                    break;
                    case 3:
                        organizarProductos();
                    break;
                    case 4:
                        System.out.println("Ingrese el id del producto a eliminar:");
                        int eliminar = lector.nextInt();
                        eliminarProducto(eliminar);          
                    break;
                    case 5:
                    activo = false;
                    System.out.println("Programa terminado");
                    break;
                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }
        } while (activo);
    }

    public void agregarProducto() {
System.out.println("Ingrese el id del producto");
        int idProducto = lector.nextInt();
        lector.nextLine();
        System.out.println("Ingrese el nombre del producto");
        String nombre = lector.nextLine();
        System.out.println("Ingrese el precio del producto");
        double precio = lector.nextDouble();
        System.out.println("Ingrese la cantidad del producto");
        int cantidad = lector.nextInt();
        Producto nuevoProducto = new Producto(idProducto, nombre, precio, cantidad);
        misProductos.add(nuevoProducto);
        System.out.println("Producto agregado satisfactoriamente");    
    }

    public void mostrarProductos() {
        System.out.println("========= Productos registrados ===========");
        for (Producto t : misProductos) {
            System.out.println("Id del producto:" + t.getidProducto());
            System.out.println("Nombre:" + t.getnombre());
            System.out.println("Precio:" + t.getprecio());
            System.out.println("Cantidad" + t.getcantidad());
            System.out.println("------------------------------------------------");
        }
    }
    
    public void organizarProductos(){
    for (int i = 0; i < misProductos.size() - 1; i++) {
        for (int j = i + 1; j < misProductos.size(); j++) {
            Producto pr1 = misProductos.get(i);
            Producto pr2 = misProductos.get(j);
            if (pr1.getcantidad() > pr2.getcantidad()) {
                misProductos.set(i, pr2);
                misProductos.set(j, pr1);
            }
        }
    }
        mostrarProductos();
    }
    public void eliminarProducto(int idProducto) {
    Iterator<Producto> it = misProductos.iterator();
    while (it.hasNext()) {
        Producto p = it.next();
        if (p.getidProducto() == idProducto) {
            it.remove(); 
            System.out.println("Producto con id " + idProducto + " ha sido eliminado");
        }
    }
    }
        public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.mostrarMenu();
    }
}

            
 