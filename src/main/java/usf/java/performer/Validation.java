package usf.java.performer;

public interface Validation<P> extends Performer {

	boolean processFirst(P obj);

	boolean process(int row, P obj);
	
}
