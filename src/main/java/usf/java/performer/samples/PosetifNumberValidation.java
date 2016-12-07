package usf.java.performer.samples;

import usf.java.performer.runnable.Validation;

public class PosetifNumberValidation implements Validation<Integer> {

	@Override
	public boolean processFirst(Integer obj) {
		return process(0, obj);
	}

	@Override
	public boolean process(int row, Integer obj) {
		return obj >= 0;
	}

}
