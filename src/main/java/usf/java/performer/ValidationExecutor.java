package usf.java.performer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import usf.java.performer.runnable.Validation;

public class ValidationExecutor {

	public static <P> boolean execute(Validation<P> test, Collection<P> list){
		Iterator<P> it = list.iterator();
		if(!test.processFirst(it.next()))
			return false;
		for(int i=1; it.hasNext(); i++)
			if(!test.process(i, it.next()))
				return false;
		return true;
	}

	public static <P, C extends List<P>> boolean execute(Validation<P> test, List<C> lists){

		int rows = lists.get(0).size(), cols = lists.size();

		for(int i=0; i<rows; i++){
			//process first
			if(!test.processFirst(lists.get(0).get(i)))
				return false;
			for(int j=1; j<cols; j++){
				//process list
				if(!test.process(i, lists.get(j).get(i)))
					return false;
			}
		}
		return true;
	}

}
