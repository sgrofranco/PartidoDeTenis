package partidoDeTenisTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import partidoDeTenis.Juego;
import partidoDeTenis.Jugador;

class JuegoTest {

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
	void JuegoGanadoPorFranco() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		for (int i = 0; i < 72; i++) {
			tenis.pelotaGanadaParaJugador1();
		}
		assertEquals(true, Franco.getGanador());
	}

	@Test
	void JuegoGanadoPorDavid() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		for (int i = 0; i < 72; i++) {
			tenis.pelotaGanadaParaJugador2();
		}
		assertEquals(true, David.getGanador());
	}

	@Test
	void verificarJuegoEstaEnDeuce() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		assertEquals(true, tenis.verSiJugadoresEstanEnDeuce());
	}

	@Test
	void jugadorFrancoEstaEnVentaja() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador1();
		assertEquals(true, Franco.getVentaja());
	}

	@Test
	void jugadorDavidEstaEnVentaja() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		assertEquals(true, David.getVentaja());
	}
	
	@Test
	void JugadorFrancoGanaGame() {
		Jugador Franco = new Jugador("Franco");
		Jugador David = new Jugador("David");
		Juego tenis = new Juego(Franco, David);
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador2();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		tenis.pelotaGanadaParaJugador1();
		Franco.imprimirPuntuacionDeJugador();
		assertEquals("Franco: 0/1/0", outputStreamCaptor.toString().trim());
	}

}
