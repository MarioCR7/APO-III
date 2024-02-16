/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author marit
 */
public class Producto {
    //atributos
    private int idProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    
public Producto(){
}

    public Producto(int idProducto, String nombre, double precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getidProducto() {
        return idProducto;
    }

    public String getnombre() {
        return nombre;
    }

    public double getprecio() {
        return precio;
    }

    public int getcantidad() {
        return cantidad;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setprecio(double precio) {
        this.precio = precio;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

}
