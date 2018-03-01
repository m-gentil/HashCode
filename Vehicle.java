import java.util.ArrayList;

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

	public void update(int t, ArrayList<Ride> rides) {
		if (ride == null) {
			pickNewRide(rides);
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
					pickNewRide(rides);
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

	public void pickNewRide(ArrayList<Ride> r) {
		if(r.size() <= 0) {
			return;
		}
		
		int bestTimeArrival = Integer.MAX_VALUE;
		int bestIndex = 0;
		for(int i = 0; i < r.size(); i++) {
			Ride curr = r.get(i);
			if(curr.getEarly() + Math.abs(curr.getStartRow() - currRow) + Math.abs(curr.getStartCol() - currCol) < bestTimeArrival) {
				bestTimeArrival = curr.getEarly() + Math.abs(curr.getStartRow() - currRow) + Math.abs(curr.getStartCol() - currCol);
				bestIndex = i;	
			}
		}
		
		ride = r.remove(bestIndex);
	}
	
	public String toString() {
		return currRow + " " + currCol;
	}
}