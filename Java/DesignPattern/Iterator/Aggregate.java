package bookshelf;

import java.util.Iterator;

/***
 *  Iterator 역할을 만들어내는 인터페이스
 */
public interface Aggregate {
	public abstract Iterator<Book> createIterator();
}
