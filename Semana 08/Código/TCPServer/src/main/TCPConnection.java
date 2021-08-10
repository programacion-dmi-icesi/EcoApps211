package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPConnection extends Thread{


	//La referencia del Chismoso
	private Main ref;
	
	
	
	@Override
	public void run() {
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
				Gson gson = new Gson();
				Coordenada c = gson.fromJson(mensajeRecibido, Coordenada.class);
				
				System.out.println(c.getX());
				System.out.println(c.getY());
				
				
				//Notificar o avisar a MAIN
				ref.notificar(c);
				
				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Metodo de suscripcion
	public void setMain(Main main) {
		this.ref = main;
	}
	
	
}
