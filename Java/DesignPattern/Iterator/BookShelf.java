package bookshelf;

import java.util.Iterator;

/***
 * Aggregate의 구현체
 * 실제로 책꽂이 안을 돌아다닐 Iterator를 생성하고 책꽂이를 관리하는 역할
 * @author Sunro
 *
 */
public class BookShelf implements Aggregate{
	
	
	private Book[] books;		//책의 집합
	private int last =0;		//마지막 책이 꽂힌 위치
	private int size;
	
	public BookShelf(int size) {
		books = new Book[size];
		this.size = size;
	}
	public Book getBook(int index) {
		if(index<size) return books[index];
		
		return null;
	}
	public int getLength() {
		return last;
	}
	
	//책꽂이에 책을 꽂는다.
	public void appendBook(Book book) {
		if(last< books.length) {
			this.books[last] = book;
			last++;
		}
		else {
			System.out.println("책이 꽉 찼습니다!");
		}
	}
	
	
	
	@Override
	public Iterator<Book> createIterator() {
		return new BookShelfIterator(this);
	}
}
