import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui1B{
	JFrame frame;
	JButton button1;
	JButton button2;
	JLabel label;

	public static void main(String[] args){
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		button1 = new JButton("Click Me!");
		button2 = new JButton("click me!");

		label = new JLabel("Nothing");

		//register this listener with button
		button1.addActionListener(new Button1Listener());
		button2.addActionListener(new Button2Listener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(BorderLayout.WEST, button1);
		frame.getContentPane().add(BorderLayout.SOUTH, button2);
		frame.getContentPane().add(BorderLayout.CENTER, label);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class Button1Listener implements ActionListener {
		//implement the actionPerform event
		public void actionPerformed(ActionEvent event){
			label.setText("Happy Birthday!");
		}
	}

	class Button2Listener implements ActionListener {
		//implement the actionPerform event
		public void actionPerformed(ActionEvent event){
			label.setText("Happy Easter!");
		}
	}
}