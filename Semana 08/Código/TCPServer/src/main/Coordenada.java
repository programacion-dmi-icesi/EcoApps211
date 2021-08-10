package main;

public class Coordenada {

	//Atributos
	private int x,y;
	private int ancho;
	private int alto;
	private boolean blackAndWhite;
	
	//Constructores
	public Coordenada(int x, int y, int ancho, int alto, boolean blackAndWhite) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.blackAndWhite = blackAndWhite;
	}

	
	//Metodos
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getAncho() {
		return ancho;
	}


	public void setAncho(int ancho) {
		this.ancho = ancho;
	}


	public int getAlto() {
		return alto;
	}


	public void setAlto(int alto) {
		this.alto = alto;
	}


	public boolean isBlackAndWhite() {
		return blackAndWhite;
	}


	public void setBlackAndWhite(boolean blackAndWhite) {
		this.blackAndWhite = blackAndWhite;
	}

	
	
	
	
	
	
}
