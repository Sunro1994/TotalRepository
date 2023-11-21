package bookshelf;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book> {
	
	private BookShelf bookShelf; //검색을 수행할 책꽂이
	private int index=0; //현재 처리할 책의 위치
	
	

	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	@Override
	public boolean hasNext() {
		return index < bookShelf.getLength();
	}

	@Override
	public Book next() {
		Book book = bookShelf.getBook(index);
		index++;
		
		return book;
		
		
	}

}
