package lab01.tdd;

public abstract class AbstractStrategy implements SelectStrategy{
    private final int number;
    protected AbstractStrategy(final int number){
        this.number = number;
    }
    protected int getNumber(){
        return number;
    }
    public boolean apply(int element){
        return element % number == 0;
    }
}
