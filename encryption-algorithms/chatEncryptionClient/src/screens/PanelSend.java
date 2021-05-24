package screens;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelSend extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextField message, cipheredMessage;
	JTextArea conversation;
	JLabel chat, history, ciphered;
	JButton btnEnviar, btnCifrar, btnDescifrar;
	
	public PanelSend() {
		// TODO Auto-generated constructor stub
		
		setLayout(new GridLayout(6, 2));	
		cipheredMessage = new JTextField();
		chat = new JLabel("Envie sua mensagem: ");
		ciphered = new JLabel("Mensagem criptografada: ");
		history = new JLabel("Historico da mensagem: ");
		conversation = new JTextArea();
		message = new JTextField(20);
		
		setBorder( new CompoundBorder( new EmptyBorder( 10, 10, 10, 10 ), new TitledBorder( " CHAT CRYPTOGRAPH " ) ) );		
		
		add(history);
		add(conversation);
		add(ciphered);
		add(cipheredMessage);
		add(chat);
		add(message);
		
		setVisible(true);
	}
	
	public void setConversation(String conversation) {
		this.conversation.append(("\n"+conversation));
	}
	
	public String getMessage() {
		return message.getText();
	}
	
	public void setMessage(String mensaje) {
		this.message.setText(mensaje);
	}

	public String getEncryption() {
		return cipheredMessage.getText();
	}
	
	public void setEncryption(String mensaje) {
		this.cipheredMessage.setText(mensaje);
	}

	
}
