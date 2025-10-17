package myClass;

/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book extends DB_Element
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String auther;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * Book 클래스의 객체 생성자
     */
    public Book(String auther, String bookID, String publisher, String title, int year)
    {
        this.auther = auther;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     *
     * @return    book객체를 문자열로
     */
    public String toString()
    {
        // 여기에 코드를 작성하세요.
        return "(" + this.bookID + ") " + this.title +", " + this.auther + ", " + this.publisher + ", " + this.year;
    }
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String getId()
    {
        return this.bookID;
    }

}