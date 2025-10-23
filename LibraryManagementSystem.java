import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
/**
 * LibraryManagementSystem: 책DB와 이용자DB, 대출 DB를 생성하고, 
 *                          App 클래스를 구현하기 위한 메소드를 정의하는 클래스.
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.22)
 */
public class LibraryManagementSystem
{
    // 속성 3개 입력. 접근 지정자는 디폴트 
    //접근 지정자 222p, 해시맵 생성 424p
    LibDB<Book> bookDB;
    LibDB<User> userDB;
    HashMap<User,Book> loanDB;
    
    /**
     * LibraryManagementSystem 클래스의 생성자 (생성자 선언 190p)
     * 책DB, 이용자DB, 대출DB를 초기화
     */
    public LibraryManagementSystem(){
        this.bookDB = new LibDB<>();
        this.loanDB = new HashMap<>();
        this.userDB = new LibDB<>();
    }
    
    /**
     * borrowBook: 입력받은 이용자ID와 책ID를 사용하여 각각의 요소를 찾고,
     *             대출DB에 저장하는 메소드 (해시맵 저장 425p)
     *
     * @param  userID  대출을 요청한 이용자의 ID
     * @param  bookID  대출할 책의 ID
     */
    public void borrowBook(String userID,String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user,book);
    }
    
    /**
     * printDB: 주어진 LibDB의 모든 요소를 출력하는 메소드.
     * 제네릭 타입 T는 DB_Element를 상속. (제네릭 메소드 440p)
     *
     * @param  db: 출력할 데이터를 담고 있는 LibDB 객체
     */
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    
    /**
     * printLoanList: 현재 대출 중인 이용자와 책 목록을 출력하는 메소드.
     * Key값을 통해 대출DB을 순회하며 Key와 Value값 출력. 
     * (while문 121p)
     * (Key값을 가진 Set컬렉션 생성 및 Iterator을 통해 Key를 순차 검색 429p)
     */
    public void printLoanList(){
        System.out.println("----- 대출 현황 -----");
        Set<User> keys = loanDB.keySet();
        Iterator<User> loanIterator = keys.iterator();
        while(loanIterator.hasNext()){
            User loanUser = loanIterator.next();
            Book loanBook = loanDB.get(loanUser);
            System.out.println(loanUser + " ===> " + loanBook);
        }
        System.out.println("--------------------");
    }
    
    /**
     * setBookDB: 책DB를 초기화 한 후, 주어진 파일 경로에서 도서 정보를 읽어와 
     *            책DB를 생성하는 메소드.
     *(Scanner 객체 생성 76p), (try-catch-finally문 154p),
     *(문자열을 int로 변환 361p), (StringTokenizer 및 nextToken 376,377p),
     *(Iterator 422p), (파일에서 한 라인 읽기 500p)
     *
     * @param  bookFile: 책 정보가 저장된 파일의 경로명
     * @return bookFile의 정보가 저장된 책DB 객체 
     */
    public LibDB<Book> setBookDB(String bookFile){
        this.bookDB = new LibDB<>();
        try(
            Scanner bookScanner = new Scanner(new FileReader(bookFile)))
            {
                while(bookScanner.hasNext()){
                    String bookLine = bookScanner.nextLine();
                    ArrayList<String> inputBook = new ArrayList<String>();
                    inputBook.add(bookLine);
                    Iterator<String> bookIterator = inputBook.iterator();
                    while(bookIterator.hasNext()){
                        String currentLine = bookIterator.next();
                        StringTokenizer bookTokenizer = new StringTokenizer(currentLine,"/");
                        String bookID = bookTokenizer.nextToken();
                        String title = bookTokenizer.nextToken();
                        String author = bookTokenizer.nextToken();
                        String publisher = bookTokenizer.nextToken();
                        int year = Integer.parseInt(bookTokenizer.nextToken());
                        Book newBook = new Book(bookID,title,author,publisher,year);
                        bookDB.addElement(newBook);
                    }
                }
                bookScanner.close();
            }
        catch(FileNotFoundException e){
            System.out.println("파일 경로명이 다릅니다");
        }catch(IOException e){
            System.out.println("입출력 오류");
        }
        return this.bookDB;
    }
    
    /**
     * setUserDB: 이용자DB를 초기화 한 후, 주어진 파일 경로에서 도서 정보를 읽어와 
     *            이용자DB를 생성하는 메소드.
     *(Scanner 객체 생성 76p), (for문 119p), (try-catch-finally문 154p)
     *(문자열을 int로 변환 361p), (StringTokenizer 및 메소드 376,377p),
     *(파일에서 한 라인 읽기 500p)
     *
     * @param  userFile: 이용자 정보가 저장된 파일의 경로명
     * @return userFile의 정보가 저장된 이용자DB 객체 
     */
    public LibDB<User> setUserDB(String userFile){
        this.userDB = new LibDB<>();
        try(
            Scanner userScanner = new Scanner(new FileReader(userFile))){
                while(userScanner.hasNext()){
                    String userLine = userScanner.nextLine();
                    StringTokenizer userTokernizer = new StringTokenizer(userLine,"/");
                    int n = userTokernizer.countTokens();
                    for(int i = 0 ; i<n/2 ; i++){
                        int stID = Integer.parseInt(userTokernizer.nextToken());
                        String name = userTokernizer.nextToken();
                        User newUser = new User(stID, name);
                        userDB.addElement(newUser);
                    }
                }
                userScanner.close();
                }
        catch(FileNotFoundException e){
            System.out.println("파일 경로명이 다릅니다");
        }catch(IOException e){
            System.out.println("입출력 오류");
        }
        return this.userDB;
    }  
}