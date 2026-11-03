public class FabricaDePersonajes {
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
    
