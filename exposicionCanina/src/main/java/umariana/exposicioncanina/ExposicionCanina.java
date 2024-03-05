package umariana.exposicioncanina;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author MarioCR7 y anthony
 */
public class ExposicionCanina {
     
         ArrayList<Perro> misPerros = new ArrayList<>();
         Scanner lector = new Scanner (System.in);
         public static void main(String[] args) {
 
             ExposicionCanina expo = new ExposicionCanina();
                 expo.mostrarMenu();
     }
         
         
public void mostrarMenu(){
    boolean activo = true;
    do{
        System.out.println("===Exposicion Canina===");
        System.out.println("1. Agregra perro");
         System.out.println("2.Lista de perros");
         System.out.println("3.Informacion de un perro");
         System.out.println("4.Localizar perro ");
          System.out.println("5. perro ganador mayor puntaje");
          System.out.println("6. perro con menos puntaje");
          System.out.println("7. perro con mayor edad");
          System.out.println("8.Finalizar");
     
          int opcion = lector .nextInt();
          
                  switch(opcion ){
                      case 1:
                          try{
                              agregarPerro();
                          } catch (NombreDuplicadoException e) {
                              System.out.println(e.getMessage());
                          }
                          break;
                      case 2:
                          menuListar();
                       
                          break;
                      case 3:
                          buscarInformacionPerro() ;
                          
                          break;
                      case 4 :
                          localizarPerro();
                          break;
                      case 5:
                          buscarPerroMayorPuntaje() ;
                            break;
                       case 6:
                           buscarPerromenorPuntaje();
                                 
                            break;
                             case 7:
                                 buscarPerroMasViejo();
                                 
                            break;

                      case 8:
                       activo = false;
                    System.out.println("programa finalizado");
                    break;
                default:
                    System.out.println("opcion no valida");

            }
    }while(activo);
}
public void agregarPerro() throws NombreDuplicadoException{
    
    
    System.out.println("Ingrese nombre perro");
    lector .nextLine();
    String nombre = lector .nextLine();
    if(!misPerros.isEmpty()){
    for(Perro p : misPerros){
        if(p.getNombre().equalsIgnoreCase(nombre)){
            throw new NombreDuplicadoException();
        } 
    }    
    }
    System.out.println("Ingrese la raza del perro");
   
    String raza = lector .nextLine();  
    
    System.out.println("Ingrese la edad del perro ");
    int edad = lector .nextInt();
    
    System.out.println("Ingrese los puntos del perro");
    int puntos = lector .nextInt();
    
    System.out.println("Ingrese la foto del perro");
    String foto = lector .next();
    System.out.println("======================");
    
     Perro nuevoPerro = new Perro(nombre,raza,edad,puntos,foto);
     misPerros.add(nuevoPerro);
      System.out.println("Perro agregado con exito  ");
    }
 
    public void mostrarListaDePerros(){
             for (Perro p : misPerros){
             imprimirInformacionPerro(p);
         }
    }
    public void imprimirInformacionPerro(Perro p) {
        System.out.println("Raza: " + p.getRaza());
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Edad: " + p.getEdad());
        System.out.println("Puntos: " + p.getPuntos());
        System.out.println("Foto: " + p.getFoto());
    }
    public void listarPorPuntaje(){
                       for (int i = 0; i <misPerros.size()  - 1 ;i++){
             for(int j = i ; j < misPerros.size(); j++){
                 
                 Perro p1 = misPerros.get(i);
                  Perro p2 = misPerros.get(j);
                 if(p1.getPuntos()< p2.getPuntos()) {
                     misPerros.set(i, p2);
                     misPerros.set(j, p1);
                     
                 }
             }
         }
         
             System.out.println("Organizado Por puntaje de mayor puntaje a menor");
           for (Perro p : misPerros){
            imprimirInformacionPerro(p);
     }
    }
    public void listarPorEdad(){
               for (int i = 0; i <misPerros.size()  - 1 ;i++){
             for(int j = i ; j < misPerros.size(); j++){
                 
                 Perro p1 = misPerros.get(i);
                  Perro p2 = misPerros.get(j);
                 if(p1.getEdad() < p2.getEdad()) {
                     misPerros.set(i, p2);
                     misPerros.set(j, p1);
                     
                 }
             }
         }
         
             System.out.println("Organizado del mas viejo al mas joven");
           for (Perro p : misPerros){
             imprimirInformacionPerro(p);
     }
  
}
    
    public void menuListar(){
            boolean activo = true;
    do{
        System.out.println("===Listar===");
        System.out.println("1. Listar perros por edad");
         System.out.println("2.Listar perros por puntaje");
         System.out.println("3.Lista de perro por razal");
         System.out.println("4.Volver al menu principal");
     
          int opcion = lector .nextInt();
          
                  switch(opcion ){
   
                   case 1:
                           listarPorEdad();
                            break;
                  case 2:
                           listarPorPuntaje();
                                 
                            break;
                  case 3 :
                     mostrarPerrosPorRaza();
                      break;
                  case 4:
                        mostrarMenu();
                     
                      break;
                   
                default:
                    System.out.println("opcion no valida");

            }
    }while(activo);
        
    }

    
  public void buscarInformacionPerro() {
      
      System.out.println("Ingrese el nombre del perro que deeses ver la informacion ");
       lector .nextLine();
      String nombrePerro = lector .nextLine();
    for (Perro p : misPerros) {
        if (p.getNombre().equalsIgnoreCase(nombrePerro)) {
            System.out.println("Informacion del perro:");
            imprimirInformacionPerro(p);
            
        }
    } 
    
}
    public void localizarPerro() {
    boolean perroEncontrado = false;
    System.out.println("Ingrese el perro que deese buscar ");
    lector .nextLine();
    String nombre = lector.nextLine();
    
    for(Perro p: misPerros) {
        if(p.getNombre().equals(nombre)) {
              perroEncontrado = true;
            System.out.println("Perro encontrado ");
            imprimirInformacionPerro(p);
          
         
        }
    }
    
    if(!perroEncontrado) {
        System.out.println("No se encontro el perro con el nombre ingresado");
    }
}
   public void buscarPerroMayorPuntaje() {
    if (!misPerros.isEmpty()) {
    Perro p = misPerros.get(0);
    for (Perro perro : misPerros) {
        if (perro.getPuntos() > p.getPuntos()) {
            p = perro;
        }
    }

    System.out.println("El perro con el puntaje más alto es:");
   imprimirInformacionPerro(p);
}
   }
       public void buscarPerromenorPuntaje(){
        if (!misPerros.isEmpty()) {
        Perro p = misPerros.get(0);
        for (Perro perro : misPerros) {
            if (perro.getPuntos() < p.getPuntos()) {
                p = perro;
        }
    }
        

    System.out.println("perro con el menor puntaje es:");
    imprimirInformacionPerro(p);
}
         
     }
         @SuppressWarnings("empty-statement")
       public void mostrarPerrosPorRaza() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        }
        
        
        Comparator<Perro> comparadorRaza = (Perro p1, Perro p2) -> p1.getRaza().compareTo(p2.getRaza()); 
        Collections.sort(misPerros, comparadorRaza);
        for(Perro p: misPerros) {
            imprimirInformacionPerro(p);
     
}
       }


         public void buscarPerroMasViejo(){
         if (!misPerros.isEmpty()) {
            Perro p = misPerros.get(0);
                for (Perro perro : misPerros) {
                    if (perro.getEdad() > p.getEdad()) {
                        p = perro;
        }
    }

    System.out.println(" perro con mayor edad es:");
    imprimirInformacionPerro(p);
}
         
     }
  
}
         

