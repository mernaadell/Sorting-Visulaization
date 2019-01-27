package pkjDS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyLilPane extends JPanel {

	private static final long serialVersionUID = 1L;
	public static int rectangles = 0;
	public static int delay = 0;
	public int[] arr = new int[rectangles];
	private String currentOperation = "";
	private String operationDescription = "";
	private double operationRunTime=0;
	

	public MyLilPane() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(512, 512));
		for (int i = 0; i < arr.length; i++) {
		arr[i] = i;
		}
	}

	public static void setUnits(int x) {
		rectangles = x;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Rectangle drawing
		for (int i = 0; i < rectangles; i++) {
			g.setColor(Color.getHSBColor((arr[i] / (float) rectangles), 1, 1));
			int x = (int) Math.floor(i * (getWidth() / (float) rectangles));
			int y = (int) Math.floor(getHeight() - (arr[i] / (float) rectangles) * getHeight()) - 1;
			int width = (int) Math.ceil(getWidth() / (float) rectangles);
			int height = getHeight() - y;
			g.fillRect(x, y, width, height);
		}
		// Text drawing
		int textHeight = g.getFontMetrics().getHeight();
		g.setColor(Color.WHITE);
		g.drawString(currentOperation, 0, textHeight);
		g.setColor(Color.WHITE);
		g.drawString(operationDescription, 0, textHeight * 2);
		g.setColor(Color.WHITE);
		g.drawString(Double.toString(operationRunTime) + " second.",0, textHeight * 3);
	}

	void resetStatistics() {
		currentOperation = "";
		operationDescription = "";
		operationRunTime=0;
	}

	 void setCurrent(String currentOperation,String OperationDescription,Double operationRunTime) {
		this.currentOperation = currentOperation;
		this.operationDescription = OperationDescription;
		this.operationRunTime = operationRunTime;
	}
}