package model;

public interface PriceObservable <T>{
	
	public void addPriceObserver(T t);
	
	public void removePriceObserver(T t);
}
