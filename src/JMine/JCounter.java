package JMine;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//图形计数器JCounter三位
class JCounter extends JPanel {
	private ImageIcon [] numSet = { new ImageIcon("c0.gif"), new ImageIcon("c1.gif"),
					     new ImageIcon("c2.gif"), new ImageIcon("c3.gif"),
					     new ImageIcon("c4.gif"), new ImageIcon("c5.gif"),
					     new ImageIcon("c6.gif"), new ImageIcon("c7.gif"),
					     new ImageIcon("c8.gif"), new ImageIcon("c9.gif"),
					};
	
	private JButton [] counter = { new JButton(numSet[0]), new JButton(numSet[0]), new JButton(numSet[0])};
	//private JButton pauseButton;
	private int counterNum;
	private Insets space;
	private TimeCounterThread timerThread;

	public JCounter() {
		this(0);
	}

	public JCounter(int num) {
		super();
		setSize(23, 39);
		
		space = new Insets(0,0,0,0);
		this.counterNum = num;
		for (int i=0; i< 3; i++){
			counter[i].setSize(13,23);
			counter[i].setMargin(space);
			add(counter[i]);
		}		
		this.setVisible(true); 
		resetImage();         
	}
	
	public int getCounterNum() {	
		return(counterNum);
	}
	
	private void setCounterNum(int num){
		this.counterNum = num;
	}
	
	private void resetImage() {
		int ones, tens, hundreds;
		ones = counterNum % 10 ;
		tens = counterNum % 100/10;
		hundreds = (counterNum) % 1000/100;
		this.counter[0].setIcon(numSet[hundreds]);
		this.counter[1].setIcon(numSet[tens]);
		this.counter[2].setIcon(numSet[ones]);
	}
	
	public void resetCounter(int num) {
		setCounterNum(num);
		resetImage();
		this.repaint();
	}

	
	//public ActionListener buttonPauseListener = new ActionListener() {
		
		//@Override
		//public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//timerThread.stop();
			
		//}
	//};
	public void stopCounter(){
		
	}
	
	public void continueCounter(){
		
	}
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("Test");
		jf.setSize(23,39);
		JCounter jc = new JCounter();
		jf.setContentPane(jc);
		jf.show();
		
		
		jc.resetCounter(394);
		
	}
	
	
}
