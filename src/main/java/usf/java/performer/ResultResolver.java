package usf.java.performer;

public interface ResultResolver<P, R> {
	
	void process(int row, P obj);
	
	R getResult();

}
