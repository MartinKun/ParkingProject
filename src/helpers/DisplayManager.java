package helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class DisplayManager implements PriceObserver{
	
	private double priceByHour;

	private static DisplayManager cronometer;
	private JLabel timeParkedLbl;
	private JLabel totalAmountPayableLbl;
	private double amountPayable;
	public boolean isTimerInit = false;

	private int days;
	private int hours;
	private int minutes;
	private int seconds;
	Timer timer;

	public static DisplayManager getInstance() {

		if (cronometer == null) {
			cronometer = new DisplayManager();
		}

		return cronometer;
	}

	private DisplayManager() {

	}

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds++;
			if (seconds == 60) {
				minutes++;
				seconds = 0;
			}
			
			if(days == 0 && hours == 0 && minutes == 15 && seconds == 0) {
				amountPayable = priceByHour;
				displayAmountPayable();
				
			}
			
			if(hours != 0 && minutes == 15 && seconds == 0) {
				amountPayable += priceByHour;
				displayAmountPayable();
				
			}
			
			if (minutes == 60) {
				hours++;
				minutes = 0;
			}
			if (hours == 24) {
				days++;
				hours = 0;
			}

			updateTimeParkedLabel();
		}
	};

	public void updateTimeParkedLabel() {
		String text = (days == 1 ? days + "dia" : "") + (days > 1 ? days + "dias" : "") + "\n"
				+ (hours == 1 ? hours + "Hr" : "") + (hours > 1 && hours <= 9 ? "0" + hours + "Hrs" : "")
				+ (hours > 9 ? hours + "Hrs" : "") + (minutes <= 9 ? "0" : "") + minutes + "min"
				+ (seconds <= 9 ? "0" : "") + seconds + "seg";

		timeParkedLbl.setText(text);
	}

	public void initTimer() {

		timer = new Timer(1000, actionListener);

		timer.start();
		isTimerInit = true;

	}

	public void stopTimer() {
		if(timer != null) {
		timer.stop();
		isTimerInit = false;
		}
	}
	
	

	public JLabel getTimeParkedLbl() {
		return timeParkedLbl;
	}

	public void setTimeParkedLbl(JLabel timeParkedLbl) {
		this.timeParkedLbl = timeParkedLbl;
	}

	public JLabel getTotalAmountPayableLbl() {
		return totalAmountPayableLbl;
	}

	public void setTotalAmountPayableLbl(JLabel totalAmountPayableLbl) {
		this.totalAmountPayableLbl = totalAmountPayableLbl;
	}

	public double getAmountPayable() {
		return amountPayable;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
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

	@Override
	public void priceValueChange(String priceValueChange) {
		this.priceByHour = Double.parseDouble(priceValueChange);
		
	}
	
	public void displayAmountPayable() {
		totalAmountPayableLbl.setText("Total: $" + amountPayable + "");
	}
	
	public void calculateAmountPayable() {
		
		double result = CalculationHelper.calculateAmountPayable(days, hours, minutes, seconds, priceByHour);
		amountPayable = result;
		
	}

}
