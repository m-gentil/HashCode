public class Vehicle {
	int currRow, currCol;
	Ride ride;
	boolean hasPassenger;

	public Vehicle() {
		currRow = 0;
		currCol = 0;
		ride = null;
		hasPassenger = false;
	}

	public void update(int t) {
		if (ride == null) {
			pickNewRide();
		} else if (hasPassenger) {
			int destRow = ride.getEndRow();

			if (currRow > destRow) {
				currRow--;
			} else if (currRow < destRow) {
				currRow++;
			} else {
				int destCol = ride.getEndCol();

				if (currCol > destCol) {
					currCol--;
				} else {
					currCol++;
				}

				if (currCol == destCol) {
					hasPassenger = false;
					// Scrivi su file
					pickNewRide();
				}
			}
		} else {
			int destRow = ride.getStartRow();

			if (currRow > destRow) {
				currRow--;
			} else if (currRow < destRow) {
				currRow++;
			} else {
				int destCol = ride.getStartCol();

				if (currCol > destCol) {
					currCol--;
				} else {
					currCol++;
				}

				if (currCol == destCol && ride.getEarly() <= t) {
					// Scrivi su file
					hasPassenger = true;
				}
			}
		}
	}

	public void pickNewRide() {

	}
}