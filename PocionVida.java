public class PocionVida extends Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez
  public PocionVida(String nombreitem, int puntos, int duracion) {
        super(nombreitem, puntos, duracion);
    }

  @Override 
  public void usaritem(Personaje personaje){

      if (personaje.getPuntosDeVida()<=0){ // se fija si el personaje murió o no, si murió no pasa nada, solo el mensaje en consola.
        System.out.println("Pociones no funcionan en gente muerta.");
      } else {
        personaje.curarAliado(getPuntos());//si el personaje está vivo se regenera la vida.
        System.out.println("Te curaste "+getPuntos()+" puntos de vida");
      }
    }

  }
