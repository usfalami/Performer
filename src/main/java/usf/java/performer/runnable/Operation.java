package usf.java.performer.runnable;

public interface Operation<P, R> extends Runnable  {
	
	void processFirst(P obj);

	void process(int row, P obj);
	
	R getResult();

}
