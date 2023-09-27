package partidoDeTenis;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public void pelotaGanadaParaJugador1() {
		this.jugador1.pelotaGanada();
	}
	
	public void pelotaGanadaParaJugador2() {
		this.jugador2.pelotaGanada();
	}

}
