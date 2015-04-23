package Game_Of_Life2;

public class RuleSet implements RuleSetInterface{
	boolean wrapper;
	
	public RuleSet(){
		this.wrapper = false;
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

}
