package DragonBall;

public abstract class Personaje {
    protected int vida;
    protected int poder_pelea;
    protected int distancia_ataque;
    protected int velocidad;
    protected int ki;
    protected int poder_especial;
    protected Ubicacion ubicacion;
    
    public Personaje(){
        this.ki = 0;
    }
    
    public void aumentarKi(int cantidad){
        this.ki += cantidad;
    }
    
    public Ubicacion obtenerUbicacion(){
        return this.ubicacion;
    }
}
