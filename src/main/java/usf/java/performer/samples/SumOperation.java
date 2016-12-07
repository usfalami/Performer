package usf.java.performer.samples;

import usf.java.performer.runnable.Operation;

public class SumOperation implements Operation<Integer, Integer> {

	Integer sum = 0;
	
	@Override
	public void processFirst(Integer obj) {
		sum = obj;
	}

	@Override
	public void process(int row, Integer obj) {
		sum += obj;
	}

	@Override
	public Integer getResult() {
		return sum;
	}

}
