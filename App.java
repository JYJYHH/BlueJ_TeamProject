import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
/**
 * App 클래스: main메소드 내부에서 수행되는 작업(①~⑦)을 처리하도록 구현하는 클래스.
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class App
{
    public static void main(String[] args)
    {
        LibraryManagementSystem library = new LibraryManagementSystem();
        
        LibDB<User> uDB = library.setUserDB("C:\\Temp\\UserData2025.txt");
        LibDB<Book> bDB = library.setBookDB("C:\\Temp\\BookData2025.txt");
        
        library.borrowBook("2025320001","B02");
        library.borrowBook("2024320002","B03");
        library.borrowBook("2023320003","B04");
        
        System.out.println("----- 이용자 목록 출력 -----");
        library.printDB(uDB);
        System.out.println("----- 책 목록 출력 -----");
        library.printDB(bDB);
        library.printLoanList();
    }
}