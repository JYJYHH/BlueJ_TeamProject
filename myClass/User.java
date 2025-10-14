package myClass;


/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     */
    public User(int s, String n)
    {
        this.name = n;
        this. stID = s;
    }

    public String getId(){
        return Integer.toString(stID);
    }
    
    // public String getName(){
        // return this.name;
    // }
    
    public String toString(){
        return "[" + this.stID + "]" + this.name;
    }
}