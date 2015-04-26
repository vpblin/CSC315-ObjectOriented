package Game_Of_Life2.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTable;

public class LifePanel extends JPanel{
	JPanel panel;
	JTable table;
	grid my_grid;
	boolean stopped;
	public LifePanel(){
		this.panel = new JPanel();
		table = new JTable(35,35);
		table = initiateTable(table);
		panel.add(table);
		table = initiateTable(table);
		my_grid = new grid(35,35);
		this.stopped = false;
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      if(my_grid.getGridCell(row, column) != 1){
				      target.setValueAt("X", row, column);
				      my_grid.setGridCell(row, column, 1);
			      }else{
				      target.setValueAt("", row, column);
				      my_grid.setGridCell(row, column, 0);
			      }
			      System.out.println("row selected" + row);
			      System.out.println("column selected" + column);

			      // do some action if appropriate column    
			  }
			});

		
	}
	
	
	public JTable initiateTable(JTable table){
		table.setCellSelectionEnabled(false);
		table.setColumnSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setRowHeight(20);
		table.setPreferredSize(new Dimension(650, 680));
		table.setGridColor(Color.BLACK);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
			     	table.setValueAt(' ', i, j);
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

	
	public JTable mimicGrid(JTable table, grid table_grid){
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
				 	char a = ' ';
				 	if(my_grid.getGridCell(i, j) ==1){
				 		a = 'X';
				 	}
			     	table.setValueAt(a, i, j);
			 }
		 }
		table.repaint();
		 return table;
	}
	
	public JPanel get(){
		return this.panel;
	}
	
	public JTable mimicGrid(JTable table){
		 for(int i = 0; i < table.getRowCount(); i++){
			 for(int j= 0; j < table.getColumnCount(); j ++){
				 	char a = ' ';
				 	if(my_grid.getGridCell(i, j) ==1){
				 		a = 'X';
				 	}
			     	table.setValueAt(a, i, j);
			 }
		 }
		table.repaint();
		 return table;
	}
	public JTable next_step(){
		my_grid.update();
		 return mimicGrid(table);
	}

	public JTable clear(){
		my_grid.clear();
		return mimicGrid(table);
	}
	public void saveGrid(){
		my_grid.save("my_grid_csv");
	}
	public void loadGrid(){
		my_grid.load("my_grid_csv",true);
		mimicGrid(table);
	}
	public JTable randomizeGrid(){
		my_grid.randomize();
		return mimicGrid(table);
	}
	public void setStopped(boolean s){
		this.stopped = s;
	}
	public boolean getStopped(){
		return this.stopped;
	}


}
