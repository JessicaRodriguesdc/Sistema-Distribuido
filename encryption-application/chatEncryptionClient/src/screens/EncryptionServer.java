package screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import configuration.*;

public class EncryptionServer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	PanelSendMessage panelEnviar;
	PanelButton panelBtn;
	Controller ctrl;
		
	
	public EncryptionServer(Controller ctrl) {
		
		this.ctrl = ctrl;
		
		panelEnviar = new PanelSendMessage();
		panelBtn = new PanelButton(ctrl, panelEnviar);
		
		setSize(400, 500);
		setTitle("Chat Servidor");
		setLayout(new BorderLayout());
		setResizable(true);
		setLocationRelativeTo(null);
		setBackground(Color.BLUE);

				
		add(panelEnviar, BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.ctrl.conectar(panelEnviar, panelBtn);
			
	}
	
	
	public static void main(String[] args) {
		
		EncryptionServer ventanaChat = new EncryptionServer(new Controller());
		ventanaChat.setVisible(true);
		
	}
	

}
