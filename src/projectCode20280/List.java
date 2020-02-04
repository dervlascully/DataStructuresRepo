/*
 * Author: Aonghus Lawlor aonghus.lawlor@ucd.ie
 * 2019
 * 
 * Do not edit this file! It will be updated during the module.
 * 
 */

package projectCode20280;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
	
	int getSize();
// 	int size();
	
	boolean isEmpty();
	
	E get(int i);
	
	void add(E e, int i);
// 	void add(int i, E e);
	
	void addFirst(E e);
	void addLast(E e);
	
	E remove(int i);

// 	E removeFirst();
// 	E removeLast();
	void removeFirst();
	void removeLast();
	
	Iterator<E> iterator();
}
