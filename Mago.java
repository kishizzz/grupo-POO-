public class Mago extends Personaje{ // Hecho por Alex Almonacid, Krishna Gallardo y Alonso Gonzalez
    public final int costoMana;
    
    public Mago(String nombre, int puntosDeVida, int puntosDeMana, int poderBase, int defensa, int costoMana){
        super(nombre, puntosDeVida, puntosDeMana, poderBase, defensa);
        this.costoMana = costoMana;
    }

    public int getCostoMana(){
        return this.costoMana;
    }

    @Override 
    public void ejecutarAccion(Personaje objetivo){
        if (gastarMana(costoMana)) { // Llama a la función y verifica si tiene mana suficiente
            objetivo.recibirDaño(getPoderBase());
        } else {
            System.out.println("No tiene mana suficiente.");
        }
    }


}
