public class PocionAtaque extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez
  public PocionAtaque(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override
  public void usaritem(Personaje personaje){
    if (getDuracion()>0){
    personaje.aplicarBonoAtaque(getPuntos());
    System.out.println("+"+getPuntos()+"de ataque");
    if (getDuracion() == 0){
      personaje.limpiarBonos();
    }
   // System.out.println("Usaste pocion de "+ nombreitem +", +"+puntos+" puntos de " + nombreitem + " por "+ duracion + "turnos");
  }
}
}
