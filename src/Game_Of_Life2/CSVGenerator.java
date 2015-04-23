package Game_Of_Life2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class CSVGenerator
{
	protected String file_name;
	private grid G;
   public CSVGenerator(String name, grid G)
   {
	   this.file_name = name + ".csv";
	   this.G = G;
	   this.generateCsvFile();
	   
   }
 
   private void generateCsvFile()
   {
	   File file = new File(file_name);
	   if(file.exists()){
		   file.delete();
	   }
	try
	{
	    FileWriter writer = new FileWriter(file_name);
 
 
	    for(int i = 0 ; i < this.G.getHeight(); i ++){
		    for(int j = 0 ; j < this.G.getWidth(); j ++){

			writer.append(G.getGridCell(i, j) + "");
			if(j != G.getWidth() -1){
				writer.append(',');
			}

		    }writer.append('\n');
		}
	    
	    //generate whatever data you want
 
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
		System.err.println("Oh ohhh");
	     e.printStackTrace();
	} 
    }
}
