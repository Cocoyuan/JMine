package JMine;

import javax.swing.*;

public class JMineButton extends JButton {
	private int col;
	private int row;
	private int flag=0;
	private boolean clickFlag = false;
	JMineButton(int row, int col, ImageIcon icon) {
		super(icon);
		this.row = row;
        	this.col = col;
	}
	public boolean getClickFlag () {
		return(clickFlag);
	}
	public void setClickFlag(boolean toSet) {
		clickFlag = toSet;
	}
	public int getCol() {
		return(col);
	}
	public int getRow(){
		return(row);
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFlag() {
		return(flag);
	}
}
