package proyectoBicicletas;

import java.util.Scanner;


public class BicicletaElectrica {
	
	private static int contadorBicicletas = 0;
	private int id;
	private String marca;
	private String modelo;
	private double autonomiaMaxima;
	private double bateria;
	private double kmRecorridos;
	private Propietario Propietario;
	Scanner entrada = new Scanner (System.in);
	
	
public BicicletaElectrica(){
	
	this.id = contadorBicicletas++;
	this.marca = "Generica";  // Default value
	this.modelo = "Estandar"; // Default value
	this.autonomiaMaxima = 50.0;
	this.bateria = 100.0;
	this.Propietario = null;
	
}

public BicicletaElectrica(String marca , String modelo , double autonomiaMaxima){
	
	this.id = contadorBicicletas++;
	this.marca = marca;
	this.modelo = modelo;
	this.autonomiaMaxima = autonomiaMaxima;
	this.bateria = 100.0;
	this.Propietario = null;
}

public void realizarRecorrido(){ // Empty method because we request data through the Scanner
	
	boolean consumoValido = false;
	double km = 0; // Declared outside to use it throughout the method.

	
	do{
		
	try { 
	
	System.out.print("ENTER THE DISTANCE TO TRAVEL (KM): ");
	km = entrada.nextInt();
	
	
	
	double consumo = (km / autonomiaMaxima) * 100;
	
	if (consumo > bateria){
		System.out.println("ERROR NOT ENOUGH BATTERY TRY AGAIN");	}
	else { 
		
	consumoValido = true; // Breaks the loop if consumption is less than battery.
		
	this.bateria = this.bateria - consumo; // I update the BATTERY and KM data
    this.kmRecorridos = this.kmRecorridos + km;
    
    System.out.println("Journey completed successfully.");
    System.out.println("Remaining battery: " + this.bateria + "%");
    System.out.println("Total bike kilometers: " + this.kmRecorridos);
	
	}
	} catch (Exception e) {
        System.out.println("Error: You must enter a valid number.");
        entrada.next(); // Clear the scanner buffer so it doesn't get stuck
        
	} 
	}while (!consumoValido);
	}

	


public void cargarBateria(){
	
	boolean cargaValida = false;
	double cantidadCarga = 0; // Temporary variable for the INPUT
	
	do {
	
		try {
	System.out.print("ENTER THE CHARGE PERCENTAGE TO ADD (0-100): ");
	cantidadCarga = entrada.nextDouble();

	if (cantidadCarga > 0 && (this.bateria + cantidadCarga) <= 100) { cargaValida = true; // If the charged amount is greater
	// than 0 and the sum of the current battery and the charge amount is not greater than 100 then TRUE and exits the loop.
	
	this.bateria = this.bateria + cantidadCarga;
	
	// Performs the addition and returns the current percentage on screen
    System.out.println("Charge completed successfully.");
    System.out.println("Current battery: " + this.bateria + "%");
	
	}
	
	// Error message indicating that the number exceeds the maximum
	else {
		System.out.println("The bike's current battery is " + this.bateria);
		System.out.println("Available space: " + (100 - this.bateria) + "%");
		System.out.println("ERROR: The amount is invalid or exceeds 100% capacity.");
        }
	
	// In case they enter letters
	}catch (Exception e) {
        System.out.println("Error: You must enter a valid number.");
        entrada.next(); // Clear the scanner buffer so it doesn't get stuck
}
		
	}while (!cargaValida);
	
}


public void asignarPropietario(Propietario p) { // I use the Propietario class where I have the data I need DNI, Name... 
    if (this.Propietario == null) {
        this.Propietario = p;
        System.out.println("Owner assigned successfully.");
    } else {
        System.out.println("The bike already has an owner. Remove them first.");
    }
}
	

public void retirarPropietario() { // Same logic as assigning but if there is no owner I jump straight to the else if owner = null
    if (this.Propietario != null) {
        this.Propietario = null;
        System.out.println("Owner removed successfully.");
    } else {
        System.out.println("The bike has no assigned owner.");
    }
}

public void comprobarBateria(){
	
	try {
	
	if(bateria > 50) {System.out.println("Sufficient battery. The current charge percentage is " + bateria + "%");}
	
    else if (bateria > 20 && bateria < 50) {System.out.println("Moderate battery. The current charge percentage is " + bateria + "%");}
	
    else if (bateria < 20){System.out.println("Low battery. The current charge percentage is " + bateria + "%");}
	
	}catch (Exception e) {
        System.out.println("Error: You must enter a valid number.");
        entrada.next(); }
}

public static int getTotalBicicletas(){ // Static method to count bicycles
	
	return(contadorBicicletas); // Only returns the value, without modifying it.
}

@Override // Tag to confirm that I override Java's behavior with my own

public String toString() {  // Returns the bicycle's information
    return " \nBrand: " + marca + " \nModel: " + modelo + " \nBattery:  "+ bateria + " \nAutonomy: " + autonomiaMaxima +"\n" + Propietario ;
}


}



