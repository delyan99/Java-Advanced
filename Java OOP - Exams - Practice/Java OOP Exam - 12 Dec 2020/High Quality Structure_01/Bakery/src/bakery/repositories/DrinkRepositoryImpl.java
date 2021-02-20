package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private List<Drink> drinks;

    public DrinkRepositoryImpl(){
        this.drinks = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink : drinks) {
            if(drink.getBrand().equals(drinkBrand) && drink.getName().equals(drinkName)){
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(drinks);
    }

    @Override
    public void add(Drink drink) {
        drinks.add(drink);
    }
}
