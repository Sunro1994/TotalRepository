package bookshelf;

import java.util.Iterator;

public class library {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(10);
		
		Book book1 = new Book("book1");
		Book book2 = new Book("book2");
		Book book3 = new Book("book3");
		
		bookShelf.appendBook(book1);
		bookShelf.appendBook(book2);
		bookShelf.appendBook(book3);
		
		System.out.println("현재 꽃혀있는 책 : " + bookShelf.getLength()+"권");
		
		Iterator<Book> it = bookShelf.createIterator();
		while(it.hasNext()) {
			Book book = (Book)it.next();
			System.out.println(book.getName());
		}
	}
	
	
}
