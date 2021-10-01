package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {

	// Globales
	int xBolita = -1000;
	int yBolita = -1000;

	private Avatar player1;
	private Avatar player2;

	private TCPConnectionP1 conexionJ1;
	private TCPConnectionP2 conexionJ2;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// 1
	public void settings() {
		size(500, 500);
	}

	// 1
	public void setup() {
		conexionJ1 = new TCPConnectionP1();
		// Metodo de suscripcion
		conexionJ1.setMain(this);
		conexionJ1.start();

		conexionJ2 = new TCPConnectionP2();
		// Metodo de suscripcion
		conexionJ2.setMain(this);
		conexionJ2.start();

		player1 = new Avatar(this, 100, 100, color(255, 0, 0));
		player2 = new Avatar(this, 400, 400, color(0, 0, 255));
	}

	// Inifito
	public void draw() {
		background(0, 0, 0);
		fill(255, 0, 0);
		ellipse(xBolita, yBolita, 50, 50);

		player1.pintar();
		player2.pintar();
	}

	// El metodo de notificacion: Aqui se recibe la informacion del evento
	public void notificar(Coordenada c, Object obj) {

		// obj será un objeto de TCPConnectionP1?
		if (obj instanceof TCPConnectionP1) {
			System.out.println("JUGADOR 1:" + c.getAccion());
			switch (c.getAccion()) {

			case "DOWN":
				player1.moveDown();
				break;
			case "UP":
				player1.moveUp();
				break;
			case "RIGHT":
				player1.moveRight();
				break;
			case "LEFT":
				player1.moveLeft();
				break;

			}

		}

		else if (obj instanceof TCPConnectionP2) {
			System.out.println("JUGADOR 2:" + c.getAccion());
			switch (c.getAccion()) {

			case "DOWN":
				player2.moveDown();
				break;
			case "UP":
				player2.moveUp();
				break;
			case "RIGHT":
				player2.moveRight();
				break;
			case "LEFT":
				player2.moveLeft();
				break;

			}
		}

	}

}
