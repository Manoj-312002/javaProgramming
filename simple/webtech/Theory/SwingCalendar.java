package webtech.Theory;

import java.awt.*;
import java.awt.event.*	;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;


class DatePicker {
	
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

	JLabel l = new JLabel("", JLabel.CENTER);
	JTextArea area = new JTextArea( 5, 50);
	
	String day = "" + java.util.Calendar.getInstance().get(java.util.Calendar.DATE);


	JFrame d;
	JButton[] button = new JButton[49];

	Map<String,String> mp = new HashMap<>();

	public static void btdesign( JButton bt ){
		bt.setFocusPainted(false);	
		bt.setBackground(Color.black);
		bt.setForeground(Color.white);
		bt.setBorder( BorderFactory.createEmptyBorder() );
		bt.setMargin(new Insets(10,10,10,10));
		bt.setFont( new Font("Verdana", Font.BOLD, 16) );
	}

	public DatePicker() {
		
		d = new JFrame();
		d.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		d.setTitle("Calendar");

		l.setFont(new Font("Verdana", Font.BOLD, 16) );
		
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		

		// The calendar
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(600, 500));
		p1.setBackground(Color.black);
		
		for (int x = 0; x < button.length; x++) {
			
			final int selection = x;
			button[x] = new JButton();
			btdesign( button[x] );
				
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setBackground(Color.DARK_GRAY);
			}else{
				button[x].addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						
						java.util.Calendar cal = java.util.Calendar.getInstance();
						cal.set(year, month, 1);
						int xy = cal.get(java.util.Calendar.DAY_OF_WEEK) + 5;

						button[Integer.parseInt(day) + xy].setBackground(Color.black);
						day = button[selection].getActionCommand();
						button[Integer.parseInt(day) + xy].setBackground(Color.darkGray);

						var x = mp.get( "" + day + month + year );
						
						if( x != null ) area.setText(x);
						else area.setText("");
						
					}
				});
			}

			p1.add(button[x]);
		}

		// The title and moving month
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		p2.setPreferredSize(new Dimension(100, 50));
		
		JButton previous = new JButton("<");
		btdesign( previous );

		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});

		p2.add(previous);
		p2.add(l);

		JButton next = new JButton(">");
		btdesign( next );
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);


		// The bottom for adding event
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		p3.setPreferredSize(new Dimension(100, 100));

		JButton ch = new JButton("Change");
		btdesign(ch);
		ch.setBackground(Color.lightGray); ch.setForeground(Color.black);
		ch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				mp.put( "" + day + month + year , area.getText() );
			}
		});

		area.setFont( new Font("Verdana", Font.BOLD, 16) );
		area.setColumns(10);
		area.setMargin(new Insets(10,10,10,10));

		p3.add(area);
		p3.add(ch);





		// Total layout
		d.add(p2, BorderLayout.NORTH);
		d.add(p1, BorderLayout.CENTER);
		d.add(p3, BorderLayout.SOUTH);

		
		d.pack();
		displayDate();

		// Make today gray
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int xy = cal.get(java.util.Calendar.DAY_OF_WEEK) + 5;
		button[ Integer.parseInt(day) + xy ].setBackground(Color.darkGray);

		d.setVisible(true);
	}

	
	public void displayDate() {

		for (int x = 7; x < button.length; x++){
			button[x].setText("");
			button[x].setBackground(Color.black);
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat( "MMMM yyyy" );
		java.util.Calendar cal = java.util.Calendar.getInstance();

		cal.set(year, month, 1);
		
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
	}
}

class SwingCalendar {
	public static void main(String[] args) {
		new DatePicker();	
	}
}