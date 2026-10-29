// Hola
public abstract class Personaje {
    private final String nombre; 
    private int puntosDeVida; 
    private int puntosDeMana; 
    private int poderBase; 
    private int defensa;
    private int bonoDefensa; 
    private int bonoAtaque; 

    public Personaje (String nombre, int puntosDeVida, int puntosDeMana, int poderBase, int defensa){
        this.nombre = nombre; 
        this.puntosDeVida = puntosDeVida; 
        this.puntosDeMana = puntosDeMana; 
        this.poderBase = poderBase; 
        this.defensa = defensa; 
        this.bonoDefensa = 0; 
        this.bonoAtaque = 0; 
    }

    public String getNombre(){
        return nombre; 
    }

    public int getPuntosDeVida(){
        return puntosDeVida; 
    }

    public int getPuntosDeMana(){
        return puntosDeMana; 
    }

    protected int getPoderBase(){
        return poderBase + bonoAtaque; 
    }

    public abstract void ejecutarAccion(Personaje objetivo); 
    public void recibirDaño(int ataque){
        int dañoReal = ataque - (defensa + bonoDefensa);
        if (dañoReal < 0){
            dañoReal = 0; 
        }
        puntosDeVida = puntosDeVida -  dañoReal; 
        if (puntosDeVida < 0){
            puntosDeVida = 0; 
        }


    }

    
      
}

