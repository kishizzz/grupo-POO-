public class PocionVida extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez
  public PocionVida(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override 
  public void usaritem(Personaje personaje){

      if (personaje.getPuntosDeVida()<=0){
        System.out.println("cagaste");
      } else {
        personaje.curar(getPuntos());
        System.out.println("Te curaste "+getPuntos()+" puntos de vida");
      }
    }
    //System.out.println("Usaste pocion de "+ nombreitem +", +"+puntos+" puntos de " + nombreitem + " por "+ duracion + "turnos");
  }
