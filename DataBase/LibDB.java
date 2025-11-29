package DataBase; //패키지 337p
import java.util.*;
import myClass.*;
/**
 * LibDB 클래스: Generic한 클래스로(P.436), 책 DB나 이용자 DB 등 다양한 데이터베이스를 관리하기 위한 클래스
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.10.17)
 */
public class LibDB<T extends DB_Element>
{
    // 속성 1개 입력, 접근지정자는 private 222p
    private ArrayList<T> db;
    /**
     * LibDB 클래스의 생성자 
     *  (생성자 선언 190p), (ArryList 생성 418p)
     */
    public LibDB(){
        db = new ArrayList<>();
    }
    
    /**
     * addElement: 입력받은 요소를 제네릭한 DB에 저장하는 메소드
     *             ArrayList에 요소 삽입 418p 
     *
     * @param  element DB에 삽입할 요소
     */
    public void addElement(T element){
        db.add(element);
    }
    
    /**
     * findElement - 주어진 id 값을 이용해 데이터베이스에서 해당 요소를 찾는 메소드.
     *               (if문 94p), (equals메소드 356p), (Iterator 422p)
     *
     * @param  id  
     * @return  해당 id를 가진 요소, 없으면 null 반환 
     */
    public T findElement(String id)
    {
        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T element = it.next();
            if (element.getID().equals(id)) {
                return element;
            }
        }
        return null;
    }
    
    /**
     * printAllElements - 데이터베이스에 저장된 모든 요소를 출력하는 메소드.
     *                    for-each문 137p
     * 
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }
}