package Game_Of_Life;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;


public class new_class extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					new_class frame = new new_class();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public new_class() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 776, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		

		JLayeredPane layeredPane = new JLayeredPane();
		table = new JTable(35,35);
		table = initiateTable(table);
		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      if(table_grid.getGridCell(row, column) != 1){
				      target.setValueAt(1, row, column);
				      table_grid.setGridCell(row, column, 1);
			      }else{
				      target.setValueAt(0, row, column);
				      table_grid.setGridCell(row, column, 0);
			      }

			      System.out.println("row selected" + row);
			      System.out.println("column selected" + column);

			      // do some action if appropriate column
			    
			  }
			});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent((Component) table, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent((Component) table, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton j_start = new JButton("Start");
		
		j_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					table = next_step(table);
					System.out.println(table_grid.toString());
		            /*try {
						Thread.sleep(4000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/

				
			}
		});
		j_start.setBounds(0, 0, 117, 29);
		layeredPane.add(j_start);
		
		JButton j_stop = new JButton("Stop");
		j_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopped = true;
			}
		});


		j_stop.setBounds(0, 24, 117, 29);
		layeredPane.add(j_stop);
		
		JButton j_clear = new JButton("Clear");
		j_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear(table);
			}
		});

		j_clear.setBounds(0, 51, 117, 29);
		layeredPane.add(j_clear);
		
		JButton j_save = new JButton("Save");
		j_save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveGrid();
				}
			});

		j_save.setBounds(0, 76, 117, 29);
		layeredPane.add(j_save);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGrid();
			}
		});
		btnNewButton.setBounds(0, 101, 117, 29);
		layeredPane.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
	}
	public JTable initiateTable(JTable table){
		table.setCellSelectionEnabled(false);
		table.setColumnSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.setGridColor(Color.BLACK);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
			     	table.setValueAt(0, i, j);
			 }
		 }
		 return table;
	}
	public JTable flashTable(JTable table, int value){		
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
			     	table.setValueAt(value, i, j);
			 }
		 }
		 return table;
	}

	
	public JTable mimicGrid(JTable table){
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
			     	table.setValueAt(table_grid.getGridCell(i, j), i, j);
			 }
		 }
		table.repaint();
		 return table;
	}
	public JTable next_step(JTable table){
		table_grid.update();
		 return mimicGrid(table);
	}

	public JTable clear(JTable table){
		table_grid.clear();
		return mimicGrid(table);
	}
	public void saveGrid(){
		table_grid.save("my_grid_csv");
	}
	public void loadGrid(){
		table_grid.load("my_grid_csv",true);
		mimicGrid(table);
	}
}
