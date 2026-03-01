package proyectoBicicletas;

public class Propietario {
	
	private String nombre;
	private String dni;
	private int telefono; 
	
	
public Propietario () { // Empty constructor with default values
	
	this.nombre = "Daniel Hernandez";
	this.dni = "00000000V";
	this.telefono = 000000000;
}

public Propietario (String nombre, String dni , int telefono) { // Parameterized constructor with customizable values
	
    this.nombre = nombre;
    this.dni = dni;
    this.telefono = telefono;
}


// Getters act as a window to read information from other classes but without being able to modify it

public String getNombre() {return nombre;}
public String getDni() {return dni;}
public int getTelefono() {return telefono;}

public static boolean validarDni(String dni) {
	
	return dni.matches("\\d{8}[A-Za-z]");
}


@Override // Tag to confirm that I override Java's behavior with my own

public String toString() {
    return "Owner: " + nombre + " ID (DNI): " + dni + " Phone: " + telefono;
}


}
