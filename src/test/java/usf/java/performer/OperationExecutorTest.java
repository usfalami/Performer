package usf.java.performer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class OperationExecutorTest {
	
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Operation<Integer, Integer> op = new SumOperation();
		int sum = OperationExecutor.execute(op, list);
		TestCase.assertEquals(sum, 15);
	}

	@Test
	public void test2() {
		List<Integer> list = Arrays.asList(0);
		Operation<Integer, Integer> op = new SumOperation();
		int sum = OperationExecutor.execute(op, list);
		TestCase.assertEquals(sum, 0);
	}
	
	@Test
	public void test3() {

		Operation<Integer, Integer> op = new SumOperation();
		
		List<List<Integer>>lists = Arrays.asList(
				Arrays.asList(1, 2, 3, 4, 5),	//col1
				Arrays.asList(1, 2, 3, 4, 5),	//col2
				Arrays.asList(1, 2, 3, 4, 5),	//col3
				Arrays.asList(1, 2, 3, 4, 5),	//col4
				Arrays.asList(1, 2, 3, 4, 5)	//col4
			);
		Collection<Integer> sumList = OperationExecutor.execute(op, lists);
		TestCase.assertEquals(sumList.size(), 5);
		int res = 0;
		for(int sum : sumList) {
			TestCase.assertEquals(sum, res += 5);
		}
	}
	
	@Test
	public void test4() {
		Operation<Integer, Integer> op = new SumOperation();
		
		List<List<Integer>>lists = Arrays.asList(
				Arrays.asList(0)
			);
		Collection<Integer> sumList = OperationExecutor.execute(op, lists);
		TestCase.assertEquals(sumList.size(), 1);
		int sum = sumList.iterator().next();
		TestCase.assertEquals(sum, 0);
	}
	
	@Test
	public void test5() {

		Operation<Integer, Integer> opRow = new SumOperation();
		Operation<Integer, Integer> opCol = new SumOperation();
		
		List<List<Integer>>lists = Arrays.asList(
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(1, 2, 3, 4, 5)
			);
		int sum = OperationExecutor.execute(opRow, opCol, lists);
		TestCase.assertEquals(sum, 75);
	}
	
	@Test
	public void test6() {
		Operation<Integer, Integer> opRow = new SumOperation();
		Operation<Integer, Integer> opCol = new SumOperation();
		
		List<List<Integer>>lists = Arrays.asList(
				Arrays.asList(0)
			);
		int sum = OperationExecutor.execute(opRow, opCol, lists);
		TestCase.assertEquals(sum, 0);
	}

}
