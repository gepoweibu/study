package study201812_02;

public class Cell_NoOverrideEquals {
	private int x;
	private int y;
	public Cell_NoOverrideEquals(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
