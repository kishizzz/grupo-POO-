import java.util.ArrayList;
import java.util.Scanner; 

public class Main { //hecho por Alex Almonacid, Alonso Gonzales y Krishna Gllardo 
    public static void main(String[] args){
        System.out.println("¡Bienvenido al juego!"); 
        //creamos un lector para que lea todo lo que elija en jugador
        Scanner lector = new Scanner (System.in); 
        //instrucciones 
        System.out.println("Lea las siguientes instrucciones para jugar, por favor:");
        System.out.println("1.- Empiece eligiendo las pociones del equipo 2, las pociones del equipo 1 vienen predeterminadas");
        System.out.println("2.- Empieza jugando el equipo 1, eliga un personaje cualquiera para empezar");
        System.out.println("3.- Con el personaje elegido, eliga una opción");
        System.out.println("4.- Al realizar la accion, pasara el turno del siguiente equipo junto a sus estadisticas del momento");
        System.out.println("5.- Repita las instrucciones con el equipo 2 a su gusto");
        System.out.println("6.- ¡Juegue hasta que uno de los equipos gane!");
        ArrayList<Personaje> equipo1 =  new ArrayList<>(); //Declara una nueva lista 
        //implementamos el fabric 
        equipo1.add(FabricaDePersonajes.crear("Guerrero", "Krishna", new PocionVida("vida", 10, 3))); 
        equipo1.add(FabricaDePersonajes.crear("Sanador", "Alonso", new PocionDefensa("defensa", 20, 3)));
        equipo1.add(FabricaDePersonajes.crear("Mago", "Alex", new PocionAtaque("Fuerza", 20, 3)));
        ArrayList<Personaje> equipo2 = new ArrayList<>(); //Declara una nueva lista 
        System.out.println("Elige un objeto para Krishna mala");
        equipo2.add(FabricaDePersonajes.crear("Guerrero", "Krishna mala", elegirItem(lector)));
        System.out.println("Elige un objeto para Alonso malo");
        equipo2.add(FabricaDePersonajes.crear("Sanador", "Alonso malo", elegirItem(lector)));
        System.out.println("Elige un objeto para Alex malo");
        equipo2.add(FabricaDePersonajes.crear("Mago", "Alex malo", elegirItem(lector)));
        //muestra ambos equipos
       System.out.println("- Equipo 1 -");
        mostrarEquipo(equipo1);
        System.out.println("- Equipo 2 -");
        mostrarEquipo(equipo2);
        //aqui evalua que ambos equipos sigan con vida de modo que los turnos puedan seguir pasando una y otra vez
        while (equipoConVida(equipo1) && equipoConVida(equipo2)){
            System.out.println("¡Turno del equipo 1!");
            mostrarEquipo(equipo1);
            mostrarEquipo(equipo2);
            turno(equipo1, equipo2, lector);
            if (equipoConVida(equipo2)){
                System.out.println("¡Turno del equipo 2!");
                mostrarEquipo(equipo1);
                mostrarEquipo(equipo2);
                turno(equipo2, equipo1, lector);
            }
        }
            //implementamos un if con lo que sucederia si solo uno de los equipos quedara con vida 
        if (equipoConVida(equipo1)){
            System.out.println("¡Felicidades gano el equipo uno!");
        } else {
            System.out.println("¡Felicidades gano el equipo 2!");
        }

    }
    //este bloque recorre la lista para mostrar el nombre, los puntos de vida y los puntos de mana de los personajes y mostrarlos
    public static void mostrarEquipo(ArrayList<Personaje> equipo){
        for (Personaje p : equipo){
            System.out.println(" nombre:" + p.getNombre() + ", puntos de vida:" + p.getPuntosDeVida() + ", puntos de mana:" + p.getPuntosDeMana()); 
        }
    }
    //este bloque evalua si al menos un personaje en el equipo esta vivo para seguir jugando 
    public static boolean equipoConVida(ArrayList<Personaje> equipo ){
        for (Personaje p : equipo){
            if (p.estaVivo()){
                return true; 
            } 
        }
         return false;
    }
    //este bloque le permite al jugador elegir personaje y evalua si puede jugar con el personaje elegido, lo prohibe si este esta muerto 
    public static Personaje elegirPersonaje( ArrayList<Personaje> equipo, Scanner lector ){
        while (true) {
             for (int i = 0; i <equipo.size(); i++){
            System.out.println( i + 1 + ". " + equipo.get(i).getNombre() );
        }
            System.out.println("Elige un personaje...");
            int opcion = leerEntero(lector, 1, equipo.size());
            Personaje p = equipo.get(opcion - 1);
        if (p.estaVivo()){
            return p; 
        }
        System.out.println("¡El personaje no esta vivo! ¡Intentalo con otro!");

        }
}
    //aplicamos un lector que evalua si lo que responde el jugador es un entero y si este esta dentro de las opciones
    public static int leerEntero(Scanner lector, int min, int max){
        while (true){
            System.out.println("Elige una opcion entre: " + min + " y " + max); 
            if (lector.hasNextInt()) { //aqui se implemento un lector que revisara si la respuesta añadida es un entero 
                int valor = lector.nextInt();
                if (valor >= min && valor <= max) {
                    return valor; 
            } System.out.println("¡Fuera de rango! ");
        }else {
                lector.next(); 
                System.out.println("No es ingresable."); 
            }
        }
    }

    public static void turno(ArrayList<Personaje> aliados, ArrayList<Personaje> enemigos, Scanner lector){
        //le avisa a cada jugador que pasa su turno  
         for (Personaje p : aliados){
            if (p.pasarDeTurno()){
                System.out.println(p.getNombre() + ", su bono ha terminado.");
            }
        }
         Personaje elegido = elegirPersonaje(aliados, lector);
        System.out.println("¿Qué acción va a elegir?: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar objeto");
        int accion = leerEntero(lector, 1, 3);
        System.out.println("Elegiste la opción: " + accion);
        if (accion == 1){
            if (elegido instanceof Sanador){
                Personaje objetivo = elegirPersonaje(aliados, lector); 
                elegido.ejecutarAccion(objetivo);
            } else {
                Personaje objetivo = elegirPersonaje(enemigos, lector); 
                elegido.ejecutarAccion(objetivo); 
            }
        } else if (accion == 2){
            if (!elegido.tieneEfectoActivo()){
                elegido.aplicarBonoDefensa(10); 
                elegido.activarEfecto(1);
            } else {
                System.out.println("¡Ya hay efecto activo!");
            }
        }else {
            elegido.usarObjeto();
        }
}

    public static Item elegirItem(Scanner lector){
        System.out.println("¡Eliga una pocion para su personaje!");
        System.out.println("1.- Pocion de ataque");
        System.out.println("2.- Pocion de defensa");
        System.out.println("3.- Pocion de vida");
        int pocion = leerEntero(lector, 1, 3); 
        if (pocion == 1){
            return new PocionAtaque("fuerza", 20, 3); 
        }
        else if (pocion == 2){
            return new PocionDefensa("defensa", 20, 3); 
        }
        return new PocionVida("vida", 10, 3); 
        
    }




    
}
