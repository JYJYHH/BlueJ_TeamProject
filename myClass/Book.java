package myClass;

/**
 * Book 클래스의 설명을 작성하세요.
 * 책 객체를 나타내는 Book 클래스
 * 속성 5개 메소드 3개
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class Book extends DB_Element
{
    // 속성 5개 입력 전부 private 222p
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * Book 클래스의 객체 생성자 파라미터5개 (의미가 드러나도록) 197p
     */
    public Book(String author, String bookID, String publisher, String title, int year)
    {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * 추상 클래스 DB_Element를 상속받아 getID()를 오버라이딩 299p
     * 
     */
    public String getID()
    {
        return this.bookID;
    }
    
    /**
     * Object 클래스의 메소드 String toString() 오버라이딩 351p
     * 현 객체에 대한 문자열 표현을 리턴
     *  
     */
    public String toString()
    {
        return "(" + this.bookID + ") " + this.title +", " + this.author + ", " + this.publisher + ", " + this.year;
    }

}