
package umariana.exposicioncanina;
/**
 *
 * @author MarioCR7
 */
public class Perro {

private String nombre;
private String raza;
private int edad;
private int puntos;
private String foto;

    public Perro() {
    }

    public Perro(String nombre, String raza, int edad, int puntos, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.puntos = puntos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getFoto() {
        return foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
