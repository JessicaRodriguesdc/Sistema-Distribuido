package screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import configuration.Controller;

public class EncryptionServer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	PanelSend panelSend;
	PanelButton panelBtn;
	Controller ctrl;
		
	
	public EncryptionServer(Controller ctrl) {
		
		this.ctrl = ctrl;
		
		panelSend = new PanelSend();
		panelBtn = new PanelButton(ctrl, panelSend);
		
		setSize(400, 500);
		setTitle("SERVIDOR");
		setLayout(new BorderLayout());
		setResizable(true);
		setLocationRelativeTo(null);
		setBackground(Color.BLUE);

				
		add(panelSend, BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.ctrl.connect(panelSend, panelBtn);
			
	}
	
	
	public static void main(String[] args) {
		
		EncryptionServer encryptionServer = new EncryptionServer(new Controller());
		encryptionServer.setVisible(true);
		
	}
	

}
