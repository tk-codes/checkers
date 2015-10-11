import javax.swing.*;
import View.BoardPanel;

/**
 * Client Application -> Main
 * @author Keerthikan
 * 
 * Main
 */
public class Main {
	
	public static void main(String[] args) {
		ClientApp client = new ClientApp();
		client.pack();
		client.setVisible(true);
		client.setLocation(250, 150);
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
