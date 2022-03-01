package lab01.tdd;

public class EqualsStrategy extends AbstractStrategy{

    public EqualsStrategy(final int value) {
        super(value);
    }
    @Override
    public boolean apply(int element) {
        return element == super.getNumber();
    }
}
