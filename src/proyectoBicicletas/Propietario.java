package proyectoBicicletas;

public class Propietario {
	
	private String nombre;
	private String dni;
	private int telefono; 
	
	
public Propietario () { //Constructor vacio con valores predeterminados
	
	this.nombre = "Daniel Hernandez";
	this.dni = "00000000V";
	this.telefono = 000000000;
}

public Propietario (String nombre, String dni , int telefono) { //Constructor parametrizado con valores personalizables
	
    this.nombre = nombre;
    this.dni = dni;
    this.telefono = telefono;
}


// Getters funcionan como ventana para leer informacion de otras clases pero sin poder modificarla

public String getNombre() {return nombre;}
public String getDni() {return dni;}
public int getTelefono() {return telefono;}

public static boolean validarDni(String dni) {
	
	return dni.matches("\\d{8}[A-Za-z]");
}


@Override //Etiqueta para confirmar que sustituyo el comportamiento de Java por el mio propio

public String toString() {
    return "Propietario: " + nombre + " DNI: " + dni + " Telefono: " + telefono;
}


}
