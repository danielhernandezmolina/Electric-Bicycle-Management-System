package proyectoBicicletas;

import java.util.Scanner;


public class Principal {
	
	static Scanner entrada = new Scanner (System.in); // Desde aqui los 2 metodos pueden verlo

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BicicletaElectrica bicicleta1 = new BicicletaElectrica();
		BicicletaElectrica bicicleta2 = new BicicletaElectrica();
		
		Propietario propietario1 = new Propietario ("Daniel Hernandez", "45897874V", 622856265); // Creo un objeto nuevo
		
		
		
		 bicicleta1.asignarPropietario(propietario1); // Asigno el propietario1 a la bicicleta 1 utilizando el constructor parametrizado que implemente en la clase Propietario
		 
		 System.out.println("\nTotal de bicicletas: " + BicicletaElectrica.getTotalBicicletas() ); //Muestro el número total de bicicletas en este caso 2.
		 
		 int biciElegida = 0; // Inicializo por fuera variable biciElegida para poder utilizarla siempre que quiera para llamar al metodo seleccionarBicicleta();
		 
		 //Menu interactivo 
		 int opcion = 0;
		 do {
			 
			 System.out.println(  "\n--MENU GESTION BICICLETAS ELECTRICAS--\n");
			 System.out.println("1. ASIGNAR PROPIETARIO");
			 System.out.println("2. RETIRAR PROPIETARIO");
			 System.out.println("3. REALIZAR RECORRIDO");
			 System.out.println("4. CARGAR BATERIA");
			 System.out.println("5. MOSTRAR INFORMACION");
			 System.out.println("6. SALIR\n");
			 System.out.println("Seleccionar una opción:");
			 
	            try {
	                opcion = entrada.nextInt();
	            } catch (Exception e) {
	                System.out.println("Por favor, introduce un número válido.\n");
	                entrada.next(); // Limpiar el buffer del scanner para que no se encasquille
	                continue;
	            }	 
	            
	            switch (opcion) {    
	            
	            case 1:
	            	 biciElegida = seleccionarBicicleta(); //Guardo la variable de que bicicleta eligio el usuario
	            	
	            	entrada.nextLine(); // Limpiar el buffer
	            	
		            System.out.println("Introduce nombre del propietario:");
		            String nombre = entrada.nextLine();
		            
		            System.out.println("Introduce DNI del propietario:");
		            String dni = entrada.next();
		            
		           boolean comprobacionDni = propietario1.validarDni(dni); //Utilizo el metodo validar DNI para ver si me da verdadero o falso y lo almaceno en una variable local
		           
		           if(comprobacionDni == true){ //Si da true pasa sino "numero de DNI no valido"
		        	  
		            System.out.println("Introduce telefono del propietario:");
		            int telefono = entrada.nextInt();
		            
		            Propietario propietario2 = new Propietario (nombre, dni, telefono); // Inicializo aqui el objeto (Propietario 2) para guardar las variables que pedí por teclado 
		              	
	            if (biciElegida == 1){bicicleta1.asignarPropietario(propietario2);} // Si es 1 asigno datos a PROPIETARIO 1
	            
	            else {bicicleta2.asignarPropietario(propietario2);} // Sino es 1 asigno datos a PROPIETARIO 2
	            
		           }else {System.out.println("Numero de DNI no valido");}
	            break; // MUY IMPORTANTE PARA QUE NO ME DE LA SIGUIENTE OPCION SIN PREGUNTAR PRIMERO
	            
	            case 2:
	            	biciElegida = seleccionarBicicleta(); //Guardo la variable de que bicicleta eligio el usuario
	            	
	            bicicleta1.retirarPropietario();
	            
	            break;
	            
	            case 3:
	            	biciElegida = seleccionarBicicleta(); //Guardo la variable de que bicicleta eligio el usuario
	            	
	            bicicleta1.realizarRecorrido();
	            
	            break;
	            
	            case 4:
	            	biciElegida = seleccionarBicicleta(); //Guardo la variable de que bicicleta eligio el usuario
	            bicicleta1.cargarBateria();
	            
	            break;
	            
	            case 5: 
                    System.out.println("--- Información detallada ---");
                    System.out.println(bicicleta1.toString());
                    System.out.println("-----------------");
                    System.out.println(bicicleta2.toString());
                    System.out.println("Total de bicicletas en sistema: " + BicicletaElectrica.getTotalBicicletas());
                    break;
                    
	            case 6: 
	            	
	            	System.out.println("¡¡Muchas gracias por su visita feliz navidad y hasta la próxima!!");
	            	break;
	            }
			  
		 }while(opcion != 6);
		 
		 
		 
	}
	// Metodo auxiliar para no preguntar todo el tiempo que bicicleta quiere
	private static int seleccionarBicicleta() {
		
		int opcion=0;
		do {
		System.out.println("Selecciona la bicicleta 1 o 2");
        try {
            opcion = entrada.nextInt();
           
        } catch (Exception e) {
        	 System.out.println("Por favor, introduce un número válido.\n");}

		
		}while(opcion != 1 && opcion!= 2); // REPETIR MIENTRAS LA OPCION SEA DISTINTA A 1 Y TAMBIEN DISTINTA A 2
		
		return opcion; // Devuelve el valor prometido en la cabecera del método
	}

}
