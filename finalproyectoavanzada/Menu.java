import java.util.Scanner;

class Menu {

  Clinica enfermeras2 = new Clinica();
  
	static Scanner scanner = new Scanner(System.in);//Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario  
  static int codigo = 11112020;
  static int op1 = -1;
  static int op2 = -1;
	//static int  //Variables
/* 
Nombre: principal
Entrada: ninguna
Salida: ninguna
Objetivo: muestra en pantalla el primer menu para que el usuario segun su id entre como paciente o como administrador
*/
  
	public void principal() {
    enfermeras2.cargar_medicos();
					
		//Mientras la opción elegida sea diferente de 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("************************\nElige opción:\n1.- Administrador" +
						"\n2.- Usuario\n" +
						"0.- Salir\n************************");
				//Recoger una variable por consola
				select = Integer.parseInt(scanner.nextLine()); 
		
				//Switch case en Java
				switch(select){
				case 1: 
					System.out.println("-------------Menu de Administrador------------");
            ma();
					break;
				case 2: 
					System.out.println("-------------- Menu de Usuarios----------");
            mu();
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
					
				System.out.println("\n"); 
					
			}catch(Exception e){
				System.out.println("Uoops! Error!");
			}
		}
	}  
  /* 
Nombre: menu administrador
Entrada: ninguna
Salida: ninguna
Objetivo: pide el id para los administradores y luego muestra todas las opciones que pueden ejecutar administradores
*/
  public void ma(){

    enfermeras2.cargar_medicos();
    Scanner ms= new Scanner(System.in);
    System.out.println("digite su codigo");
    codigo = ms.nextInt();
    ms.nextLine();
    while(codigo == 11112020){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("************************\nElige opción:\n1.- agregar medico" +
						"\n2.- eliminar-medico\n" +
						"0.- Salir\n************************");
				//Recoger una variable por consola
				op1 = Integer.parseInt(scanner.nextLine()); 
		
				//Switch case en Java
				switch(op1){
				case 1: 
            System.out.println("-------------agregar médico------------");
            enfermeras2.crear_medico();
            break;
				case 2: 
            System.out.println("-------------- eliminar medico----------");
            enfermeras2.eliminar_medico();
            break;
				case 0: 
					System.out.println("Adios!");
            codigo = -1;
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
					
				System.out.println("\n"); 
					
			}catch(Exception e){
				System.out.println("Uoops! Error!");
			}
		}
  }

  /* 
Nombre: menu usuario
Entrada: ninguna
Salida: ninguna
Objetivo: si el id es diferente al de los administradores, muestra todas las opciones que pueden ejecutar los usuarios pacientes
*/
  public void mu(){
    Scanner mx = new Scanner(System.in);
    System.out.println("digite su codigo");
    codigo = mx.nextInt();
    mx.nextLine();
    while(codigo != 11112020){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("************************\nElige opción:\n1.- agendar cita" +
						"\n2.- atender cita\n" +
						"0.- Salir\n************************");
				//Recoger una variable por consola
				op2 = Integer.parseInt(scanner.nextLine()); 
		
				//Switch case en Java
				switch(op2){
				case 1: 
            String especial, hora, fecha;
            Scanner especialidad = new Scanner(System.in);
            System.out.println("-------------agendar cita------------");
            System.out.println("Ingrese la especialidad del Medico que quiere que lo atienda");
            especial = especialidad.nextLine();
            System.out.println("Ingrese la la fecha de atencion (En formato entero del dia)");
            fecha = especialidad.nextLine();
            System.out.println("Ingrese la hora de atencion (en formato double)");
            hora = especialidad.nextLine();
            enfermeras2.agendar_cita(especial,Integer.parseInt(fecha), hora);
            break;
				case 2: 
					System.out.println("------------atender cita------------");
            enfermeras2.asistir_cita();
					break;
				case 0: 
					System.out.println("Adios!");
            codigo = 11112020;
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
					
				System.out.println("\n"); 
					
			}catch(Exception e){
				System.out.println("Uoops! Error!");
			}
		}
    
  }
}
