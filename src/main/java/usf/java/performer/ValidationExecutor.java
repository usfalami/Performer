package usf.java.performer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import usf.java.performer.runnable.Validation;

public class ValidationExecutor {

	public static <P> boolean execute(Validation<P> validation, Collection<P> list){
		Iterator<P> it = list.iterator();
		if(!validation.processFirst(it.next()))
			return false;
		for(int i=1; it.hasNext(); i++)
			if(!validation.process(i, it.next()))
				return false;
		return true;
	}

	public static <P, C extends List<P>> boolean executeOnRows(Validation<P> validation, List<C> lists){

		int rows = lists.get(0).size(), cols = lists.size();

		for(int i=0; i<rows; i++){
			//process first
			if(!validation.processFirst(lists.get(0).get(i)))
				return false;
			for(int j=1; j<cols; j++){
				//process list
				if(!validation.process(i, lists.get(j).get(i)))
					return false;
			}
		}
		return true;
	}
	
	public static <P, C extends List<P>> boolean executeOnColumns(Validation<P> validation, List<C> lists){

		int rows = lists.size();

		for(int i=0; i<rows; i++){
			//process first
			C column = lists.get(i);
			if(!validation.processFirst(column.get(0)))
				return false;
			for(int j=1; j<column.size(); j++){
				//process list
				if(!validation.process(j, column.get(j)))
					return false;
			}
		}
		return true;
	}

}
