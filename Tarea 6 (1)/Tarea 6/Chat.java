import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;
import java.lang.String;
import java.util.Objects;

/* 
Nombre: Clase Chat
Objetivo: Poder almacenar las conversaciones junto con los contactos
*/
public class Chat {

    private LinkedList <Contacto> losContactos = new LinkedList<Contacto>();
    private LinkedList <Conversacion> lasConversaciones = new LinkedList<Conversacion>();


  /* 
Nombre: Retorna conversación
Objetivo: Poder obtener todos los mensajes que a intercambiado una persona con otra
Entrada: Recibe un numero de conversación en formato String
Salida: Un la LinkedList the todos los mensaje
*/
    public static Conversacion retornaConversa (String numero_tel)  {
        Conversacion otraConversacion = new Conversacion();
        try {
            Contacto otroContacto = new Contacto();

            //File theFile = new File("C:\\Users\\aulasingenieria.UJAVERIANA\\Desktop\\Proyecto\\ExpoArqui2\\Parcia_Avanzadal_2_2\\src\\Conversaciones.txt");
            File theFile = new File("Conversaciones.txt");
            //File theFile = new File("C:\\Users\\recursos\\IdeaProjects\\Parcial1\\src\\Conversaciones.txt");




            BufferedReader buffi = new BufferedReader(new FileReader(theFile));

            String linea, telefono;
            String [] comodin;
            Mensaje elMensaje = new Mensaje();
             // Los int no requieren espacio de memoria a menoa de que quiera un array
            int iteracion = 0;
          
            

            while((linea = buffi.readLine())  != null ) {
                //System.out.println(iteracion);
                //System.out.println("Aqui entra pa");
                comodin = linea.split(",");
                //System.out.println(linea);
                //System.out.println(String.valueOf(comodin[1]));
                telefono = linea.substring(0);
                //System.out.println("Este es el número rey: "+numero_tel);
                if((comodin[0].equals(numero_tel)) == true) {
                   // System.out.println("HOLA MI REY");
                    elMensaje.setFecha(comodin[2]);
                    elMensaje.setHora(comodin[3]);
                    elMensaje.setTexto(comodin[5]);
                    if((comodin[4].equals(" R"))==true) {
                      
                      elMensaje.setRe_se(true);
                    }
                    else if((comodin[4].equals(" E"))==true) {
                        
                      elMensaje.setRe_se(false);
                        

                    }
                    //System.out.println("Yujo"+elMensaje.getFecha());
                    otroContacto.setNumero(comodin[0]);
                    otroContacto.setNombre(comodin[1]);
                    //System.out.println(comodin[4]);
                    //System.out.println("K pasa"+elMensaje.getTexto());
                    //System.out.println(elMensaje.getRe_Se());
                    otraConversacion.setElContacto(otroContacto);
                    //System.out.println("El número es: "+ otraConversacion.getElContacto().getNumero());
                  
                    if(elMensaje.getRe_Se() == true) {
                        otraConversacion.setMensajito(elMensaje);
                       
                        //System.out.println("HOLAAAAAA");
                    }

                    else if(elMensaje.getRe_Se() == false) {
                        otraConversacion.setMensajito(elMensaje);
                        //System.out.println("Quiubo, que más pues mor");
                       
                    }

                    //System.out.println("Panita, k mas");
                    System.out.println("El re_se = " + otraConversacion.getMensajito(iteracion).getRe_Se());
                    System.out.println("El número es: " + otraConversacion.getElContacto().getNumero());
                    System.out.println("El nombre es: " + otraConversacion.getElContacto().getNombre());
                    //System.out.println("AAAAA"+otraConversacion.getMensajito(iteracion).getRe_Se());
 
                        
                    //System.out.println("Bailemos código, muéstrame tus pasos");
                    System.out.println("La fecha es: " + otraConversacion.getMensajito(iteracion).getFecha());
                    System.out.println("La hora es: " + otraConversacion.getMensajito(iteracion).getHora());
                    System.out.println("El texto es: " + otraConversacion.getMensajito(iteracion).getTexto());
                    //System.out.println("No es la iteracion");
                    iteracion++;
                    
                  
                    
                    


                }
              else {
                System.out.println("");
              }
              
                
                

            }


            buffi.close();

        }


        catch (Exception e) {
            System.out.println("ERROR");
        }

        return otraConversacion;



    }




}
