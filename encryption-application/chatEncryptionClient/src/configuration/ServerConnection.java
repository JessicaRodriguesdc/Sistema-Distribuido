package configuration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection extends Thread implements Runnable {

	private final int PORT= 5000;
	private final String HOST = "localhost";
	private Socket socket;	
	private DataOutputStream exit;
	private DataInputStream entrance;
	private ServerConnection ctrl;
	private String sentMessage;

	public ServerConnection (ServerConnection ctrl) {		

		try {	
			socket = new Socket(HOST,PORT);
			this.ctrl = ctrl;
			System.out.println("serverocket criado");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error "+  e.getMessage());
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			
			System.out.println("conexion aceptada");

			entrance = new DataInputStream(socket.getInputStream());
			exit = new DataOutputStream(socket.getOutputStream());


			while(true){
				leerMensaje();
			}


		} catch (IOException e) {

			System.out.println("Error "+  e.getMessage());
		}

	}

	
	
	public void enviarMensaje(String mensaje, int algoritmo){	
		
		 try {
			 
			exit.writeUTF(algoritmo+mensaje);
			
		} catch (IOException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void leerMensaje() {
		try {
			System.out.println("Cliente logado");
			ctrl.algoritmoMensaje(entrance.readUTF(), ""+socket.getInetAddress());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void setMensajeAEnviar(String mensajeAEnviar) {
		this.sentMessage = mensajeAEnviar;
	}
	public String getMensajeAEnviar() {
		return sentMessage;
	}

}
