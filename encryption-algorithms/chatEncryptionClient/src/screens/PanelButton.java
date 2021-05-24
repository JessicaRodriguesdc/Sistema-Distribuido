package screens;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import configuration.Controller;

public class PanelButton extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JButton btnEnv;
	Controller ctrl;
	PanelSend panelSend;	
	
	public PanelButton(Controller ctrl, PanelSend panelSend) {
		// TODO Auto-generated constructor stub
		setBorder( new CompoundBorder( new EmptyBorder( 15, 15, 15, 15 ), new TitledBorder("") ) );
		setLayout(new GridLayout(1, 1));
		this.ctrl = ctrl;
		this.panelSend = panelSend;
				
		btnEnv = new JButton("Enviar");
		btnEnv.setActionCommand("enviar");
		btnEnv.addActionListener(this);			
		
		add(btnEnv);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String evento = e.getActionCommand();
		
		switch (evento) {
		case "enviar":
			ctrl.send();
			panelSend.setMessage("");
			
		break;

		default:
			break;
		}
	}
}
