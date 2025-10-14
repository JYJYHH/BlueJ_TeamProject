import myClass.*; 
import java.util.*;
import DataBase.*;
/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem
{
    private LibDB<Book> bookDB;            // 책 데이터베이스
    private LibDB<User> userDB;            // 이용자 데이터베이스
    private HashMap<String, User> loanDB;  // 대출 정보 (key=bookID, value=User)

    public LibraryManagementSystem() {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<String, User>();
    }

    public LibDB<Book> setBookDB(String bookFile) {
        
        return bookDB;
    }

    public LibDB<User> setUserDB(String userFile) {
        
        return userDB;
    }

    public <T extends DB_Element> void printDB(LibDB<T> db) {
        db.printAllElement();
    }

    public void borrowBook(String userID, String bookID) {
        // 
    }

    public void printLoanList() {
        // (대출 목록 출력 예정)
    }
}
