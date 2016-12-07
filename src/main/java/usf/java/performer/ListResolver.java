package usf.java.performer;

import java.util.ArrayList;
import java.util.Collection;

import usf.java.performer.Operation;

public class ListResolver<R> implements Operation<R, Collection<R>>  {
	
	private Collection<R> result;
	
	public ListResolver() {
		result = new ArrayList<>();
	}
	@Override
	public void processFirst(R obj) {
		result.add(obj);
	}

	@Override
	public void process(int row, R obj) {
		result.add(obj);
	}
	
	@Override
	public Collection<R> getResult() {
		return result;
	}

}
