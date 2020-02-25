
public class ComboLock {

	int currentNum = 0;
	int code1 = 0;
	int code2 = 0;
	int code3 = 0;
	int pass1 = 0;
	int pass2 = 0;
	int pass3 = 0;
	int numOfTurns = 0;
	
	public ComboLock (int num1, int num2, int num3) {
		pass1 = num1;
		pass2 = num2;
		pass3 = num3;
		
		
	}
	public void reset() {
		currentNum = 0;
		code1 = 0;
		code2 = 0;
		code3 = 0;
		numOfTurns = 0;
	}
	public void turnLeft(int ticks) {
		int num = 0;
		while (num < ticks) {
			currentNum -= 1;
			if (currentNum == -1) {
				currentNum = 39;
			}
			num++;
		}
		code2 = currentNum;
		numOfTurns++;
		
	}
	public void turnRight(int ticks) {
		int num = 0;
		while (num < ticks) {
			currentNum += 1;
			if (currentNum == 40) {
				currentNum = 0;
			}
			num++;
		}
		if (numOfTurns == 0) {
			code1 = currentNum;
		}
		else {
			code3 = currentNum;
		}
		numOfTurns++;
	}
	public boolean open() {
		if (pass1 == code1 && pass2 == code2 && pass3 == code3) {
			return true;
		}
		return false;
	}
	
	
	
	
	
}
