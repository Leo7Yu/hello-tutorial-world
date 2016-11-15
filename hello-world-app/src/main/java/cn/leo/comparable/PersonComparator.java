package cn.leo.comparable;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/** 
 * @author LeoYu 
 * @date 2016年11月9日 下午6:15:15 
 * 
 */
public class PersonComparator implements  Comparator<Person>{

    
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<Person>(new PersonComparator());
        set.add(new Person(40));
        set.add(new Person(10));
        set.add(new Person(11));
        set.add(new Person(30));
        for(Person p:set){
            System.out.println(p.getAge());
        }
    }

    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getAge()>p2.getAge()){
            return 1;
        }else if(p1.getAge()<p2.getAge()){
            return -1;
        }else{
            return 0;
        }
    }
    

}
