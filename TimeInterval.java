package calendar;

import java.time.LocalTime;
import java.util.TreeSet;

public class TimeInterval {
	private LocalTime start;
	private LocalTime end;
	
	public TimeInterval(LocalTime start, LocalTime end) {
		this.start = start;
		this.end = end;
	}
	
	public LocalTime getStart() {
		return start;
	}
	
	public LocalTime getEnd() {
		return end;
	}
	
	public String toString() {
		return start.toString() + " - " + end.toString();
	}
	
	/**
	 * Checks if there are overlapping events. If there are, don't add it and let the user know.
	 * @param a Interval being compared to
	 * @return whether there is an overlap between two time intervals or not.
	 */
	public boolean checkOverlap(TimeInterval a) {
		//comparing all of the LocalTimes of a time interval to check for an overlap
		if (this.start.compareTo(a.start) >= 0 && this.start.compareTo(a.end) <= 0|| this.end.compareTo(a.start) >= 0 && this.end.compareTo(a.end) <= 0) {
			return true;
		}
		return false;
	}
	
	public static void main (String[] args) {
		String start = "13:00";
		String end = "15:00";
		String start2 = "16:00";
		String end2 = "17:00";
		LocalTime a = LocalTime.parse(start);
		LocalTime b = LocalTime.parse(end);
		LocalTime x = LocalTime.parse(start2);
		LocalTime y = LocalTime.parse(end2);
		TimeInterval interval = new TimeInterval(a, b);
		TimeInterval interval2 = new TimeInterval(x, y);
		System.out.println(interval.checkOverlap(interval2));
	}
}
