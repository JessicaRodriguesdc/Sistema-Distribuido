package configuration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection extends Thread implements Runnable {

	private final int PORT= 4000;
	private ServerSocket serverSocket;
	private Socket socket;	
	private DataOutputStream exit;
	private DataInputStream entrance;
	private Controller ctrl;
	private String sentMessage;
	
	public ServerConnection (Controller ctrl) {		

		try {					
			socket = new Socket();
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
			serverSocket = new ServerSocket(PORT);	
			
			System.out.println("Executando...");
			socket = serverSocket.accept();
			System.out.println("Conexão aceita");

			entrance = new DataInputStream(socket.getInputStream());
			exit = new DataOutputStream(socket.getOutputStream());

			while(true){
				
				leerMensaje();
			}


		} catch (IOException e) {

			System.out.println("Error: "+  e.getMessage());
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
			ctrl.algoritmoMensaje(entrance.readUTF(), ""+socket.getInetAddress());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void setMensajeAEnviar(String sentMessage) {
		this.sentMessage = sentMessage;
	}
	public String getMensajeAEnviar() {
		return sentMessage;
	}

}
