package configuration;

import java.util.ArrayList;

import screens.PanelButton;
import screens.PanelSend;

public class Controller {

	PanelSend panelSend;
	ServerConnection conexion;
	String matriz [][];
	PanelButton panelButton;
	ArrayList<String> llavesDes;

	public Controller() {
		// TODO Auto-generated constructor stub
		conexion = new ServerConnection(this);
		conexion.start();
		llavesDes = new ArrayList<>();		
	}


	public void connect(PanelSend panelSend,PanelButton panelButton) {
		this.panelSend = panelSend;
		this.panelButton = panelButton;

	}

	public void send(){
		System.out.println("AES");
		panelSend.setCifrado(cifrarAes());
		panelSend.setConversacion("Você: "+ panelSend.getCifrado());
		conexion.sendMessage(panelSend.getCifrado(), 3);			
	}

	public void messageReceived (String message){		
		panelSend.setCifrado(message);		
	}

	public void algorithmMessage(String message, String ip){
		panelSend.setConversacion((ip + ": "+descifrarAes(message.substring(1))));
		panelSend.setCifrado(ip + ": "+ message.substring(1));
	}
	
	public String cifrarAes() {	
		 String key = "92AE31A79FEEB2A3"; //chave
		 String iv = "0123456789ABCDEF"; // vetor de inicialização
		 String cleartext = panelSend.getMensaje();
		 String cifrado = "";
		 try {
			cifrado = Encrypt.encrypt(key, iv,cleartext);
			System.out.println("Texto encriptado: "+Encrypt.encrypt(key, iv,cleartext));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return cifrado;
		 
	}
	
	public String descifrarAes(String cifrado) {
		
		String key = "92AE31A79FEEB2A3"; //chave
		String iv = "0123456789ABCDEF"; // vetor de inicialização
		String descifrado = "";
		try {
			descifrado = Encrypt.decrypt(key, iv,cifrado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return descifrado;
	}

}
