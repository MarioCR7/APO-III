/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package umariana.taller1;

import java.util.ArrayList;
import java.util.Scanner;
import mundo.Tarea;

/**
 *
 * @author mario
 */
public class Taller1 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Tarea> misTareas = new ArrayList<>();

        boolean activo = true;
        do{
            
            System.out.println("---Menu de opciones---------");
            System.out.println("---1.Agregar tarea----------");
            System.out.println("---2.Mostrar tarea----------");
            System.out.println("---3.Eliminar tarea---------");
            System.out.println("---4.Terminar programa------");
            System.out.println("---Seleccione una opcion----");
            System.out.println("----------------------------");
            
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el id de la tarea");
                    int id=sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Ingrese la descripcion de la tarea");
                    String descripcion = sc.nextLine();
                    
                    System.out.println("Ingrese la prioridad de 1-5");
                    int prioridad = sc.nextInt();
                    //Creacion del objeto y llenar la informacion
                    Tarea nuevaTarea = new Tarea(id,descripcion,prioridad);
                    //Almacenar objeto en la contenedora
                    misTareas.add(nuevaTarea);
                    System.out.println("Tarea agregada correctamente");
                    break;
                case 2:
                    System.out.println("---TAREAS REGISTRADAS---");
                    for(Tarea t: misTareas)
                    {
                        System.out.println("id:"+ t.getId());
                        System.out.println("Descripcion:"+ t.getDescripcion());
                        System.out.println("Prioridad: "+ t.getPrioridad());
                        System.out.println("========================");
                    }
                    
                    break;
                case 3:
                    System.out.println("Ingresa el id de la tarea que deseas eliminar");
                    int eliminar = sc.nextInt();
                    boolean eliminada = false;
                    for (int i = 0; i < misTareas.size(); i++) {
                        if (misTareas.get(i).getId() == eliminar) {
                            misTareas.remove(i);
                            eliminada = true;
                            System.out.println("Tarea eliminada");
                            break;
                        }
                    }
                    if (!eliminada) {
                        System.out.println("Id no existe");
                    break;
                    }
                    
                case 4:
                    
                    activo = false; System.out.println("Programa Terminado");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    
            }
            
        }while(activo);
    }
}
