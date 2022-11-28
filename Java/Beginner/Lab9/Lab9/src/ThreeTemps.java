// File: ThreeTemps.java
// Author:
// Description: A simple GUI that implements a slider, along with several images
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class ThreeTemps extends JFrame {
// Instance Fields
	private JPanel panel;
	private JLabel fL;
	private JLabel cL;
	private JLabel kL;
	private JTextField fTF;
	private JTextField cTF;
	private JSlider slider;
	private ImageIcon image;
	private JLabel imageLabel;
	private final int WINDOW_WIDTH = 250;
	private final int WINDOW_HEIGHT = 400;
// constructor
public ThreeTemps() {
setTitle("Three Temps");
// Specify what happens when the close button is clicked.
setDefaultCloseOperation(EXIT_ON_CLOSE);
// Build the panel that contains the other components.
buildPanel();
// Add the panel to the content pane.
add(panel);
// Size and display the window.
setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
setVisible(true);
}
// the method that instantiates the components
private void buildPanel() {
fL = new JLabel("F");
cL = new JLabel("C");
kL = new JLabel("K");
// Create text fields
fTF = new JTextField(20);
fTF.setText("-459.67");
fTF.setEditable(false);
cTF = new JTextField(20);
cTF.setText("-273.15");
cTF.setEditable(false);
// create a slider
slider = new JSlider(JSlider.HORIZONTAL,0,500,0);
slider.setMajorTickSpacing(200);
slider.setMinorTickSpacing(20);
slider.setPaintTicks(true);
slider.setPaintLabels(true);
slider.addChangeListener(new SliderListener());
// create an image icon
image = new ImageIcon("frozen.jpg");
imageLabel = new JLabel();
imageLabel.setIcon(image);
// Create a panel
panel = new JPanel();
// Add the components to the panel
panel.add(fL);
panel.add(fTF);
panel.add(cL);
panel.add(cTF);
panel.add(kL);
panel.add(slider);
panel.add(imageLabel);
}
private class SliderListener implements ChangeListener {
public void stateChanged(ChangeEvent e) {
// declare variable to hold conversion	
	double k,f,c = 0.0;
	double multiplier = .555555556;
// retrieve value from the slider	
	k = slider.getValue();
	f = (k-273.15)* 1.8 + 32;
	c = (f - 32.0);
	c*= multiplier;
// set the celsius and fahrenheit text fields
	fTF.setText(Double.toString(f));
	cTF.setText(Double.toString(c));
// based on the temperature, select which image
// should be placed into the imageLabel
	if (c < -100) {
		image = new ImageIcon("frozen.jpg");
		imageLabel.setIcon(image);
	} else if (c>-100 && f<=-34) {
		image = new ImageIcon("cold.jpg");
		imageLabel.setIcon(image);
	} else if (k>400) {
		image = new ImageIcon("hot.jpg");
		imageLabel.setIcon(image);
	} else if (f>100 && f<330) {
		image = new ImageIcon("warm.gif");
		imageLabel.setIcon(image);
	}
}
}
// main routine
public static void main(String[] args) {
	ThreeTemps x = new ThreeTemps();
}
}
