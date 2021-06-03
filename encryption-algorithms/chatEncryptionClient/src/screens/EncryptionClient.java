package screens;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import configuration.Controller;

public class EncryptionClient extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	PanelSend panelSend;
	PanelButton panelBtn;
	Controller ctrl;
	
	public EncryptionClient(Controller ctrl) {
		
		this.ctrl = ctrl;
		
		panelSend = new PanelSend();
		panelBtn = new PanelButton(ctrl, panelSend);
		
		setSize(400, 500);
		setTitle("CLIENTE");
		setLayout(new BorderLayout());
		setResizable(true);
		setLocationRelativeTo(null);
				
		add(panelSend, BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.ctrl.conectar(panelSend, panelBtn);
			
	}
	
	
	public static void main(String[] args) {
		
		EncryptionClient encryptionClient = new EncryptionClient(new Controller());
		encryptionClient.setVisible(true);
		
	}
	

}
