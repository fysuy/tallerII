package PresentacionCliente;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelCentral extends JPanel{

	private JPanel pan;
	public PanelCentral() {
		PanelCentralInicio panelCentralInicio = new PanelCentralInicio();
		this.setLayout(new BorderLayout());
		this.add(panelCentralInicio, BorderLayout.CENTER);
	}
	
	public void setPanel(int i) {
		pan=null;
		this.removeAll();
		switch (i){
			case 1:
				//
				break;
			case 2:
				
				break;					
		} 
		
		this.add(pan, BorderLayout.CENTER);
		this.revalidate();
	}
	
}
