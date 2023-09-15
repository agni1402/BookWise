package com.datavisual.dataVisualizationDashboard.services;

import com.datavisual.dataVisualizationDashboard.dao.BookRepository;
import com.datavisual.dataVisualizationDashboard.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //or @Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
//    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(1,"My Name is Khan","Shahrukh Khan"));
//        list.add(new Book(2,"My Name is Neeru Pal","Anubhav Pal"));
//        list.add(new Book(3,"My Name is Pradhan","Manish Pandit"));
//        list.add(new Book(4,"My Name is Kalu dada","Shailesh Pandit"));
//        list.add(new Book(5,"My Name is Baba","Anchal Yadav"));
//    }
    public List<Book> getAllBooks()
    {
        List<Book> lis = (List<Book>)this.bookRepository.findAll();
        return lis;
    }
    public Book getBookById(int id){
        Book book = null;
        try{
//            List<Book> lis = (List<Book>)this.bookRepository.findAll();
//            book = lis.stream().filter(b -> b.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public Book addbook(Book b){
        Book res = bookRepository.save(b);
        return res;
    }
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
    }

    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }

    public void updateBook(Book book, int bid){
//        list.stream().peek(b -> {
//            if(b.getId() == bid){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//        }).collect(Collectors.toList());
        book.setId(bid);
        bookRepository.save(book);
    }

}
