package partidoDeTenis;

public class Jugador {
	
	private String nombre;
	private Integer puntuacion;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPuntuacion() {
		return "La puntuacion de "+this.nombre+ " es "+this.puntuacion.toString();
	}

	public void sumarPunto() {
		this.puntuacion = this.puntuacion + 15;
	}
	
	
	
	

}
