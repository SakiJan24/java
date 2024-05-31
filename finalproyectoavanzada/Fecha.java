import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;

public class Fecha {
  
  LinkedList <Cita> agenda = new LinkedList <Cita>();
  private int dia = 0; // esto se salta las fechas con puentes

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void añadir_cita(String hora, boolean disponible) {
    Cita nuevaHora = new Cita(hora, disponible);
    agenda.add(nuevaHora);
  }

  public void añadir_cita(Cita laCita) {
    agenda.add(laCita);
  }

  public int getDia() {
    return dia;
  }

  public void setAgenda( LinkedList <Cita> agenda) {
    this.agenda = agenda;
  }

  public LinkedList <Cita> getAgenda() {
    return agenda;
  }
  


  

  
  
  
}