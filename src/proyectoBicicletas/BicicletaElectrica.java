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
	this.marca = "Generica";  //Valor por defecto
	this.modelo = "Estandar"; //Valor por defecto
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

public void realizarRecorrido(){ // Método vacio porque pedimos los datos por el Scanner
	
	boolean consumoValido = false;
	double km = 0; // Declaras por fuera para usarla en todo el método.

	
	do{
		
	try { 
	
	System.out.print("INTRODUCE EL RECORRIDO A REALIZAR (KM): ");
	km = entrada.nextInt();
	
	
	
	double consumo = (km / autonomiaMaxima) * 100;
	
	if (consumo > bateria){
		System.out.println("ERROR NO HAY SUFICIENTE BATERIA INTENTALO NUEVAMENTE");	}
	else { 
		
	consumoValido = true; // Rompe el bucle si consumo es menor que bateria.
		
	this.bateria = this.bateria - consumo; //Actualizo los datos de la BATERIA y los KM
    this.kmRecorridos = this.kmRecorridos + km;
    
    System.out.println("Recorrido realizado con éxito.");
    System.out.println("Batería restante: " + this.bateria + "%");
    System.out.println("Kilometros totales de la bici: " + this.kmRecorridos);
	
	}
	} catch (Exception e) {
        System.out.println("Error: Debes introducir un número válido.");
        entrada.next(); // Limpiar el buffer del scanner para que no se encasquille
        
	} 
	}while (!consumoValido);
	}

	


public void cargarBateria(){
	
	boolean cargaValida = false;
	double cantidadCarga = 0; // Variable temporal para el INPUT
	
	do {
	
		try {
	System.out.print("INTRODUCE EL PORCENTAJE DE CARGA A REALIZAR(0-100): ");
	cantidadCarga = entrada.nextDouble();

	if (cantidadCarga > 0 && (this.bateria + cantidadCarga) <= 100) { cargaValida = true; //Si la cantidad cargada es mayor
	// que 0 y la suma de la bateria actual y la cantidad de carga no es superior a 100 entonces TRUE  y sale del bucle.
	
	this.bateria = this.bateria + cantidadCarga;
	
	// Realiza la suma y devuelve el porcentaje actual por pantalla
    System.out.println("Carga realizada con éxito.");
    System.out.println("Batería actual: " + this.bateria + "%");
	
	}
	
	// Mensaje de error indicando que el número supera el máximo
	else {
		System.out.println("La bateria actual de la bicicleta es " + this.bateria);
		System.out.println("Espacio disponible: " + (100 - this.bateria) + "%");
		System.out.println("ERROR: La cantidad no es válida o excede el 100% de capacidad.");
        }
	
	// Por si ponen letras
	}catch (Exception e) {
	        System.out.println("Error: Debes introducir un número válido.");
	        entrada.next(); // Limpiar el buffer del scanner para que no se encasquille
}
		
	}while (!cargaValida);
	
}


public void asignarPropietario(Propietario p) { // Utilizo la clase Propietario donde tengo los datos que necesito  DNI, Nombre... 
    if (this.Propietario == null) {
        this.Propietario = p;
        System.out.println("Propietario asignado correctamente.");
    } else {
        System.out.println("La bicicleta ya tiene propietario. Retíralo primero.");
    }
}
	

public void retirarPropietario() { // Misma logica en para asignar pero si no hay propietario salto directo al else si hay propietario = null
    if (this.Propietario != null) {
        this.Propietario = null;
        System.out.println("Propietario retirado correctamente.");
    } else {
        System.out.println("La bicicleta no tiene propietario asignado.");
    }
}

public void comprobarBateria(){
	
	try {
	
	if(bateria > 50) {System.out.println("Bateria suficiente. El porcentaje de carga actual es " + bateria + "%");}
	
    else if (bateria > 20 && bateria < 50) {System.out.println("Bateria moderada. El porcentaje de carga actual es " + bateria + "%");}
	
    else if (bateria < 20){System.out.println("Bateria baja. El porcentaje de carga actual es " + bateria + "%");}
	
	}catch (Exception e) {
        System.out.println("Error: Debes introducir un número válido.");
        entrada.next(); }
}

public static int getTotalBicicletas(){ // Método estatico para contar bicicletas
	
	return(contadorBicicletas); // Solo devuelve el valor, sin modificarlo.
}

@Override //Etiqueta para confirmar que sustituyo el comportamiento de Java por el mio propio

public String toString() {  // Devuelve la informacion de la bicicleta
    return " \nMarca: " + marca + " \nModelo: " + modelo + " \nBateria:  "+ bateria + " \nAutonomia: " + autonomiaMaxima +"\n" + Propietario ;
}


}



