public abstract class Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez

    private  String nombreitem;
    private int puntos;
    private int duracion;

    public Item(String nombreitem, int puntos, int duracion){
        this.nombreitem = nombreitem;
        this.puntos = puntos;
        this.duracion = duracion;
    }
    @SuppressWarnings("unused")
    abstract void usaritem(Personaje personaje); //metodo abstracto que hará todo lo de las pociones

    public String getNombreitem(){
        return nombreitem;
    }
    public int getPuntos(){
        return puntos;
    }
    public int getDuracion(){
        return duracion;
    }
}