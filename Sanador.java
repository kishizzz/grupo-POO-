public class Sanador extends Personaje{ // Hecho por Alex Almonacid, Krishna Gallardo y Alonso Gonzalez
    
    public Sanador(String nombre, int puntosDeVida, int puntosDeMana, int poderBase, int defensa) {
        super(nombre, puntosDeVida, puntosDeMana, poderBase, defensa);
    }

    // Metodos

    @Override 
    public void ejecutarAccion(Personaje objetivo){
        objetivo.curarAliado(getPoderBase()); // Cura a un aliado
    }
} 