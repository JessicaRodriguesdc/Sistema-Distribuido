package configuration;

import screens.PanelButton;
import screens.PanelSend;

public class Controller {

	PanelSend panelSend;
	ServerConnection connection;
	PanelButton panelButton;

	public Controller() {
		// TODO Auto-generated constructor stub

		connection = new ServerConnection(this);
		connection.start();
	}

	public void conectar(PanelSend panelSend,PanelButton panelButton) {
		this.panelSend = panelSend;
		this.panelButton = panelButton;
	}

	public void send(){
		System.out.println("AES");
		panelSend.setEncryption(encryptionAes());
		panelSend.setConversation("Você: "+ panelSend.getEncryption());
		connection.enviarMensaje(panelSend.getEncryption(), 3);			
	}

	public void messageReceived (String message){		
		panelSend.setEncryption(message);		
	}

	public void algorithmMessage(String message, String ip){
		panelSend.setConversation((ip + ": "+decodedAes(message.substring(1))));
		panelSend.setEncryption(ip + ": "+ message.substring(1));	
	}
	
	
	public String encryptionAes() {	
		 String key = "92AE31A79FEEB2A3"; //chave
		 String iv = "0123456789ABCDEF"; //vetor de inicialização
		 String cleartext = panelSend.getMessage();
		 String encryption = "";
		 try {
			encryption = Encrypt.encrypt(key, iv,cleartext);
			System.out.println("Texto criptografado: "+Encrypt.encrypt(key, iv,cleartext));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return encryption;
		 
	}
	
	public String decodedAes(String cifrado) {
		
		String key = "92AE31A79FEEB2A3"; //chave
		String iv = "0123456789ABCDEF"; //vetor de inicialização
		String decoded = "";
		try {
			decoded = Encrypt.decrypt(key, iv,cifrado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decoded;
	}

}
