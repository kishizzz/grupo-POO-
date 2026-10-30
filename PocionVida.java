public class PocionVida extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez y Samuel
  public PocionVida(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override 
  public void usaritem(){
    System.out.println("Usaste pocion de "+ nombreitem +", +"+puntos+" puntos de " + nombreitem + " por "+ duracion + "turnos");
  }
}
