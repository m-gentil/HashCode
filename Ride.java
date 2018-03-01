public class Ride implements Comparable<Ride>{
	int id, startRow, startCol, endRow, endCol, early, late;
	
	public Ride(int i, int sR, int sC, int eR, int eC, int e, int l) {
		id = i;
		startRow = sR;
		startCol = sC;
		endRow = eR;
		endCol = eC;
		early = e;
		late = l;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartCol() {
		return startCol;
	}

	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getEndCol() {
		return endCol;
	}

	public void setEndCol(int endCol) {
		this.endCol = endCol;
	}

	public int getEarly() {
		return early;
	}

	public void setEarly(int early) {
		this.early = early;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int compareTo(Ride o) {
		return - o.getEarly() + this.getEarly();
	}
	
	public String toString() {
		return id + " " + startRow + " " + startCol + " " + endRow + " " + endCol + " " + early + " " + late;
	}
}