public abstract class Item { // Hecho por Alex Almonacid, Krishna Gallardo, Alonso Gonzalez

    protected  String nombreitem;
    protected int puntos;
    protected int duracion;

    public Item(String nombreitem, int puntos, int duracion){
        this.nombreitem = nombreitem;
        this.puntos = puntos;
        this.duracion = duracion;
    }
    @SuppressWarnings("unused")
    abstract void usaritem(); //metodo abstracto que hará todo lo de las pociones
}