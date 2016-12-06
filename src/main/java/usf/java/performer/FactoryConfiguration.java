package usf.java.performer;

public class FactoryConfiguration {

	private int columns, rows;
	private boolean nullable;
	
	public static final FactoryConfiguration DEFAULT = new FactoryConfiguration(10, 5, false);
	
	public FactoryConfiguration(int rows, int columns, boolean nullable) {
		this.rows = rows;
		this.columns = columns;
		this.nullable = nullable;
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

	public boolean isNullable() {
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	
}
