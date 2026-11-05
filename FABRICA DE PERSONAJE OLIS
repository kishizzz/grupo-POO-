public class FabricaDePersonajes { //hecho por Alex almonacid, Alonso Gonzales y Krishna Gallardo
    public static Personaje crear (String rol, String nombre, Item item){
        if (rol.equals("Guerrero")){
            return new Guerrero(nombre, 100, 10, 100, 30, item  );
            }
        if (rol.equals("Sanador")){
            return new Sanador(nombre, 100, 100, 40, 30, item ); 
        }

        if (rol.equals("Mago")){
            return new Mago(nombre, 50, 50, 100, 10, item, 10 ); 
        }
        return null; 


            
            

        }
    }
    

//elegimos como grupo usar el patron de diseño facotry porque al haber una variedad de personajes que crear, era mas practico utilizar este y
//directamente ir creador personajes ya prederminados de modo que ahora podriamos crear tantos personajes en cada equipo como queramos tal solo añadiendo 
//un nuevo sanador, mago o guerrero sin tener que estar escribiendo uno por uno todas sus caracteristicas y puntos. 
//es mas sencillo tener una "fabrica" que saque estos personajes como predeterminados a tener que estar creando uno por uno 
