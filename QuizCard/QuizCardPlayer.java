import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer{
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;

	public static void main (String[] args) {
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.start();
	}

	public void start(){
		frame = new JFrame("Quiz Card Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		display = new JTextArea(10, 20); //(int row, int column)
		display.setLineWrap(true);
		//question.setWrapStyleWord(true);
		display.setFont(bigFont);
		display.setEditable(false);

		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// answer = new JTextArea(6, 20);
		// answer.setLineWrap(true);
		// answer.setWrapStyleWord(true);
		// answer.setFont(bigFont);

		// JScrollPane aScroller = new JScrollPane(answer);
		// aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");

		// cardList = new ArrayList<QuizCard>();

		// JLabel qLable = new JLabel("Question:");
		// JLabel aLable = new JLabel("Answer:");

		// mainPanel.add(qLable);
		mainPanel.add(qScroller);
		// mainPanel.add(aLable);
		// mainPanel.add(aScroller);
		mainPanel.add(nextButton);

		nextButton.addActionListener(new NextCardListener());
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		// JMenuItem saveMenuItem = new JMenuItem("Save");
		loadMenuItem.addActionListener(new OpenMenuListener());

		// saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(loadMenuItem);
		// fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			if (isShowAnswer) {
				// show the answer because they’ve seen the question
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			} else {
				// show the next question
				if (currentCardIndex < cardList.size()) {
					showNextCard();
				} else {
					// there are no more cards!
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}  
			}
		}
	}

	public class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}

	public void loadFile(File file){
		cardList = new ArrayList<QuizCard>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!=null){
				makeCard(line);
			}
			reader.close();
		}catch(Exception ex){
			System.out.println("Couldn't read this card file");
			ex.printStackTrace();
		}
		showNextCard();
	}

	private void makeCard(String lineToParse){
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}

	private void showNextCard(){
		System.out.println("Current card index is: " + currentCardIndex);
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
}