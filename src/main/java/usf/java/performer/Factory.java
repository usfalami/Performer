package usf.java.performer;

public interface Factory<R> {
	
	R create(int row, int col);

}