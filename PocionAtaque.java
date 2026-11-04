public class PocionAtaque extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez
  public PocionAtaque(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override
  public void usaritem(Personaje personaje){
    if (getDuracion()>0){                         //se fija si la duracion de la pocion se acabó o no,
    personaje.aplicarBonoAtaque(getPuntos());
    System.out.println("+"+getPuntos()+"de ataque");
    if (getDuracion() == 0){    //si se acabó se quitan los efectos de la pocion
      personaje.limpiarBonos();
    }
  }
}
}
