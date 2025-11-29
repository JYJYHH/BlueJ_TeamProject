import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
/**
 * App 클래스: main메소드 내부에서 수행되는 작업(①~⑦)을 처리하도록 
 *           구현하는 클래스. P.463,477
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class App
{
    //메인메소드 59p
    public static void main(String[] args)
    {
        //①LibraryManagementSystem의 객체를 생성한다.
        LibraryManagementSystem libMS= new LibraryManagementSystem();
        //②이용자 등록하기
        LibDB<User> uDB = libMS.setUserDB("C:\\Temp\\UserData2025.txt");
        //③이용자 목록 출력
        System.out.println("----- 이용자 목록 출력 -----");
        libMS.printDB(uDB);
        //④책 등록하기
        LibDB<Book> bDB = libMS.setBookDB("C:\\Temp\\BookData2025.txt");
        //⑤책 목록 출력
        System.out.println("----- 책 목록 출력 -----");
        libMS.printDB(bDB);
        //⑥ 대출작업 3건 수행
        libMS.borrowBook("2025320001","B02");
        libMS.borrowBook("2024320002","B03");
        libMS.borrowBook("2023320003","B04");
        //⑦대출 현황 출력
        libMS.printLoanList();
    }
}