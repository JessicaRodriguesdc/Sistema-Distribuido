package screens;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelSendMessage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextField mensaje, mensajeCifrado;
	JTextArea conversacion;
	JLabel chat, historial, cifrado;
	JButton btnEnviar, btnCifrar, btnDescifrar;
	JScrollBar rolagem;
	JFrame  conversacionFrame;

	
	public PanelSendMessage() {
		// TODO Auto-generated constructor stub
		
		setLayout(new GridLayout(6, 2));
		
		mensajeCifrado = new JTextField();
		chat = new JLabel("Envie sua mensagem: ");
		cifrado = new JLabel("Mensagem criptografada: ");
		historial = new JLabel("Historico da mensagem: ");
		
		conversacion = new JTextArea();
		
		mensaje = new JTextField(20);
		
		setBorder( new CompoundBorder( new EmptyBorder( 10, 10, 10, 10 ), new TitledBorder( " CHAT-CRYPTOGRAPH " ) ) );
		
		add(historial);
		add(conversacion);
		add(cifrado);
		add(mensajeCifrado);
		add(chat);
		add(mensaje);
		
		setVisible(true);
	}
	
	public void setConversacion(String conversacion) {
		this.conversacion.append(("\n"+conversacion));
	}
	
	public String getMensaje() {
		return mensaje.getText();
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje.setText(mensaje);
	}

	public String getCifrado() {
		return mensajeCifrado.getText();
	}
	
	public void setCifrado(String mensaje) {
		this.mensajeCifrado.setText(mensaje);
	}

	
}
