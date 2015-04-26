package Game_Of_Life2.copy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.SwingWorker;

public class LifeControlPanel extends JLayeredPane{
	LifePanel panel;
	public LifeControlPanel(LifePanel panel){
		new JLayeredPane();
		this.panel = panel;
		JButton j_start = new JButton("Start");
		j_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setStopped(false);
				j_start.setText("Started");
				j_start.setBackground(Color.white);
				SwingWorker worker = new SwingWorker<Void, Void>() {
					   @Override
					   protected Void doInBackground() throws Exception {
					     while(panel.getStopped() == false){
					    	 	panel.next_step();
								//System.out.println(table_grid.toString());
								//Slow down the game, too efficient? 
					            try {
					            	Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					     }
					      return null;
					   }
					};
					worker.execute();
			}
		});
		j_start.setBounds(0, 0, 117, 29);
		this.add(j_start);
		
		JButton j_stop = new JButton("Stop");
		j_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setStopped(true);
			}
		});


		j_stop.setBounds(0, 24, 117, 29);
		this.add(j_stop);
		
		JButton j_clear = new JButton("Clear");
		j_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clear();
			}
		});

		j_clear.setBounds(0, 51, 117, 29);
		this.add(j_clear);
		
		JButton j_save = new JButton("Save");
		j_save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.saveGrid();
				}
			});

		j_save.setBounds(0, 76, 117, 29);
		this.add(j_save);
		
		JButton j_load = new JButton("Load");
		j_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.loadGrid();
			}
		});
		j_load.setBounds(0, 101, 117, 29);
		this.add(j_load);
		
		JButton j_random = new JButton("Random");
		j_random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.randomizeGrid();
			}
		});
		j_random.setBounds(0, 127, 117, 29);
		this.add(j_random);
		
		JButton j_next = new JButton("Next Step");
		j_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j_next.setText("Nexted");
				j_next.setBackground(Color.white);
				panel.next_step();
			}
		});

		j_next.setBounds(0, 152, 117, 29);
		this.add(j_next);

		
	}
	
	public JLayeredPane get(){
		return this;
	}
}
