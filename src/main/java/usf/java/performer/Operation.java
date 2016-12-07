package usf.java.performer;

public interface Operation<P, R> extends Performer  {
	
	void processFirst(P obj);

	void process(int row, P obj);
	
	R getResult();

}
