import java.util.Scanner;

/*
 * There are still some times when there are errors from user inputting the wrong things but the checkdigit works and everything it needs to get done works
 * 
 * 
 * 
 */


public class BarCode {
	private int ZIPCode;
	private int checkDigit;
	private String barCode = "";
	private int ZIPSum;
	public static final int[][] encoder_ = {
		   //7  4  2  1  0
			{1, 1, 0, 0, 0}, //0
			{0, 0, 0, 1, 1}, //1
            {0, 0, 1, 0, 1}, //2
            {0, 0, 1, 1, 0}, //3
            {0, 1, 0, 0, 1}, //4
            {0, 1, 0, 1, 0}, //5
            {0, 1, 1, 0, 0}, //6
            {1, 0, 0, 0, 1}, //7
            {1, 0, 0, 1, 0}, //8
            {1, 0, 1, 0, 0}  //9
            }; //
	
	
	private int getSum() {
		int sum = 0;
		for (int i=0; i<5;i++) { //gets sum of digits in ZIPCode_
			sum += (int) (this.ZIPCode / (Math.pow(10, 4-i)))%10;
		}
		return sum;
	}
	
	
	public BarCode(int ZIPCode_) {
		if (String.valueOf(ZIPCode_).length() != 5) {
			System.out.println("ERROR");
		} else {
			this.ZIPCode = ZIPCode_;
			this.ZIPSum = this.getSum();	
			this.checkDigit = 10 - (this.ZIPSum % 10); //this is a check number for bar code to zipcode conversion
			//produces the bar code below
			this.barCode = "|";
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					int dumb = (int) (ZIPCode_ /(Math.pow(10, 4-i)))%10;
					if (encoder_[dumb][j] == 1) {
						this.barCode+= "|"; 
					} else if (encoder_[dumb][j] == 0) {
						this.barCode+= ":"; 
						}
					}
				}
			}
			for (int i = 0; i < 5; i++) { //for check digit
				if (encoder_[this.checkDigit][i] == 1) {
					this.barCode+= "|";
				} else if (encoder_[this.checkDigit][i] == 0) {
					this.barCode+= ":";
				}
			}
			this.barCode+= ("|");
		}
	
	
	
	public BarCode(String BarCode_) {
		boolean done = false;
		this.barCode = BarCode_;
		String zip = "";
		for (int i = 0; i<=5; i++) {
			String character =  BarCode_.substring((1 + (5*i)), (6 + (5*i)));
			int j =0;
			while ( j < 9||done == false) {
				if (character.equals(getRow(j))) {
					if (i==5) {
						this.checkDigit = j;
						done = true;
					} else {
						zip += j;
						done = true;
					}
				}
				j++;
			}
		}
		this.ZIPSum = this.getSum();
		if (this.checkDigit == 10 - (this.ZIPSum % 10)) {
			this.ZIPCode = (int) Integer.parseInt(zip);
		} else {
			this.ZIPCode = 00000;
			System.out.println("The barcode was invalid and the checkdigit isn't correct");
		}
	}
	
	public static String getRow(int in) {
		String row = "";
		for (int i =0; i<5;i++) {
			if (encoder_[in][i] == 1) {
				row += "|"; 
			} else if (encoder_[in][i] == 0) {
				row += ":";
				}
		}
		
		return row;
	}
	
	
	public static void start() {
		Scanner ln = new Scanner(System.in);
		String temp;
		boolean done = false;
		System.out.printf("Would you like to (answer with numbers): \n 1. Convert from zipcode to barcode \n 2. Convert from barcode to zipcode or \n 3. Exit \n ");
		temp = String.valueOf(ln.nextInt());
		
		
		if (temp.equals("1")) { // zip to bar
			System.out.println("Please enter the 5 digit zipcode:   ");
			temp = String.valueOf(ln.nextInt());
			BarCode mai = new BarCode(Integer.parseInt(temp));
			System.out.println(mai.barCode);
			start();

		} else if (temp.equals("2")) { //bar to zip
			System.out.println("Please enter the 32 letter barcode with |'s and :'s or type x to exit:   ");
			ln.nextLine();
			temp = ln.nextLine();
			if (temp.equals("x")) {
				start();

			} else if (temp.length() != 32) {
				System.out.println("error");
				start();

			} else {
				BarCode mai = new BarCode(temp);
				System.out.println(mai.ZIPCode);
				start();

			}
		}else if (temp.equals("3")) { // quit
			done = true;
			System.out.println("Have a good rest of your day Kevin Buntman");
				
				
		} else { //error
			System.out.println("input " +  temp + " returns ERROR \n");
			start();
		}
		ln.nextLine();
	ln.close();
	}
	
	public static void main(String[] args) {
		start();
	}
}
