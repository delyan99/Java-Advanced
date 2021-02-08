package rpg_lab;

import java.util.Iterator;
import java.util.List;

public class HeroInventory implements Iterable{
    private List<Weapon> possibleLoot;
    @Override
    public Iterator iterator() {
        return possibleLoot.iterator();
    }
}
