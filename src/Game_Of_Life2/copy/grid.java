package Game_Of_Life2.copy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class grid extends GridBase{
	int x;
	int y;
	int[][] grid_matrix;
	int[][] updated_grid_matrix;
	SpecialMath math;
	RuleSet rule;
	//default size is 35 X 35
	public grid(){
		this.x = 35;
		this.y = 35;
	    grid_matrix = new int [35][35]; 
	    updated_grid_matrix = new int [35][35]; 
	    this.rule = rule;
	    math = new SpecialMath(rule);
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
		this.rule = rule;
	    math = new SpecialMath(x,y,rule);

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
		GridLoader loader = new GridLoader();
		copyAnotherGrid(loader.load_it());
		
	}
	public void copyAnotherGrid(grid next){
		for(int i = 0; i < next.getHeight(); i++){
			for(int j = 0; j < next.getHeight(); j++){
				this.setGridCell(i, j, next.getGridCell(i, j));
			}
		}
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
		/*Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any live cell with two or three live neighbours lives, unchanged, to the next generation.
Any dead cell with exactly three live neighbours cells will come to life.

*/
		
		this.clear_update();
		this.fewerThanTwoNeighbors();
		this.moreThanThreeNeighbors();
		this.twoOrThreeNeighbors();
		this.threeNeighbors();
		this.sync();
		this.clear_update();		//just in case
	}
	
	public void fewerThanTwoNeighbors(){
		System.out.println("checking singular point rule");

		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(this.getGridCell(i, j) == 1 && sumOfNeighbors(i,j) < 2){
					System.out.println("neighbor sum" +sumOfNeighbors(i, j) );
						this.setUpdatedGridCell(i, j, 0);
				}
			}
		}
	}
	public void moreThanThreeNeighbors(){
		System.out.println("checking singular point rule");

		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(this.getGridCell(i, j) == 1 && sumOfNeighbors(i,j) > 3){
					System.out.println("neighbor sum" +sumOfNeighbors(i, j) );
						this.setUpdatedGridCell(i, j, 0);
				}
			}
		}
	}
	public void twoOrThreeNeighbors(){
		System.out.println("checking singular point rule");

		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(sumOfNeighbors(i,j)== 3 ||sumOfNeighbors(i,j)== 2  ){
					System.out.println("neighbor sum" +sumOfNeighbors(i, j) );
						this.setUpdatedGridCell(i, j, this.getGridCell(i, j));
				}
			}
		}
	}


	public void threeNeighbors(){
		System.out.println("checking singular point rule");

		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				if(this.getGridCell(i, j) == 0 && sumOfNeighbors(i,j)== 3){
					System.out.println("neighbor sum" +sumOfNeighbors(i, j) );
						this.setUpdatedGridCell(i, j, 1);
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
		return this.getGridCell(math.addOneTo(i), math.addOneTo(j));
	}
	public int getUpperRight(int i, int j){
		return this.getGridCell(math.subtractOneFrom(i), math.addOneTo(j));
	}
	public int getRight(int i, int j){
		return this.getGridCell((i), math.addOneTo(j));
	}
	public int getUp(int i, int j){
		return this.getGridCell(math.addOneTo(i), (j));
	}
	public int getBottom(int i, int j){
		return this.getGridCell(math.subtractOneFrom(i), (j));
	}
	public int getLeft(int i, int j){
		return this.getGridCell((i), math.subtractOneFrom(j));
	}
	public int getBottomLeft(int i, int j){
		return this.getGridCell(math.subtractOneFrom(i), math.subtractOneFrom(j));
	}
	public int getUpperLeft(int i, int j){
		return this.getGridCell(math.addOneTo(i), math.subtractOneFrom(j));
	}


	public void randomize(){
		this.clear_update();
		for(int i = 0; i < this.x; i++){
			for(int j = 0; j < this.y; j++){
				int new_int =  (((int)(Math.random()*5)) % 2);
				System.out.println(new_int);
				this.setUpdatedGridCell(i, j, new_int);
			}
		}
		this.sync();
	}

}
