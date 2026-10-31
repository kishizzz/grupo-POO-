public class Mago extends Personaje{ // Hecho por Alex Almonacid, Krishna Gallardo y Alonso Gonzalez
    private final int costoMana;
    
    public Mago(String nombre, int puntosDeVida, int puntosDeMana, int poderBase, int defensa, Item objetoEquipado, int costoMana){
        super(nombre, puntosDeVida, puntosDeMana, poderBase, defensa, objetoEquipado);
        this.costoMana = costoMana;
    }

    // Getters

    public int getCostoMana(){
        return this.costoMana;
    }

    // Metodos

    @Override 
    public void ejecutarAccion(Personaje objetivo){
        if (gastarMana(costoMana)) { // Llama a la función y verifica si tiene mana suficiente
            objetivo.recibirDaño(getPoderBase());
        } else {
            System.out.println("No tiene mana suficiente.");
        }
    }


}
