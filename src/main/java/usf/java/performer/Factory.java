package usf.java.performer;

public interface Factory<R> extends Performer {
	
	R create(int row, int col);

}