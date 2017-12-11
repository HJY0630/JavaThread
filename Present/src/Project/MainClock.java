package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Project.SnowObject;
import Project.SnowPanel;

public class MainClock extends JFrame {

	private static final int SNOWS = 100;
	private static final int SNOW_SIZE = 20;
	Container ct;
	int width = 1920, height = 1080;
	JPanel datepanel, timepanel, daypanel, logopanel;
	Font DateFont = new Font("굴림", Font.BOLD, 28);
	Font ClassFont = new Font("바탕", Font.BOLD, 50);
	ArrayList<SnowObject> snowList = new ArrayList<SnowObject>();
	SnowPanel sp;

	public MainClock() {
		this.setTitle("자바 마지막 조별과제");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ct = this.getContentPane();
		ct.setLayout(null);
		ct.setBackground(Color.BLACK);

		generateSnow();

		AnalogClockPanel Clockpanel = new AnalogClockPanel();
		Thread Clockth = new Thread(Clockpanel);
		Clockth.start();
		Clockpanel.setBounds(150, 90, 900, 900);
		Clockpanel.setOpaque(false);

		Datepanel date = new Datepanel(datepanel);
		Thread dateth = new Thread(date);
		dateth.start();
		date.setBounds(1150, 90, 620, 50);

		date.setFont(DateFont);
		date.setOpaque(false);
		Time time = new Time(timepanel);
		Thread timeth = new Thread(time);
		timeth.start();
		time.setBounds(1150, 140, 620, 74);

		time.setFont(ClassFont);
		time.setOpaque(false);
		Day day = new Day(daypanel);
		Thread dayth = new Thread(day);
		dayth.start();
		day.setBounds(1150, 214, 620, 50);

		day.setFont(DateFont);
		day.setOpaque(false);
		Logo logo = new Logo(logopanel);

		Thread logoth = new Thread(logo);
		logoth.start();
		logo.setBounds(1150, 654, 620, 336);
		logo.setOpaque(false);
		JLabel title = new JLabel("강의 안내");
		title.setBounds(0, 0, 620, 70);
		title.setFont(ClassFont);
		this.setForeground(Color.WHITE);

		TimeTablePanel ttp = new TimeTablePanel();
		Thread ttpth = new Thread(ttp);
		ttpth.start();
		ttp.setBounds(1150, 300, 620, 335);

		ttp.setFont(DateFont);
		ttp.add(title);

		ttp.setOpaque(false);
		sp = new SnowPanel(snowList);
		Thread spth = new Thread(sp);
		spth.start();
		sp.setBounds(0, 0, 1920, 1080);
		sp.setOpaque(false);

		ct.add(sp);
		ct.add(Clockpanel);
		ct.add(date);
		ct.add(time);
		ct.add(day);
		ct.add(logo);
		ct.add(ttp);

		this.setVisible(true);
		Insets inset = this.getInsets();
		this.setSize(width + inset.left + inset.right, height + inset.top + inset.bottom);
	}

	private void generateSnow() {
		for (int i = 0; i < SNOWS; i++) {

			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);

			Point point = new Point(x, y);
			SnowObject so = new SnowObject(point, SNOW_SIZE);
			snowList.add(so);
		}
	}

	public static void main(String[] args) {
		new MainClock();
	}
}