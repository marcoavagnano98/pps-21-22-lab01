package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList{
    private final List<Integer> circularList = new ArrayList<>();
    private int index=0;
    SelectStrategy evenStrategy;
    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(this.index == this.size()){
            this.reset();
        }
        return Optional.of(this.circularList.get(this.index++));
    }

    @Override
    public Optional<Integer> previous() {
        if(this.index < 0){
            this.index = this.size() -1;
        }
        return Optional.of(circularList.get(this.index--));
    }

    @Override
    public void reset() {
        this.index=0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> nextValue;
        for (int i = 0; i < this.size(); i++){
            nextValue = this.next();
            if(strategy.apply(nextValue.get())){
                return nextValue;
            }
        }
        return Optional.empty();
    }
}
