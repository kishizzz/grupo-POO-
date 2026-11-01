public class PocionDefensa extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez
  public PocionDefensa(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override 
  public void usaritem(Personaje personaje){
    if(getDuracion() >0 ){
      personaje.aplicarBonoDefensa(getPuntos());
      System.out.println("+"+getPuntos()+"de defensa");
   if (getDuracion() == 0){
      personaje.limpiarBonos();
    }
    //System.out.println("Usaste pocion de "+ nombreitem +", +"+puntos+" puntos de " + nombreitem + " por "+ duracion + "turnos");
  }
}
}
