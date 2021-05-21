package configuration;
import java.util.ArrayList;
import screens.PanelButton;
import screens.PanelSendMessage;

public class Controller {

	PanelSendMessage panelEnviar;
	ServerConnection conexion;
//	Utils util;
	String matriz [][];
	PanelButton panelBotones;
	ArrayList<String> llavesDes;

	public Controller() {
		// TODO Auto-generated constructor stub
		conexion = new ServerConnection(this);
		conexion.start();
//		util = new Utils();
		llavesDes = new ArrayList<>();		
	}


	public void conectar(PanelSendMessage panelEnviar,PanelButton panelBotones) {
		this.panelEnviar = panelEnviar;
		this.panelBotones = panelBotones;
	}

	public void enviar(){	
		System.out.println("AES");
		panelEnviar.setCifrado(cifrarAes());
		panelEnviar.setConversacion("Yo: "+ panelEnviar.getCifrado());
		conexion.enviarMensaje(panelEnviar.getCifrado(), 3);			

	}

	public void mensajeRecibido (String mensaje){		
		panelEnviar.setCifrado(mensaje);		
	}

	public void algoritmoMensaje(String mensaje, String ip){
		panelEnviar.setConversacion((ip + ": "+descifrarAes(mensaje.substring(1))));
		panelEnviar.setCifrado(ip + ": "+ mensaje.substring(1));
	}
	
	public String cifrarAes() {
		 String key = "92AE31A79FEEB2A3"; //llave
		 String iv = "0123456789ABCDEF"; // vector de inicialización
		 String cleartext = panelEnviar.getMensaje();
		 String cifrado = "";
		 try {
			cifrado = configuration.Encrypt.encrypt(key, iv,cleartext);
			System.out.println("Texto encriptado: "+configuration.Encrypt.encrypt(key, iv,cleartext));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return cifrado;
		 
	}
	
	public String descifrarAes(String cifrado) {		
		String key = "92AE31A79FEEB2A3"; //llave
		String iv = "0123456789ABCDEF"; // vector de inicialización
		String descifrado = "";
		try {
			descifrado = configuration.Encrypt.decrypt(key, iv,cifrado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return descifrado;
	}
	

}
