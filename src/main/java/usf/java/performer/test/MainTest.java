package usf.java.performer.test;

import java.util.Arrays;

import usf.java.performer.OperationExecutor;
import usf.java.performer.runnable.Operation;

public class MainTest {
	
	public static void main(String[] args) {
		
		ArrayPrinter<String> op = new ArrayPrinter<>();

		System.out.println("1d Array printer");

		OperationExecutor.execute(op, Arrays.asList(
				"COL1.1", "COL1.2", "COL1.3", "COL1.4"));
		
		System.out.println("\n\n2d Array printer");
		
		OperationExecutor.execute(op, Arrays.asList(
				Arrays.asList("COL1.1", "COL1.2", "COL1.3", "COL1.4"),
				Arrays.asList("COL2.1", "COL2.2", "COL2.3", "COL2.4"),
				Arrays.asList("COL3.1", "COL3.2", "COL3.3", "COL3.4"),
				Arrays.asList("COL4.1", "COL4.2", "COL4.3", "COL4.4")
			));
		
	}
	
	public static class ArrayPrinter<T> implements Operation<T, Void>{

		@Override
		public void processFirst(T obj) {
			System.out.println();
			process(0, obj);
		}

		@Override
		public void process(int row, T obj) {
			System.out.format("%-15s", obj);
		}
		
		@Override
		public Void getResult() {
			return null;
		}
		
	}

}
