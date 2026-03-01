# Electric-Bicycle-Management-System
This document aims to explain how a Java application has been developed to simulate the management of two electric bicycles. The system allows controlling the status of the bicycles (battery and mileage), managing their owners, and performing common operations through an interactive console menu.

Technical Documentation: Electric Bicycle Management System
1. Introduction
This document aims to explain how a Java application has been developed to simulate the management of two electric bicycles. The system allows controlling the status of the bicycles (battery and mileage), managing their owners, and performing common operations through an interactive console menu.

2. System Architecture
The project is structured within the proyectoBicicletas package and consists of three main classes that interact with each other.

2.1. Owner Class (Propietario)
This class models the personal information of the bicycle users.

Attributes: nombre (name), dni (ID), and telefono (phone) have been defined to store the owners' information.

Constructors:

Empty constructor: Initializes the object with generic values ("Daniel Hernandez", "00000000V") to facilitate quick testing.

Parameterized constructor: Allows instantiating an owner with specific data passed as parameters.

Data Validation (Static Method):
The method specified in the assignment, validarDni(String dni), has been implemented. This method ensures that the DNI complies with the standard format (8 numbers followed by a letter); this is achieved using the pattern dni.matches("\\d{8}[A-Za-z]").

2.2. Electric Bicycle Class (BicicletaElectrica)
It is the core of the code's logic. It manages the physical state of the bicycles and their relationship with the owner.

Unique Identification: A static variable contadorBicicletas is used along with an instance attribute id to generate a unique auto-incremental identifier for each created bicycle.

Energy and Travel Management:

realizarRecorrido(): This method calculates the battery consumption based on the kilometers entered by the user using the formula: double consumo = (km / autonomiaMaxima) * 100;. If the battery is insufficient, the action is prevented and reported via the console; otherwise, the kmRecorridos (kilometers traveled) are updated, and the battery percentage is reduced.

cargarBateria(): Allows recharging the bicycle by strictly validating that the sum of the current charge plus the entered charge does not exceed 100% capacity.

comprobarBateria(): Evaluates the current state and returns a qualitative message ("Sufficient battery", "moderate", or "low") according to the established ranges (greater than 50%, between 20-50%, less than 20%).

Owner Management:
The asignarPropietario and retirarPropietario methods control the association with the Propietario class, ensuring that an owner cannot be assigned to a bicycle that already has one, nor can a non-existent owner be removed.

2.3. Main Class (MAIN)
Contains the main method and is responsible for user interaction.

Initialization: Upon startup, the system instantiates two BicicletaElectrica objects. An owner is assigned to the first bicycle to meet the initial requirements of the assignment.

Flow Control: A do-while loop is used to keep the program running until the user decides to exit.

Error Handling: try-catch blocks are implemented wrapping the data reading (Scanner). This prevents the program from closing abruptly if the user enters incorrect data types (for example, letters instead of numbers).

3. Execution Tests and Validations
The system complies with the validations requested in the assessment:

Counting: The static method getTotalBicicletas() correctly returns the total number of created instances (2 in this case).

DNI Validation: Before creating a new owner in option 1 of the menu, the DNI format is verified. If it is incorrect, the assignment is not allowed.

Battery Limits: The system prevents making trips if the battery is insufficient and blocks charges that exceed 100%.
