public class Threeuple<T, P, E> extends Tuple<T, P>{
    private E item3;

    public Threeuple(T item1, P item2, E item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    public void setItem3(E item3) {
        this.item3 = item3;
    }

    public E getItem3() {
        return this.item3;
    }

    @Override
    public T getItem1() {
        return super.getItem1();
    }

    @Override
    public P getItem2() {
        return super.getItem2();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getItem1());
        sb.append(" -> ");
        sb.append(getItem2());
        sb.append(" -> ");
        sb.append(getItem3());
        return sb.toString();
    }
}
