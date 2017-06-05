package DragonBall;

public class Ubicacion {
    private int x;
    private int y;
    
    public Ubicacion(int horizontal, int vertical){
        this.x = horizontal;
        this.y = vertical;
    }
    
    public int obtenerUbicacionHorizontal(){
        return this.x;
    }
    
    public int obtenerUbicacionVertical(){
        return this.y;
    }
    
    public void cambiarUbicacion(int horizontal_nuevo, int vertical_nuevo){
        this.x = horizontal_nuevo;
        this.y = vertical_nuevo;
    }
}