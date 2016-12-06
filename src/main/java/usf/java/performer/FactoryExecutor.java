package usf.java.performer;

import java.util.ArrayList;
import java.util.Collection;

public class FactoryExecutor {
	
	protected static <T> Collection<T> createList(int column, Factory<T> factory, FactoryConfiguration fc) {
		Collection<T> result = new ArrayList<>();
		for(int i=0; i< fc.getRows(); i++)
			result.add(factory.create(i, column));
		return result;
	}
	
	public static <T> Collection<T> createList(Factory<T> factory, FactoryConfiguration fc) {
		if(factory == null || fc == null) return null;
		return createList(0, factory, fc);
	}
	
	public static <T> Collection<T> createList(Factory<T> df) {
		if(df == null) return null;
		return createList(0, df, FactoryConfiguration.DEFAULT);
	}
	
	public static <T> Collection<Collection<T>> createMatrix(Factory<T> factory, FactoryConfiguration fc) {
		if(factory == null || fc == null) return null;
		Collection<Collection<T>> result = new ArrayList<>();
		for(int i=0; i<fc.getColumns(); i++)
			result.add(createList(i, factory, fc));
		return result;
	}
	
	public static <T> Collection<Collection<T>> createMatrix(Factory<T> factory) {
		if(factory == null) return null;
		return createMatrix(factory, FactoryConfiguration.DEFAULT);
	}
	
}
