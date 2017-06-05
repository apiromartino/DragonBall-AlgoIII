package DragonBall;

public abstract class Cell extends Personaje {
	
	protected int vidas_absorbidas;
	
	public Cell(){
		
		int vida = 500;
		int poder_especial = poder_pelea;
		int costo_ataque_especial = 5;
		int costo_transformacion_1 = 4;
		int costo_transformacion_2= 8;
	}
}
