package Project;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Datepanel extends JPanel implements Runnable {

	SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM dd yyyy", Locale.US);
	String a;

	public Datepanel(JPanel panel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString(a, 130, 35);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Date date = new Date();
				a = sdf.format(date);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}