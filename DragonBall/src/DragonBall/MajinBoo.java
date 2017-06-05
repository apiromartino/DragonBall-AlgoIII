package DragonBall;

public abstract class MajinBoo extends Personaje{
	protected int poder_especial_stun_turnos;
	
	public MajinBoo(){
		
		int vida = 300;
		int poder_especial_stun_turnos = 3;
		int costo_ataque_especial = 30;
		int costo_transformacion_1 = 20;
		int costo_transformacion_2= 50;
	}
}
