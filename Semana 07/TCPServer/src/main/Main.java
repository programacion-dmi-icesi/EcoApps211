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
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	// 1
	public void settings() {
		size(500, 500);
	}

	// 1
	public void setup() {

		// Ejecutar en segundo
		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando cliente...");
				Socket socket = server.accept();
				System.out.println("Cliente esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				// Hacer que el objeto is tenga la capacidad de leer Strings completos
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);

				while (true) {
					// Esperando mensaje
					System.out.println("Esperando mensaje...");
					String mensajeRecibido = breader.readLine();
					System.out.println(mensajeRecibido);					
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}

	// Inifito
	public void draw() {
		background(0, 0, 0);
		fill(255, 0, 0);
		ellipse(xBolita, yBolita, 50, 50);
	}

}
