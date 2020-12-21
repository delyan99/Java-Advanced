import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> childrens;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }
}
