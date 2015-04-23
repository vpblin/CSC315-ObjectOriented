package Game_Of_Life2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class GridLoader {
	//we can hide my_grid here
	private grid my_grid;
	
	public GridLoader(){
		my_grid = new grid();
		// TODO Auto-generated method stub
	}
	
	public grid load_it(){
		//thanks:  http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
		JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showOpenDialog(fc);
		
		String csvFile = fc.getName(fc.getSelectedFile());
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
			 
			br = new BufferedReader(new FileReader(csvFile));
			int row = 0;
			this.my_grid.clear();
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] csv_line = line.split(cvsSplitBy);
				for(int x = 0; x< csv_line.length; x++){
					this.my_grid.setGridCell(row, x, Integer.parseInt(csv_line[x]));
				}
				row ++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return this.my_grid;
	}
}
