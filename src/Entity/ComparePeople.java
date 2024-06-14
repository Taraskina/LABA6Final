package Entity;

import java.util.Comparator;

public class ComparePeople implements Comparator<Entity.Person> {
    @Override
    public int compare(Entity.Person p1, Person p2){
        return p1.getName().length() - p2.getName().length();
    }
}
