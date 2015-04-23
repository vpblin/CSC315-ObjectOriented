package Game_Of_Life2;

//class to handle addition and subtraction

public class SpecialMath {
	int max;
	int min;
	RuleSet rule;
	public SpecialMath(RuleSet rule){
		max = 35;
		min = 35;
		this.rule = rule;
	}
	public SpecialMath(int x, int y, RuleSet rule){
		max = x;
		min = y;
		rule = rule;
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
