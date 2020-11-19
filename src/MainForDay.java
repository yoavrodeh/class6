import java.util.Arrays;
public class MainForDay {
	public static void main(String[] args) {
		Day d = Day.TUESDAY;
		if (d == Day.TUESDAY) {
			System.out.println(d); // TUESDAY
			System.out.println(d.ordinal()); // 2
		}
		Day[] days = Day.values();
		System.out.println(Arrays.toString(days));
		// [SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
		//        THURSDAY, FRIDAY, SATURDAY]
		Day d2 = Day.valueOf("MONDAY");		
		System.out.println(d2.compareTo(d)); // -1
	}
}
