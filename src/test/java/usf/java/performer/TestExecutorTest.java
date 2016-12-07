package usf.java.performer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class TestExecutorTest {
	
	@Test
	public void test1() {
		genericTest(0);
	}
	@Test
	public void test2() {
		genericTest(-1);
	}
	@Test
	public void test3() {
		genericTest(1, 2, 3, 4, 5);
	}
	@Test
	public void test4() {
		genericTest(-1, 2, 3, 4, 5);
	}
	@Test
	public void test5() {
		genericTest(1, 2, 3, 4, -5);
	}
	@Test
	public void test6() {
		genericTest(1, 2, -3, 4, 5);
	}
	@Test
	public void test7() {
		genericTest(-1, -2, -3, -4, -5);
	}

	private void genericTest(Integer... values){
	
		List<Integer> list = Arrays.asList(values);

		usf.java.performer.Test<Integer> op = new PosetifNumberTest();
		boolean result = TestExecutor.execute(op, list);
		
		int i = 0; 
		while(i<values.length && values[i]>=0) i++;
		
		TestCase.assertEquals(result, i==values.length);
	}
	
	private void generic2dTest(Integer[]... values){
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<0; i++)
			list.add(Arrays.asList(values[i]));

		usf.java.performer.Test<Integer> op = new PosetifNumberTest();
		boolean result = TestExecutor.execute(op, list);
		
		int i = 0; 
		while(i<values.length && values[i][j]>=0) i++;
		
		TestCase.assertEquals(result, i==values.length);
	}
	
	
}
