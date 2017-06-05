package DragonBall;

public abstract class Gohan extends Personaje {
	
	public Gohan(){
		
		int vida = 300;
		int poder_especial = poder_pelea + ((poder_pelea*25)/100);
		int costo_ataque_especial = 10;
		int costo_transformacion_1 = 10;
		int costo_transformacion_2= 30;
	}

}
