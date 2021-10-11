package model.domain;

public class TimeParked {

	private int day;
	private int hour;
	private int minutes;
	private int seconds;

	public TimeParked(int day, int hour, int minutes, int seconds) {
		this.day = day;
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
