public class Cita {
  private String hora = new String();
  private boolean disponible = true;

  Cita() {
    
  }
  Cita(String hora, boolean disponible) {
    this.hora = hora;
    this.disponible = disponible;
  }

  public void setCita(String hora, boolean disponible) {
    this.hora = hora;
    this.disponible = disponible;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  public String getHora () {
    return hora;
  }
  public boolean getDisponible () {
    return disponible;
  }

}