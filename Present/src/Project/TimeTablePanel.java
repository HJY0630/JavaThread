package Project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

public class TimeTablePanel extends JPanel implements Runnable {

	String result;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int min = Calendar.getInstance().get(Calendar.MINUTE);
		int time = ((hour - 9) * 60 + min) / 30;
		g.setColor(Color.WHITE);
		
		if (day >= 2 && day <= 6 && time >= 0 && time <= 20) {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + time;
				String[] sb = TimeTable.sb[i][j];
				result = ((i + 1) + "학년 : " + sb[0] + "   " + sb[1] + "  " + sb[2]);
				if (i == 0) {
					g.drawString(result, 10, 145);
				} else {
					g.drawString(result, 10, ((i + 1) * 55) + 90);
				}
			}

		} else {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + time;
				String[] sb = TimeTable.sb[i][j];
				result = ((i + 1) + "수업 종료");
				if (i == 0) {
					g.drawString(result, 10, 145);
				} else {
					g.drawString(result, 10, ((i + 1) * 55) + 90);
				}
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
