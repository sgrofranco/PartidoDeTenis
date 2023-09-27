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
		assertEquals("Franco", jugador.getNombre());
	}

	@Test
	void obtenerPuntacionDeJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		assertEquals( 0, jugador.getPuntuacion());
	}

	@Test
	void UnaPelotaGanadaParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		assertEquals(15, jugador.getPuntuacion());
	}

	@Test
	void DosPelotsaGanadasParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		assertEquals(30, jugador.getPuntuacion());
	}

	@Test
	void TresPelotsaGanadasParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		assertEquals(40, jugador.getPuntuacion());
	}

	@Test
	void UnGameGanadoParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		assertEquals(1, jugador.getGames());
	}

	@Test
	void DosGamesGanadosParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		for (int i = 0; i < 8; i++) {
			jugador.pelotaGanada();
		}
		assertEquals(2, jugador.getGames());
	}

	@Test
	void UnSetGanadosParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		for (int i = 0; i < 24; i++) {
			jugador.pelotaGanada();
		}
		assertEquals(1, jugador.getSet());
	}

	@Test
	void TresSetGanadosParaJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		for (int i = 0; i < 72; i++) {
			jugador.pelotaGanada();
		}
		assertEquals(true, jugador.getGanador());
	}

	@Test
	void EstadisticasReiniciadasParaJugadorFrancoLuegoDeGanar() {
		Jugador jugador = new Jugador("Franco");
		for (int i = 0; i < 72; i++) {
			jugador.pelotaGanada();
		}

		assertEquals(0, jugador.getSet());
	}

	@Test
	public void jugadorFrancoEstaEnDeuce() {
		Jugador jugador = new Jugador("Franco");
		jugador.setDeuce(true);
		assertEquals(true, jugador.getDeuce());

	}

	@Test
	public void jugadorFrancoEstaEnVentaja() {
		Jugador jugador = new Jugador("Franco");
		jugador.setDeuce(true);
		jugador.setVentaja(true);
		assertEquals(true, jugador.getVentaja());
	}

	@Test
	public void jugadorFrancoNoEstaEnVentajaPorNoEstarEnDeuce() {
		Jugador jugador = new Jugador("Franco");
		jugador.setVentaja(true);
		assertEquals(false, jugador.getVentaja());
	}
	
	@Test
	public void imprimirPuntajeDelJugadorFranco() {
		Jugador jugador = new Jugador("Franco");
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.pelotaGanada();
		jugador.imprimirPuntuacionDeJugador();
		assertEquals("Franco: 0/1/40", outputStreamCaptor.toString().trim());
		
	}

}