package DragonBall;

public abstract class Personaje {
    protected int vida;
    protected int poder_pelea;
    protected int distancia_ataque;
    protected int velocidad;
    protected int ki;
    protected int poder_especial;
    protected int costo_poder_especial;
    protected int costo_transformacion_1;
    protected int costo_transformacion_2;
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
    
    public void nuevaUbicacion(int x, int y){
    	ubicacion = new Ubicacion(x,y);
    }
    
    public int obtenerPoderDePelea(){
    	return this.poder_pelea;
    }
    
    public int obtenerVida(){
    	return this.vida;
    }
}
