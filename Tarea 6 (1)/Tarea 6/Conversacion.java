import java.util.LinkedList;

public class Conversacion {
//Clase conversación para poder alamacenar el contacto con la conversación que corresponde
    private Contacto elContacto = new Contacto();
  //La linked list mensajitos tiene todos los mensajes, tanto recibidos como enviados, sin embargo, el re_Se del mensaje ayuda a diferenciar: si es true es recibido, si es false es enviado 
    private LinkedList<Mensaje> mensajitos = new LinkedList <Mensaje>();


    public void setElContacto(Contacto elContacto) {
        this.elContacto = elContacto;
    }

/* 
Nombre: Nuevo Enviado
Objetivo: POder ingresar todos los atributos de un mensaje enviado sin necesidad de recurrir al constructor por defecto
Entrada: El mensaje nuevo (nuevoFuera)
Salida: No tiene
*/
    public void setMensajito(Mensaje nuevoMensajito) {

        this.mensajitos.add(nuevoMensajito);
       // System.out.println("Entrando mor: " + nuevoMensajito.getFecha());

    }


    public Mensaje getMensajito(int i) {

        return mensajitos.get(i); // retorna el mensaje completo

    }

    public Contacto getElContacto () {

        return this.elContacto;
    }
}
