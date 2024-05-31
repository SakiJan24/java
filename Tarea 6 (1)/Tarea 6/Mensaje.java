public class Mensaje {
//Clase Mensaje para poder almacenar la fecha, hora, texto y si el mensaje es enviado o recibido
    private String fecha = new String();
    private String hora = new String();
    private String texto = new String();
    private boolean re_Se; // recibido a enviado, verdadero enviado, falso recibido


//Constructor para ingreso de variables en caso de no hacerlo con la función nuevo recibido a nuevo enviado
    Mensaje( String fecha, String hora, String texto, boolean re_se) {

        this.fecha = fecha;
        this.hora = hora;
        this.texto = texto;
        this.re_Se = re_se;

    }

    public Mensaje() {

    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRe_se(boolean nuevo) {
        this.re_Se = nuevo;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTexto() {
        return texto;
    }

    public boolean getRe_Se() {

        return re_Se;
    }
}
