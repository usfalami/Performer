package usf.java.performer;

import java.util.Random;

public class FactoryConfiguration {

	public static final FactoryConfiguration DEFAULT = new FactoryConfiguration(10, 5, false);

	private int columns, rows;
	private boolean nullInjection;
	
	public FactoryConfiguration(int rows) {
		this(rows, 1, false);
	}
	
	public FactoryConfiguration(int rows, int columns) {
		this(rows, columns, false);
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
		return Math.abs(new Random().nextInt()) % 100 > 5 ? obj : null;
	}
	
	protected int random(int poucentage){
		int size = rows * columns + 1;
		int pct = poucentage * size/100 + 1;
		System.out.println(size + " " + pct);
		return pct;
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
