package proyectoBicicletas;

import java.util.Scanner;


public class Principal {
	
	static Scanner entrada = new Scanner (System.in); // From here both methods can see it

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BicicletaElectrica bicicleta1 = new BicicletaElectrica();
		BicicletaElectrica bicicleta2 = new BicicletaElectrica();
		
		Propietario propietario1 = new Propietario ("Daniel Hernandez", "45897874V", 622856265); // I create a new object
		
		
		
		 bicicleta1.asignarPropietario(propietario1); // I assign owner1 to bicycle 1 using the parameterized constructor I implemented in the Propietario class
		 
		 System.out.println("\nTotal bicycles: " + BicicletaElectrica.getTotalBicicletas() ); // I show the total number of bicycles, in this case 2.
		 
		 int biciElegida = 0; // I initialize the chosen bike variable outside to be able to use it whenever I want to call the seleccionarBicicleta() method;
		 
		 // Interactive Menu 
		 int opcion = 0;
		 do {
			 
			 System.out.println(  "\n--ELECTRIC BICYCLES MANAGEMENT MENU--\n");
			 System.out.println("1. ASSIGN OWNER");
			 System.out.println("2. REMOVE OWNER");
			 System.out.println("3. MAKE A TRIP");
			 System.out.println("4. CHARGE BATTERY");
			 System.out.println("5. SHOW INFORMATION");
			 System.out.println("6. EXIT\n");
			 System.out.println("Select an option:");
			 
            try {
                opcion = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Please, enter a valid number.\n");
                entrada.next(); // Clear the scanner buffer so it doesn't get stuck
                continue;
            }	 
            
            switch (opcion) {    
            
            case 1:
            	 biciElegida = seleccionarBicicleta(); // I save the variable of which bike the user chose
            	
            	entrada.nextLine(); // Clear the buffer
            	
		            System.out.println("Enter the owner's name:");
		            String nombre = entrada.nextLine();
		            
		            System.out.println("Enter the owner's ID (DNI):");
		            String dni = entrada.next();
		            
		           boolean comprobacionDni = propietario1.validarDni(dni); // I use the validate ID method to see if it gives me true or false and store it in a local variable
		           
		           if(comprobacionDni == true){ // If it is true it passes, otherwise "invalid ID number"
		        	  
		            System.out.println("Enter the owner's phone number:");
		            int telefono = entrada.nextInt();
		            
		            Propietario propietario2 = new Propietario (nombre, dni, telefono); // I initialize the object here (Owner 2) to save the variables I requested via keyboard 
		              	
            if (biciElegida == 1){bicicleta1.asignarPropietario(propietario2);} // If it is 1 I assign data to OWNER 1
            
            else {bicicleta2.asignarPropietario(propietario2);} // If it is not 1 I assign data to OWNER 2
            
		           }else {System.out.println("Invalid ID number");}
            break; // VERY IMPORTANT SO IT DOESN'T GIVE ME THE NEXT OPTION WITHOUT ASKING FIRST
            
            case 2:
            	biciElegida = seleccionarBicicleta(); // I save the variable of which bike the user chose
            	
            bicicleta1.retirarPropietario();
            
            break;
            
            case 3:
            	biciElegida = seleccionarBicicleta(); // I save the variable of which bike the user chose
            	
            bicicleta1.realizarRecorrido();
            
            break;
            
            case 4:
            	biciElegida = seleccionarBicicleta(); // I save the variable of which bike the user chose
            bicicleta1.cargarBateria();
            
            break;
            
            case 5: 
                    System.out.println("--- Detailed information ---");
                    System.out.println(bicicleta1.toString());
                    System.out.println("-----------------");
                    System.out.println(bicicleta2.toString());
                    System.out.println("Total bicycles in the system: " + BicicletaElectrica.getTotalBicicletas());
                    break;
                    
            case 6: 
            	
            	System.out.println("Thank you very much for your visit, Merry Christmas and see you next time!!");
            	break;
            }
			  
		 }while(opcion != 6);
		 
		 
		 
	}
	// Auxiliary method to avoid asking which bike they want all the time
	private static int seleccionarBicicleta() {
		
		int opcion=0;
		do {
		System.out.println("Select bicycle 1 or 2");
        try {
            opcion = entrada.nextInt();
           
        } catch (Exception e) {
        	 System.out.println("Please, enter a valid number.\n");}

		
		}while(opcion != 1 && opcion!= 2); // REPEAT AS LONG AS THE OPTION IS DIFFERENT FROM 1 AND ALSO DIFFERENT FROM 2
		
		return opcion; // Returns the value promised in the method header
	}

}
