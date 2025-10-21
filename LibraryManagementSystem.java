import DataBase.*;
import myClass.*;
import java.util.*;
import java.io.*;
/**
 * LibraryManagementSystem: 책과 이용자, 대출 DB를 생성하고, App 클래스를 구현하기 위한 메소드를 정의하는 클래스.
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    LibDB<User> userDB;
    HashMap<User,Book> loanDB;
    public LibraryManagementSystem(){
        this.bookDB = new LibDB<>();
        this.loanDB = new HashMap<>();
        this.userDB = new LibDB<>();
    }
    public void borrowBook(String userID,String bookID){
        User u = userDB.findElement(userID);
        Book b = bookDB.findElement(bookID);
        loanDB.put(u,b);
    }
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    public void printLoanList(){
        System.out.println("----- 대출 현황 -----");
        Set<User> user = loanDB.keySet();
        Iterator<User> it = user.iterator();
        while(it.hasNext()){
            User u = it.next();
            Book b = loanDB.get(u);
            System.out.println(u + " ===> " + b);
        }
        System.out.println("--------------------");
    }
    public LibDB<Book> setBookDB(String bookFile){
        this.bookDB = new LibDB<>();
        try(
            Scanner bs = new Scanner(new FileReader(bookFile))){
                while(bs.hasNext()){
                    String line = bs.nextLine();
                    List<String> inputBook = new ArrayList<>();
                    inputBook.add(line);
                    Iterator<String> it = inputBook.iterator();
                    while(it.hasNext()){
                        String currentLine = it.next();
                        StringTokenizer bt = new StringTokenizer(currentLine,"/");
                        String bookID = bt.nextToken();
                        String title = bt.nextToken();
                        String author = bt.nextToken();
                        String publisher = bt.nextToken();
                        int year = Integer.parseInt(bt.nextToken());
                        Book nb = new Book(bookID,title,author,publisher,year);
                        bookDB.addElement(nb);
                    }
                }
                bs.close();
            }
        catch(FileNotFoundException e){
            System.out.println("파일 경로명이 다릅니다");
        }catch(IOException e){
            System.out.println("입출력 오류");
        }
        return this.bookDB;
    }
    public LibDB<User> setUserDB(String userFile){
        this.userDB = new LibDB<>();
        try(
            Scanner us = new Scanner(new FileReader(userFile))){
                while(us.hasNext()){
                    String line = us.nextLine();
                    StringTokenizer ut = new StringTokenizer(line,"/");
                    int n = ut.countTokens();
                    for(int i = 0 ; i<n/2 ; i++){
                        int stID = Integer.parseInt(ut.nextToken());
                        String name = ut.nextToken();
                        User nu = new User(stID, name);
                        userDB.addElement(nu);
                    }
                }
                us.close();
                }
        catch(FileNotFoundException e){
            System.out.println("파일 경로명이 다릅니다");
        }catch(IOException e){
            System.out.println("입출력 오류");
        }
        return this.userDB;
            }  
    }