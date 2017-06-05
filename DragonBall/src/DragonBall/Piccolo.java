package DragonBall;

public abstract class Piccolo extends Personaje{
	
	public Piccolo(){
		
		int vida = 500;
		int poder_especial = poder_pelea + ((poder_pelea*25)/100);
		int costo_ataque_especial = 10;
		int costo_transformacion_1 = 20;
		int costo_transformacion_2= 0;
	}
}
