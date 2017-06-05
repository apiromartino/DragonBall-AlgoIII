package DragonBall;

public class Juego {
    Tablero tablero;
    Jugador jugador1;
    Jugador jugador2;
    
    public Juego(){
    }
    
    public void asignarTablero(Tablero un_tablero){
        this.tablero = un_tablero;
    }
    
    public void asignarJugador1(Jugador jugador){
        this.jugador1 = jugador;
    }
    
    public void asignarJugador2(Jugador jugador){
        this.jugador2 = jugador;
    }
    
    public Jugador obtenerJugador1(){
        return this.jugador1;
    }
    
    public Jugador obtenerJugador2(){
        return this.jugador2;
    }
    
}