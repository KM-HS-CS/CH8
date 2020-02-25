

public class ComboLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ComboLock lock = new ComboLock(20,10,30);
		
		lock.turnRight(20);
		System.out.println(lock.code1);
		lock.turnLeft(10);
		System.out.println(lock.code2);
		lock.turnRight(20);
		System.out.println(lock.code3);
		System.out.println(lock.open());
		
	}

}
