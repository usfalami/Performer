package usf.java.performer;

import java.util.Random;

public class FactoryConfiguration {

	private int columns, rows;
	private boolean nullInjection;
	
	public static final FactoryConfiguration DEFAULT = new FactoryConfiguration(10, 5, false);
	
	public FactoryConfiguration(int rows) {
		this.rows = rows;
	}
	
	public FactoryConfiguration(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public FactoryConfiguration(int rows, int columns, boolean nullInjection) {
		this.rows = rows;
		this.columns = columns;
		this.nullInjection = nullInjection;
	}

	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isNullInjection() {
		return nullInjection;
	}
	public void setNullInjection(boolean nullable) {
		this.nullInjection = nullable;
	}
	
	public <T> T nullable(T obj) {
		return Math.abs(new Random().nextInt()) % 1000 > 5 ? obj : null;
	}
	
	protected static int random(int min, int max){
		return (Math.abs(new Random().nextInt()) % (max-min+1)) + min;
	}
	
	public static final FactoryConfiguration randomConfiguration(int maxRow, int maxList){
		int listSize = random(1, maxRow);
		int listCount = random(1, maxList);
		return new FactoryConfiguration(listSize, listCount);
	}
	
	public static final FactoryConfiguration randomConfiguration(int maxRow){
		int listSize = random(1, maxRow);
		return new FactoryConfiguration(listSize);
	}
	
}
