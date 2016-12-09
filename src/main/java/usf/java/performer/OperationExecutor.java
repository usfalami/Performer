package usf.java.performer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import usf.java.performer.runnable.ListResolver;
import usf.java.performer.runnable.Operation;
import usf.java.performer.runnable.SubListOperation;

public class OperationExecutor {

	public static <P, R> R execute(Operation<P, R> operation, Collection<P> list){
		Iterator<P> it = list.iterator();
		operation.processFirst(it.next());
		for(int i=1; it.hasNext(); i++)
			operation.process(i, it.next());
		return operation.getResult();
	}
	
	public static <P, R> R execute(SubListOperation<P, R> operation, Collection<P> list, int subSize){
		Iterator<P> it = list.iterator();
		for(int i=0; it.hasNext();) {
			operation.processFirst(it.next()); i++;
			for(int j=1; j<subSize; j++, i++)
				operation.process(i, it.next());
			operation.endPart();
		}
		return operation.getResult();
	}
	
	public static <P, T, R> R executeOnRows(Operation<P, T> operation, Operation<T, R> resolver, List<List<P>> lists){

		int rows = lists.get(0).size(), cols = lists.size(), i=0;

		//process first
		operation.processFirst(lists.get(0).get(i));
		for(int j=1; j<cols; j++)
			operation.process(i, lists.get(j).get(i));
		resolver.processFirst(operation.getResult());
		
		//process list
		for(i=1; i<rows; i++){
			operation.processFirst(lists.get(0).get(i));
			for(int j=1; j<cols; j++)
				operation.process(i, lists.get(j).get(i));
			resolver.process(i, operation.getResult());
		}
		return resolver.getResult();
	}
	
	
	public static <P, T, R, C extends List<P>> R executeOnColumns(Operation<P, T> operation, Operation<T, R> resolver, List<C> lists){

		int cols = lists.size(), i=0;
		
		//process first
		C column = lists.get(i);
		operation.processFirst(column.get(0));
		for(int j=1; j<column.size(); j++)
			//process list
			operation.process(j, column.get(j));
		resolver.processFirst(operation.getResult());
	
		for(i=1; i<cols; i++){
			//process first
			column = lists.get(i);
			operation.processFirst(column.get(0));
			for(int j=1; j<column.size(); j++)
				//process list
				operation.process(j, column.get(j));
			resolver.process(i, operation.getResult());
		}
		return resolver.getResult();
	}
	
	
	public static <P, R> Collection<R> executeoOnRows(Operation<P, R> operation, List<List<P>> lists){
		return executeOnRows(operation, new ListResolver<R>(), lists);
	}
	
	public static <P, R> Collection<R> executeOnColumns(Operation<P, R> operation, List<List<P>> lists){
		return executeOnColumns(operation, new ListResolver<R>(), lists);
	}

}
