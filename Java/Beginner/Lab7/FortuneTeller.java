import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class FortuneTeller extends JFrame{

	//Components

	private JPanel panel;
	private JTextField questionText;
	private JButton answerButton;
	
	private final int WIDTH = 360;
	private final int LENGTH = 130;
	
	
	
		public FortuneTeller(){
			setTitle("Fortune Teller");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			BuildPanel();
			add(panel);
			
			//sets window size
			setSize(WIDTH,LENGTH);
			setVisible(true);
		}
	
		private void BuildPanel() {
			//Create a label text field and button 
			JLabel label = new JLabel("Ask me a question!");
			questionText = new JTextField(10);
			answerButton = new JButton("Tell me now!");
			
			//add an action listener to the button
			answerButton.addActionListener(new CalcButtonListener());
			
			//create panel
			panel = new JPanel();
			
			//add the labels text fields and buttons to the panel
			panel.add(questionText);
			panel.add(answerButton);
			
		}
		
		
		
		private class CalcButtonListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				String text = questionText.getText();
				//Limits the text used in the switch case to characters 1-4(0-3)
				String snippit = text.substring(0,4);
				switch (snippit) {
				case "what":
					JOptionPane.showMessageDialog(questionText, "Because thats the way it is");
					break;
				case "when":
					JOptionPane.showMessageDialog(questionText, "Propbably not tomorrow");
					break;
				case "why ":
					JOptionPane.showMessageDialog(questionText, "Because I said so");
				}
				}
			
		}
		
		public static void main(String args[]) {
			FortuneTeller teller = new FortuneTeller();
		}
		
}

