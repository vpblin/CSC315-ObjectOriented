package Game_Of_Life2;

public class ConwayRules implements RuleSetInterface{
	boolean wrapper;
	SpecialMath math;
	int[][] grid_matrix;
	int[][] updated_grid_matrix;
	int x;
	int y;
	public ConwayRules(){
		this.wrapper = false;
	}
	
	public ConwayRules(boolean wrapper, int [][] gridMatrix, int [][] updated_grid_matrix, int x, int y){
		this.wrapper = wrapper;
		this.grid_matrix = grid_matrix;
		this.updated_grid_matrix = updated_grid_matrix;
		this.x = x;
		this.y = y;
	}

	
	public void toggleWrapper(){
		this.wrapper = !wrapper;
	}
	
	public void setWrapperFalse(){
		this.wrapper = false;
	}
	
	public void setWrapperTrue(){
		this.wrapper = true;
	}
	
	@Override
	public void ApplyRule(GridBase grid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWrap(boolean wrap) {
		this.wrapper = wrap;
	}
	
	public GridBase applyConwayRules(GridBase grid){
		fewerThanTwoNeighbors();
		moreThanThreeNeighbors();
		twoOrThreeNeighbors();
		threeNeighbors();
		return grid;
		
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
	
	public void setGridCell(int x, int y, int value) {
		// TODO Auto-generated method stub
		this.grid_matrix[x][y] = value;
	}
	public void setUpdatedGridCell(int x, int y, int value) {
		// TODO Auto-generated method stub
		this.updated_grid_matrix[x][y] = value;
	}

	public int getGridCell(int x, int y){
		return grid_matrix[x][y];
	}
	public int getUpdatedGridCell(int x, int y){
		return updated_grid_matrix[x][y];
	}


}
