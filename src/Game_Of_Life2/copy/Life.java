package Game_Of_Life2.copy;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;


public class Life extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	boolean stopped = false;
	grid table_grid = new grid();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Life frame = new Life();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Life.
	 */
	public Life() {
		//initialize the frame
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 776, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		//start the panel
		LifePanel panel = new LifePanel();
		//start the control panel
		LifeControlPanel ControlPanel = new LifeControlPanel(panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
		
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel.get(), GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 543, Short.MAX_VALUE)
					.addComponent(ControlPanel.get(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(ControlPanel.get(), GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel.get(), GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
