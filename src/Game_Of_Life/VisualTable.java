package Game_Of_Life;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class VisualTable extends JTable {
	VisualTable table;
	public VisualTable(){
		this.table = new VisualTable(35,35);
	}
	
	public VisualTable(int i, int j) {
		this.table = new VisualTable(35,35);
		this.table.setCellSelectionEnabled(false);
		this.table.setColumnSelectionAllowed(false);
		this.table.setFillsViewportHeight(true);
		this.table.setRowHeight(20);
		this.table.setGridColor(Color.BLACK);
		
		this.table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			      VisualTable target = (VisualTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      target.setValueAt(1, row, column);
			      
			      /*try {
			    	    Thread.sleep(1000);                 //1000 milliseconds is one second.
			    	} catch(InterruptedException ex) {
			    	    Thread.currentThread().interrupt();
			    	}*/
	
			      System.out.println("row selected" + row);
			      System.out.println("column selected" + column);
	
			      // do some action if appropriate column
			    
			  }
			});
	}

	public VisualTable getTable(){
		return this;
	}
	

}
