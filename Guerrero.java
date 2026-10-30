public class Guerrero extends Personaje{ // Hecho por Alex Almonacid, Krishna Gallardo y Alonso Gonzalez
    public Guerrero(String nombre, int puntosDeVida, int puntosDeMana, int poderBase, int defensa){
        super(nombre, puntosDeVida, puntosDeMana, poderBase, defensa);
    }

    // Metodos

    @Override 
    public void ejecutarAccion(Personaje objetivo){
        objetivo.recibirDaño(getPoderBase()); // le hace daño al objetivo seleccionado
    }
}
