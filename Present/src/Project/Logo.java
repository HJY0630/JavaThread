package Project;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Logo extends JPanel implements Runnable {

	int second, weight, height;

	ImageIcon imageicon = new ImageIcon("images/whitelogo.png");
	Image img = imageicon.getImage();

	public Logo(JPanel paenl) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, weight, height, this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				second = Calendar.getInstance().get(Calendar.SECOND);
				iconsize(second);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void iconsize(int s) {
		weight = second * 10;
		height = second * 5;
		return;
	}
}