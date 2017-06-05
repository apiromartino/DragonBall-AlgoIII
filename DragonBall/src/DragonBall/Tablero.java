package DragonBall;

public class Tablero {
	
	private Personaje[][] tablero;
	
	public Tablero(){
		
		tablero = new Personaje[30][30];
	}
	
	public void ubicarEn(Personaje personaje, int x, int y){
		
		tablero[x][y] = personaje;
		
		personaje.nuevaUbicacion(x,y); 
	}
}
	
