import javax.swing.*;
import java.awt.*;

public class BorderButton{
	public static void main(String[] args){
		BorderButton bb = new BorderButton();
		bb.setUp();
	}

	public void setUp(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton button1 = new JButton("button No.1");
		JButton button2 = new JButton("button No.2");
		JButton button3 = new JButton("button No.3");
		JButton button4 = new JButton("hahahahahahaha button No.4");
		JButton button5 = new JButton("button No.5");

		Font font = new Font("serif", Font.BOLD, 28);
		button1.setFont(font);

		frame.getContentPane().add(BorderLayout.SOUTH, button1);
		frame.getContentPane().add(BorderLayout.NORTH, button2);
		//frame.getContentPane().add(BorderLayout.CENTER, button3);
		//frame.getContentPane().add(BorderLayout.WEST, button4);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		panel.add(button5);
		panel.add(button4);
		panel.add(button3);
		//panel.getAccessibleContext(button);
		frame.setSize(200, 200);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}