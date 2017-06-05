package DragonBall;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Personaje> personajes;
    
    public Jugador(){
        this.personajes = new ArrayList<Personaje>();
    }
    
    public void asignarPersonajes(Personaje personaje1, Personaje personaje2, Personaje personaje3){
        this.personajes.add(personaje1);
        this.personajes.add(personaje2);
        this.personajes.add(personaje3);
    }
    
    public ArrayList<Personaje> obtenerPersonajes(){
        ArrayList<Personaje> lista_a_devolver = (ArrayList<Personaje>) this.personajes.clone();
        return lista_a_devolver;
    }
}