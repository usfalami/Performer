package usf.java.performer.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import usf.java.performer.ValidationExecutor;
import usf.java.performer.samples.PosetifNumberValidation;

public class PosetifNumberValidationTest {
	
	@Test
	public void test1() {
		testPositifNumber(0);
	}
	@Test
	public void test2() {
		testPositifNumber(-1);
	}
	@Test
	public void test3() {
		testPositifNumber(1, 2, 3, 4, 5);
	}
	@Test
	public void test4() {
		testPositifNumber(-1, 2, 3, 4, 5);
	}
	@Test
	public void test5() {
		testPositifNumber(1, 2, 3, 4, -5);
	}
	@Test
	public void test6() {
		testPositifNumber(1, 2, -3, 4, 5);
	}
	@Test
	public void test7() {
		testPositifNumber(-1, -2, -3, -4, -5);
	}
	
	@Test
	public void test9() {
		testPositifNumber2d(new Integer[][]{
			{0}
		});
	}
	@Test
	public void test10() {
		testPositifNumber2d(new Integer[][]{
			{-1}
		});
	}
	@Test
	public void test11() {
		testPositifNumber2d(new Integer[][]{
			{1,2,3}
		});
	}
	
	@Test
	public void test12() {
		testPositifNumber2d(new Integer[][]{
			{-1,2,3}
		});
	}
	
	@Test
	public void test13() {
		testPositifNumber2d(new Integer[][]{
			{1,2,-3}
		});
	}	
	
	@Test
	public void test14() {
		testPositifNumber2d(new Integer[][]{
			{0},{0},{0}
		});
	}
	@Test
	public void test15() {
		testPositifNumber2d(new Integer[][]{
			{-1},{-1},{0}
		});
	}
	@Test
	public void test16() {
		testPositifNumber2d(new Integer[][]{
			{1, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 3, 4}
		});
	}
	@Test
	public void test17() {
		testPositifNumber2d(new Integer[][]{
			{-1, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 3, 4}
		});
	}
	@Test
	public void test18() {
		testPositifNumber2d(new Integer[][]{
			{1, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 3, -4}
		});
	}
	
	@Test
	public void test19() {
		testPositifNumber2d(new Integer[][]{
			{1, 2, 3, 4},
			{1, 2, -3, 4},
			{1, 2, 3, 4}
		});
	}
	
	@Test
	public void test20() {
		testPositifNumber2d(new Integer[][]{
			{-1, -2, -3, -4},
			{-1, -2, -3, -4},
			{-1, -2, -3, -4}
		});
	}
	
	private void testPositifNumber(Integer... values){
	
		List<Integer> list = Arrays.asList(values);

		usf.java.performer.runnable.Validation<Integer> op = new PosetifNumberValidation();
		boolean result = ValidationExecutor.execute(op, list);
		
		int i = 0; 
		while(i<values.length && values[i]>=0) i++;
		
		TestCase.assertEquals(result, i==values.length);
	}
	
	private void testPositifNumber2d(Integer[][] values){
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0; i<values.length; i++)
			list.add(Arrays.asList(values[i]));

		usf.java.performer.runnable.Validation<Integer> op = new PosetifNumberValidation();
		boolean result = ValidationExecutor.executeOnRows(op, list);
		
		int i = 0, j = 0; 
		while(i<values.length && values[i][j]>=0){
			j++;
			if(j == values[i].length){
				j=0; i++;
			}
		}
		TestCase.assertEquals(result, i==values.length);
	}
	
	
}
