package Game_Of_Life;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class grid extends GridBase{
	int x;
	int y;
	int[][] grid_matrix;
	int[][] updated_grid_matrix;

	//default size is 35 X 35
	public grid(){
		this.x = 35;
		this.y = 35;
	    grid_matrix = new int [35][35]; 
	    updated_grid_matrix = new int [35][35]; 

		for(int i = 0; i <35; i++){
			for(int j = 0; j < 35; j++){
				grid_matrix[i][j] = 0;
				updated_grid_matrix[i][j] = 0;
			}
		}
	}
	//create method to create grid with whatever size
	public grid(int x, int y){
		this.x = x;
		this.y = y;
		grid_matrix = new int [x][y]; 
		updated_grid_matrix = new int [x][y]; 

		for(int i = 0; i <x; i++){
			for(int j = 0; j < y; j++){
				grid_matrix[i][j] = 0;
				updated_grid_matrix[i][j] = 0;

			}
		}

	}
	
	public int getX() {
		return x;
	}
	public int getWidth() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int getGridCell(int x, int y){
		return grid_matrix[x][y];
	}
	public int getUpdatedGridCell(int x, int y){
		return updated_grid_matrix[x][y];
	}

	public String toString(){
		String s = "";
		for(int i = 0; i <this.getX(); i++){
			for(int j = 0; j < this.getY(); j++){
				s = s + " " +grid_matrix[i][j];
			}
			//new line
			s = s + "\n";
		}
		return s;
	}
	@Override
	public void setGridCell(int x, int y, int value) {
		// TODO Auto-generated method stub
		this.grid_matrix[x][y] = value;
	}
	public void setUpdatedGridCell(int x, int y, int value) {
		// TODO Auto-generated method stub
		this.updated_grid_matrix[x][y] = value;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i <x; i++){
			for(int j = 0; j < y; j++){
				grid_matrix[i][j] = 0;
			}
		}

	}
	public void clear_update() {
		// TODO Auto-generated method stub
		for(int i = 0; i <x; i++){
			for(int j = 0; j < y; j++){
				updated_grid_matrix[i][j] = 0;
			}
		}

	}

	@Override
	public void load(String filename, boolean clear) {
		// TODO Auto-generated method stub
		//thanks:  http://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
		String csvFile = "my_grid_csv.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
			 
			br = new BufferedReader(new FileReader(csvFile));
			int row = 0;
			this.clear();
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] csv_line = line.split(cvsSplitBy);
				for(int x = 0; x< csv_line.length; x++){
					this.setGridCell(row, x, Integer.parseInt(csv_line[x]));
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
		System.out.println(this.toString());
		System.out.println("Done");

		
	}
	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub
		CSVGenerator csv = new CSVGenerator(filename, this);
	}
	public void sync(){
		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				grid_matrix[i][j] = updated_grid_matrix[i][j];

			}
		}
	}
	
	public void update(){
		this.clear_update();
		checkSpaceShip();
		checkRuleBox();
		singularPointBox();
		sync();
		//do not clear the update grid. causing bug
//		this.clear_update();
	}
	public boolean isSpaceShipNearby(int i, int j){
		if(sumOfNeighbors(i, j) == 4 && sumOfNeighbors(i, plus(j)) == 4){
			return true;
		}else if(sumOfNeighbors(i, j) == 5 && sumOfNeighbors(i, plus(j)) == 1){
			return true;
		}else if(sumOfNeighbors(i, j) == 5 && sumOfNeighbors(i, plus(j)) == 3 && sumOfNeighbors(i, minus(j)) == 1){
			return true;
		}else if(sumOfNeighbors(i, j) == 5 && sumOfNeighbors(minus(i), minus(j)) == 2 && sumOfNeighbors(i, minus(j)) == 3){
			return true;
		}else if(sumOfNeighbors(i, j) == 4 && sumOfNeighbors((i), plus(j)) == 4 && sumOfNeighbors(plus(i), plusTwo(j)) == 2){
			return true;
		}else if(sumOfNeighbors(i, j) == 3 && sumOfNeighbors(minus(i), minus(j)) == 4){
			return true;
		}else if(sumOfNeighbors(i, j) == 5 && sumOfNeighbors(minus(i), minus(j)) == 1&& sumOfNeighbors((i), plus(j)) == 3){
			return true;
		}else if(sumOfNeighbors(i, j) == 2 && sumOfNeighbors(minus(i), minus(j)) == 1 && sumOfNeighbors((i), plus(j)) == 2){
			return true;
		}else{
			return false;
		}
		
	}
	public void checkSpaceShip(){
		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				//find interesting points
				if(sumOfNeighbors(i, j) ==2){
					if((getGridCell(minus(i), j) == 1) && (getGridCell(minusTwo(i), j) == 1) && (getGridCell((i), minus(j)) == 1) && (getGridCell(minus(i), minusTwo(j)) == 1)){
						setUpdatedGridCell(i, j, 1);
						setUpdatedGridCell(minus(i), j, 1);
						setUpdatedGridCell(minus(i), plus(j), 1);
						setUpdatedGridCell(i, minus(j), 1);
						setUpdatedGridCell(minusTwo(i), minus(j), 1);
						setUpdatedGridCell(minus(i), minus(j), 0);
						setUpdatedGridCell((i), minusTwo(j), 0);

						//setUpdatedGridCell(minus(i), minus(j), 0);

					}else if((getGridCell((i), (j)) == 1) && (getGridCell(minus(i), j) == 1) && (getGridCell((i), minus(j)) == 1) && (getGridCell((i), minusTwo(j)) == 1) && (getGridCell(minusTwo(i), minus(j)) == 1)){
						setUpdatedGridCell(i, j, 1);
						setUpdatedGridCell(minus(i), j, 1);
						setUpdatedGridCell(minus(i), minus(j), 0);
						setUpdatedGridCell(i, minus(j), 1);
						setUpdatedGridCell(i, minusTwo(j), 0);
						setUpdatedGridCell(minus(i), minusTwo(j), 1);
						setUpdatedGridCell(plus(i), minus(j), 1);
						setUpdatedGridCell(minusTwo(i), minus(j), 0);

					}else if((getGridCell((i), (j)) == 1) && (getGridCell(minus(i), j) == 1) && (getGridCell(minusTwo(i), minus(j)) == 1) && (getGridCell(minusTwo(i), plus(j)) == 1) && (getGridCell(minus(i), plus(j)) == 1)){
						setUpdatedGridCell(i, j, 1);
						setUpdatedGridCell((i), plus(j), 1);
						setUpdatedGridCell(minus(i), plus(j), 1);
						setUpdatedGridCell(minusTwo(i), plus(j), 1);
						setUpdatedGridCell(minus(i), (j), 0);
						setUpdatedGridCell(minusTwo(i), (j), 0);
						setUpdatedGridCell(minusTwo(i), minus(j), 0);
						setUpdatedGridCell(minus(i), minus(j), 1);
						setUpdatedGridCell((i), minus(j), 0);
					}
				}else if(sumOfNeighbors(i, j) ==3){
					//low down step 3 glider
					if((getGridCell((i), j) == 1) && (getGridCell((i), minus(j)) == 1) && (getGridCell(minus(i), (j)) == 1) && (getGridCell(minusTwo(i), minus(j)) == 1)&& (getGridCell(minus(i), plus(j)) == 1)){
						setUpdatedGridCell(i, j, 1);
						setUpdatedGridCell(minus(i), j, 0);
						setUpdatedGridCell((i), plus(j), 1);
						setUpdatedGridCell(i, minus(j), 1);
						setUpdatedGridCell(minusTwo(i), (j), 1);
						setUpdatedGridCell(minus(i), minus(j), 0);
						setUpdatedGridCell(minusTwo(i), minus(j), 0);
						setUpdatedGridCell(minus(i), plus(j), 1);
						setUpdatedGridCell(minusTwo(i), plus(j), 0);

					}
				}
				
			}
		}

		
	}
	
	public void singularPointBox(){
		System.out.println("checking singular point rule");

		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(this.getGridCell(i, j) == 1){
					System.out.println("neighbor sum" +sumOfNeighbors(i, j) );
					if(sumOfNeighbors(i, j) == 0){
						this.setUpdatedGridCell(i, j, 0);
					}
				}
			}
		}
	}
	public int sumOfNeighbors(int i, int j){
		return getLowerRight( i,  j)  + getUpperRight( i,  j) + getRight( i,  j)  + getUp( i,  j) + getBottom( i,  j) + 
				getBottomLeft( i,  j) + getLeft( i,  j) +  getUpperLeft( i,  j);
	}
	public boolean doesItHaveOneGoodNeighbor(int i, int j){
		System.out.println(getLowerRight( i,  j)  + getUpperRight( i,  j) + getRight( i,  j)  + getUp( i,  j) + getBottom( i,  j) + 
				getBottomLeft( i,  j) + getLeft( i,  j) +  getUpperLeft( i,  j));
		return getLowerRight( i,  j) == 1 ||
			   getUpperRight( i,  j) == 1 ||
			   getRight( i,  j) == 1 ||
			   getUp( i,  j) == 1 || 
			   getBottom( i,  j)== 1 ||
			   getBottomLeft( i,  j) == 1||
			   getLeft( i,  j) == 1||
			   getUpperLeft( i,  j) == 1;
	}
	public int getLowerRight(int i, int j){
		return this.getGridCell(addOneTo(i), addOneTo(j));
	}
	public int getUpperRight(int i, int j){
		return this.getGridCell(subtractOneFrom(i), addOneTo(j));
	}
	public int getRight(int i, int j){
		return this.getGridCell((i), addOneTo(j));
	}
	public int getUp(int i, int j){
		return this.getGridCell(addOneTo(i), (j));
	}
	public int getBottom(int i, int j){
		return this.getGridCell(subtractOneFrom(i), (j));
	}
	public int getLeft(int i, int j){
		return this.getGridCell((i), subtractOneFrom(j));
	}
	public int getBottomLeft(int i, int j){
		return this.getGridCell(subtractOneFrom(i), subtractOneFrom(j));
	}
	public int getUpperLeft(int i, int j){
		return this.getGridCell(addOneTo(i), subtractOneFrom(j));
	}





	public void checkRuleBox(){
		System.out.println("checking rule box");
		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(this.getGridCell(i, j) == 0 && !this.isSpaceShipNearby(i, j)){
					if(this.getGridCell(subtractOneFrom(i), subtractOneFrom(j)) == 1 && this.getGridCell((i), subtractOneFrom(j)) == 1 && this.getGridCell(subtractOneFrom(i), (j)) == 1&& this.getGridCell((i), subtractOneFrom(j)) == 1){
						this.setUpdatedGridCell(i, j, 1);
						this.setUpdatedGridCell(minus(i), j, 1);
						this.setUpdatedGridCell(minus(i), minus(j), 1);
						this.setUpdatedGridCell((i), minus(j), 1);
					}else if(this.getGridCell(addOneTo(i), addOneTo(j)) == 1 && this.getGridCell((i), addOneTo(j)) == 1 && this.getGridCell(addOneTo(i), (j)) == 1){
						this.setUpdatedGridCell(i, j, 1);
						this.setUpdatedGridCell(plus(i), j, 1);
						this.setUpdatedGridCell(plus(i), plus(j), 1);
						this.setUpdatedGridCell((i), plus(j), 1);
					}else if(this.getGridCell(subtractOneFrom(i), addOneTo(j)) == 1 && this.getGridCell(subtractOneFrom(i), (j)) == 1 && this.getGridCell((i), addOneTo(j)) == 1){
						this.setUpdatedGridCell(i, j, 1);
						this.setUpdatedGridCell(minus(i), j, 1);
						this.setUpdatedGridCell(minus(i), plus(j), 1);
						this.setUpdatedGridCell((i), plus(j), 1);
					}else if(this.getGridCell((i), subtractOneFrom(j)) == 1 && this.getGridCell(addOneTo(i), subtractOneFrom(j)) == 1 && this.getGridCell(addOneTo(i), (j)) == 1){
						this.setUpdatedGridCell(i, j, 1);
						this.setUpdatedGridCell(plus(i), j, 1);
						this.setUpdatedGridCell(plus(i), minus(j), 1);
						this.setUpdatedGridCell((i), minus(j), 1);
					}
				}

			}
		}
	}
	
	public int subtractOneFrom(int sub){
		if(sub == 0){
			return 34;
		}else{
			return sub-1;
		}
	}
	public int addOneTo(int add){
		if(add == 34){
			return 0;
		}else{
			return add+1;
		}
	}

	
	public int minus(int sub){
		if(sub == 0){
			return 34;
		}else{
			return sub-1;
		}
	}
	public int plus(int add){
		if(add == 34){
			return 0;
		}else{
			return add+1;
		}
	}

	public int minusTwo(int sub){
		if(sub == 0){
			return 33;
		}else if(sub ==1){
			return 34;
		}else{
			return sub-2;
		}
	}
	public int plusTwo(int add){
		if(add == 33){
			return 0;
		}else if(add == 34){
			return 1;
		}else{
			return add+2;
		}
	}

	
}
