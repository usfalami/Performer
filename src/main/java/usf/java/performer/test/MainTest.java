package usf.java.performer.test;

import java.util.List;
import java.util.Random;

import usf.java.performer.FactoryConfiguration;
import usf.java.performer.FactoryExecutor;
import usf.java.performer.OperationExecutor;
import usf.java.performer.runnable.Factory;
import usf.java.performer.runnable.Operation;

public class MainTest {
	
	public static void main(String[] args) {
		
		FactoryConfiguration config = new FactoryConfiguration(20, 2, false);
		Factory<Integer> factory = new SequencialIntFactory();
		
		ArrayPrinter<Integer> op = new ArrayPrinter<>();

		List<Integer> list = FactoryExecutor.createList(factory, config);
		System.out.println("1D Array printer");
		OperationExecutor.execute(op, list);
		
		config.setNullInjection(true);
		
		List<List<Integer>> lists = FactoryExecutor.createMatrix(factory, config);
		System.out.println("\n\n2D Array printer");
		OperationExecutor.executeoOnRows(op, lists);
		

		System.out.println("\n\n2D Array printer");
		
		OperationExecutor.executeOnColumns(op, lists);
		
	}
	
	//operation sample
	
	public static class ArrayPrinter<T> implements Operation<T, Void>{

		@Override
		public void processFirst(T obj) {
			System.out.println();
			process(0, obj);
		}

		@Override
		public void process(int row, T obj) {
			System.out.format("%-10s", obj);
		}
		
		@Override
		public Void getResult() {
			return null;
		}
		
	}
	
	// factory sample
	
	public static class SequencialIntFactory implements Factory<Integer> {
		
		private int start = new Random().nextInt() % 10;
		
		@Override
		public Integer create(int row, int col) {
			return start++;
		}
	}

}
