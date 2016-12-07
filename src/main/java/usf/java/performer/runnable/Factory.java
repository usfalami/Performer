package usf.java.performer.runnable;

public interface Factory<R> extends Runnable {
	
	R create(int row, int col);

}