package myClass; //패키지 337p
/**
 * User 클래스의 설명을 작성하세요.
 * 이용자 객체를 나타내는 User 클래스
 * 속성 2개 메소드 3개
 *x
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class User extends DB_Element
{
    // 속성 2개 입력 전부 private 222p
    // Wrapper 클래스 360p
    private String name;
    private Integer stID;
    /**
     * User 클래스의 객체 생성자 파라미터2개 (의미가 드러나도록) this 레퍼런스 190p,197p
     */
    public User(int stID, String name)
    {
        this.name = name;
        this. stID = stID;
    }
    /**
     * 추상 클래스 DB_Element를 상속받아 getID()를 오버라이딩 299p
     * 기본 타입 값을 문자열로 변환 362p
     */
    public String getID(){
        return Integer.toString(stID);
    }
    /**
     * Object 클래스의 메소드 String toString() 오버라이딩 351p
     * 현 객체에 대한 문자열 표현을 리턴
     *  
     */
    public String toString(){
        return "[" + this.stID + "]" + this.name;
    }
}