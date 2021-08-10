package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {

	private BufferedWriter bwriter;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {

		new Thread(() -> {
			try {
				// 2. Conectarnos
				// Ponemos la IP del server y el puerto donde el servidor escucha
				Socket socket = new Socket("127.0.0.1", 5000);

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				OutputStreamWriter osw = new OutputStreamWriter(os);
				bwriter = new BufferedWriter(osw);

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}

	public void mousePressed() {
		
		Gson gson = new Gson();
		
		Coordenada coord = new Coordenada(mouseX, mouseY, 10, 10, true);
		
		//Serializacion
		String coordStr = gson.toJson(coord); 
		
		System.out.println(coordStr);

		// Envie al server

		
		new Thread(() -> {
			try {
				bwriter.write(coordStr + "\n");
				bwriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		

	}

	public void draw() {
		background(255, 255, 255);
	}

}
