
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FibonacciRecursionGUI extends JFrame {

    // Components
	private JPanel panel;
	private JTextField numb1,numb2;
	private JButton button;
	private JLabel label1,label2;
	private JTextArea display;
	private int numInvocations = 0; 
	private final static int WINDOW_WIDTH = 300; 
	private final static int WINDOW_HEIGHT = 250; 
	
    public FibonacciRecursionGUI() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(WINDOW_HEIGHT,WINDOW_WIDTH);
    	buildPanel();
    	add(panel);
    	setVisible(true);
    }

    // build panel method
    private void buildPanel() {
    	button = new JButton("Calculate Fibonacci");
    	button.addActionListener(new ButtonListener());
    	label1 = new JLabel("Which Fibonacci Number:");
    	label2 = new JLabel("The fibonacci Number: ");
    	numb1 = new JTextField(5);
    	numb2 = new JTextField(5);
    	numb2.setEditable(false);
    	display = new JTextArea(5,15);
    	display.setEditable(false);
    	JScrollPane scroll = new JScrollPane (display, 
    			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  
    	panel = new JPanel();
    	panel.add(label1);
    	panel.add(numb1);
    	panel.add(button);
    	panel.add(label2);
    	panel.add(numb2);
    	panel.add(scroll);
    }

    // fibonacci recursive method
    public int fibonacci(int n) { 
    	display.append("invocation: "+Integer.toString(numInvocations)+"\n");
    	numInvocations++;
    	
    	if (n==0)
    		return 0;
    	if (n==1)
    		return 1;
    	else
    		return (fibonacci(n-1)+fibonacci(n-2));

    }

    // the inner class; the action listener
    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        	numInvocations = 0;
        	display.setText("");
        	String userInput = numb1.getText();
        	int fibNum = fibonacci(Integer.parseInt(userInput));
        	numb2.setText((Integer.toString(fibNum)));
        }
    }

    // the main method
    public static void main(String[] args) {
    	FibonacciRecursionGUI x = new FibonacciRecursionGUI();
    }
}
