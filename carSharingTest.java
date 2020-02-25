
public class carSharingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalMoney = 0;
		int timesTested = 0;
		while (timesTested < 1000) {
			Car carTest = new Car();
			while (carTest.currentLocation < carTest.carEnd) {
				Station currentStop = new Station();
					for (int b = 0; b < currentStop.pass.passengerNum; b++) {
						if (currentStop.pass.passengerLocation > carTest.currentLocation) {
							if (carTest.passengers < 3) {
								carTest.passengers++;
							}}}
					int temp = 0;
					for (int a : carTest.locations) {
						if (a == carTest.currentLocation) {
							carTest.moneyMade++;
							carTest.locations[temp] = 0;
							carTest.passengers -= 1;
						}
						else {
							carTest.moneyMade++;
						}
					}
					
					carTest.currentLocation++;
			}
			totalMoney += carTest.moneyMade;
			timesTested++;
		}
		System.out.println(totalMoney);
	}

}
