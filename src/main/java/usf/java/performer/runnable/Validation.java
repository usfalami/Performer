package usf.java.performer.runnable;

public interface Validation<P> extends Runnable {

	boolean processFirst(P obj);

	boolean process(int row, P obj);
	
}
