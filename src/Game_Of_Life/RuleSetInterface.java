package Game_Of_Life;

public interface RuleSetInterface {

	public abstract void ApplyRule(GridBase grid);
	public abstract void setWrap(boolean wrap);

}
