package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {
	

	//Globales
	int xBolita = -1000;
	int yBolita = -1000;
	
	private TCPConnection conexion;
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// 1
	public void settings() {
		size(500, 500);
	}

	// 1
	public void setup() {
		conexion = new TCPConnection();
		
		
		//Metodo de suscripcion
		conexion.setMain(this);
		
		conexion.start();
	
	}

	// Inifito
	public void draw() {
		background(0, 0, 0);
		fill(255, 0, 0);
		ellipse(xBolita, yBolita, 50, 50);
	}
	
	
	//El metodo de notificacion: Aqui se recibe la informacion del evento
	public void notificar(Coordenada c) {
		xBolita = c.getX();
		yBolita = c.getY();
	}
	
	
	

}
