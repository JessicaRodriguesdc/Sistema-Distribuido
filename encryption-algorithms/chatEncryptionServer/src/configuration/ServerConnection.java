package configuration;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection extends Thread implements Runnable {


	private final int PORT= 5000;
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
			System.out.println("serversocket criado");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+  e.getMessage());
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			serverSocket = new ServerSocket(PORT);	
			
			System.out.println("Servidor executando...");
			socket = serverSocket.accept();
			System.out.println("conexão aceita");

			entrance = new DataInputStream(socket.getInputStream());
			exit = new DataOutputStream(socket.getOutputStream());

			while(true){
				
				readMessage();
			}


		} catch (IOException e) {

			System.out.println("Error "+  e.getMessage());
		}

	}
	
	public void sendMessage(String message, int algorithm){	
		
		 try {
			 
			exit.writeUTF(algorithm+message);
			
		} catch (IOException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void readMessage() {
		try {
			ctrl.algorithmMessage(entrance.readUTF(), ""+socket.getInetAddress());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void setMessageSend(String sendMessage) {
		this.sentMessage = sendMessage;
	}
	public String getMensajeAEnviar() {
		return sentMessage;
	}

}
