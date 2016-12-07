package usf.java.performer;

public class PosetifNumberTest implements Test<Integer> {

	@Override
	public boolean processFirst(Integer obj) {
		return process(0, obj);
	}

	@Override
	public boolean process(int row, Integer obj) {
		return obj >= 0;
	}

}
