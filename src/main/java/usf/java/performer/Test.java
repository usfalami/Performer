package usf.java.performer;

public interface Test<P> extends Performer {

	boolean processFirst(P obj);

	boolean process(int row, P obj);
	
}
