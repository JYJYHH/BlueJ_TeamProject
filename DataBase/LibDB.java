package DataBase;
import java.util.*;
import myClass.*;
/**
 * LibDB 클래스: Generic한 클래스로, 책 DB나 이용자 DB 등 다양한 데이터베이스를 관리하기 위한 클래스
 * 
 *
 * @author (2020315044 허진영, 2022320009 이상원, 2024320060 전채금)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;
    
    public LibDB(){
        db = new ArrayList<>();
    }

    public void addElement(T element){
        db.add(element);
    }

    /**
     * findElement - 주어진 id 값을 이용해 데이터베이스에서 해당 요소를 찾는 메소드.
     *
     * @param  id  학생id
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
     * 
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }
}