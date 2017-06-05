package DragonBall;

import static org.junit.Assert.*;

import org.junit.Test;

public class DragonBallTests {

	@Test
	public void testUbicarPersonaje() {
		
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,7,5);
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testMoverPersonaje() {
		
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,7,5);
		tablero.moverA(goku,9,7);
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",9, ubicacion.obtenerUbicacionEnX());
		Assert.assertEquals("La ubicacion verticalsi fallo",5, ubicacion.obtenerUbicacionEnY());
	}
	
	@Test
	public void testMoverPersonajeMal(){
		
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,7,5);
		try{
			tablero.moverA(goku,10,7);
		}
		catch (PosicionInadecuada e) {
			Assert.fail("Se intentó mover al personaje a un lugar que no puede.");
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
		
	}
	
	@Test
	public void testDosPersonajesEnUnMismoCasillero(){
		
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,5,5);
		MajinBoo boo = new MajinBooNormal;
		tablero.ubicarEn(boo,6,5);
		try{
			tablero.moverA(boo,5,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se puede mover el personaje ya que se encuentra otro en ese lugar");
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",5, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
		Ubicacion ubicacion2 = boo.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",6, ubicacion2.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion2.obtenerUbicacionVertical());
	}
	
	
	@Test
	public void testPasarConUnPersonajePorEncimaDeOtro(){   //No estamos seguros de como se van a mover los pj. Esto es suponinedo que no se pueden mover diagonalmente.
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku.5,5);
		MajinBoo boo = new MajinBooNormal;
		tablero.ubicarEn(boo,6,5);
		try{
			tablero.moverA(goku,7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se puede mover el personaje ya que estaria pasando por arriba de otro personaje");
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",5, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
		Ubucacion ubicacion2 = boo.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",6, ubicacion2.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion2.obtenerUbicacionVertical());
	}
		
	
	@Test
	public void testUbicarYTransformarPersonajeSinCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,5,5);
		try{
			goku.transformar(1);//se intenta transformar a Kaio-Ken que es su primer transformacion
		}
		catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo transformar");
		}
	}
	
	@Test
	public void testUbicarYTransformarPersonajeConCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,5,5);
		goku.aumentarKi(50);
		try{
			goku.transformar(1);
		}
		catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo transformar");
		}
		assertEquals("No se transformo",40,goku.obtenerPoderDePelea());//Si se trasnformo va a tener un poder de pelea de 40 en vez de 20
	}
	
	
	@Test
	public void ubicar_transformar_y_mover_personaje() {
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		tablero.ubicarEn(goku,7, 5);
		goku.aumentarKi(20);
		try {
				goku.transformar(2);
		} 
		catch (TansformacionError error){
			Assert.fail("Fallo la transfomración");
		}
		tablero.moverA(goku,9,7);
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals(9, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals(7, ubicacion.obtenerUbicacionVertical());
	}
	
	
	@Test
	public void integracion1() {
		Juego juego = new Juego();
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		juego.asignarTablero(tablero);
		juego.asignarJugador1(jugador1);
		juego.asignarJugador2(jugador2);
		
		Goku goku = new GokuNormal();
		Gohan gohan = new GohanNormal();
		Piccolo piccolo = new Piccolo();
		Cell cell = new CellNormal();
		Freezer freezer = new FreezerNormal();
		MajinBoo majinboo = new MajinBooNormal();
		
		jugador1.asignarPersonajes(goku, gohan, piccolo);
		jugador2.asignarPersonajes(cell, freezer, majinboo);
		tablero.ubicarPersonajes(jugador1);
		tablero.ubicarPersonajes(jugador2);
		
		Assert.assertEquals(jugador1, juego.obtenerJugador1());
		Assert.assertEquals(jugador2, juego.obtenerJugador2());
		Assert.assertEquals(30, tablero.obtenerTamanio());
		
		Ubicacion ubicacion_goku = goku.obtenerUbicacion();
		Ubicacion ubicacion_gohan = gohan.obtenerUbicacion();
		Ubicacion ubicacion_piccolo = piccolo.obtenerUbicacion();
		Ubicacion ubicacion_cell = cell.obtenerUbicacion();
		Ubicacion ubicacion_freezer = freezer.obtenerUbicacion();
		Ubicacion ubicacion_majinboo = majinboo.obtenerUbicacion();
		
		Assert.assertEquals(0, ubicacion_goku.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2) - 1, ubicacion_goku.obtenerUbicacionVertical());
		Assert.assertEquals(0, ubicacion_gohan.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2), ubicacion_gohan.obtenerUbicacionVertical());
		Assert.assertEquals(0, ubicacion_piccolo.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2) + 1, ubicacion_piccolo.obtenerUbicacionVertical());
		
		Assert.assertEquals(30, ubicacion_cell.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2) - 1, ubicacion_cell.obtenerUbicacionVertical());
		Assert.assertEquals(30, ubicacion_freezer.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2), ubicacion_freezer.obtenerUbicacionVertical());
		Assert.assertEquals(30, ubicacion_majinboo.obtenerUbicacionHorizontal());
		Assert.assertEquals(((tablero.obtenerTamanio())/2) + 1, ubicacion_majinboo.obtenerUbicacionVertical());
	}
	
	
	@Test
	public void atacar_respetando_distancias(){
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		Cell cell = new CellNormal();
		
		tablero.ubicarEn(goku,1,1);
		tablero.ubicarEn(cell,2,2);
		
		cell.ataqueBasico(goku);
		Assert.assertEquals(480, goku.obtenerVida());
		goku.ataqueBasico(cell);
		Assert.assertEquals(480, cell.obtenerVida());
	}
	
	@Test
	public void atacar_sin_respetar_distancias(){
		Tablero tablero = new Tablero();
		Goku goku = new GokuNormal();
		Cell cell = new CellNormal();
		
		tablero.ubicarEn(goku,1,1);
		tablero.ubicarEn(cell,10, 10);
		
		Assert.assertTrue(false, cell.ataqueBasico(goku));
		Assert.assertFalse(false, goku.ataqueBasico(cell));
		Assert.assertEquals(500, goku.obtenerVida());
		Assert.assertEquals(500, cell.obtenerVida());
	}


}
