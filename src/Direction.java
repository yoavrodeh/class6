
public enum Direction {
    NORTH, SOUTH, EAST, WEST;
	
	public static void main(String[] args) {
		Direction d = Direction.NORTH;
		if (d == Direction.NORTH)
		    d = Direction.EAST;
		System.out.println(d); // EAST
	}
}
