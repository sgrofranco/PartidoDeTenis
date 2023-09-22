package partidoDeTenisTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import partidoDeTenis.Jugador;

class JugadorTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void mostrarNombreDeJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		Assert.assertEquals("Franco",jugador.getNombre());
	}
	
	@Test 
	void obtenerPuntacionDeJugadorFranco(){
		Jugador jugador = new Jugador("Franco");
		Assert.assertEquals("La puntuacion de Franco es 0",jugador.getPuntuacion());
	}
	
	@Test 
	void UnaPelotaGanadaParaJugadorFranco(){
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		Assert.assertEquals("La puntuacion de Franco es 15",jugador.getPuntuacion());
	}
	
	@Test 
	void DosPelotsaGanadasParaJugadorFranco(){
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		Assert.assertEquals("La puntuacion de Franco es 30",jugador.getPuntuacion());
	}
	
	@Test 
	void TresPelotsaGanadasParaJugadorFranco(){
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		Assert.assertEquals("La puntuacion de Franco es 40",jugador.getPuntuacion());
	}


}
