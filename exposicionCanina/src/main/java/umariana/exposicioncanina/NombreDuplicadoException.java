
package umariana.exposicioncanina;

/**
 *
 * @author MarioCR7
 */
public class NombreDuplicadoException extends Exception {
    public NombreDuplicadoException(){
    super("Ya existe un perro con ese nombre, intenta nuevamente");
        
    }
    
}
