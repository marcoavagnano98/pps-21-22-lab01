import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList list;
    private EvenStrategy evenStrategy;
    private MultipleOfStrategy multipleOfStrategy;
    private EqualsStrategy equalsStrategy;

    //TODO: test implementation

    @BeforeEach
    public void init(){
        this.list =new SimpleCircularList();
        this.evenStrategy = new EvenStrategy();
        this.multipleOfStrategy = new MultipleOfStrategy(5);
        this.equalsStrategy = new EqualsStrategy(10);
    }
    @Test
    public void testEmpty(){
        assertTrue(list.isEmpty());
    }
    @Test
    public void testNext(){
        list.add(0);
        list.add(1);
        assertEquals(Optional.of(0),list.next());
        assertEquals(Optional.of(1),list.next());
    }

    @Test
    public void testPrevious(){
        list.add(0);
        list.add(1);
        list.next();
        assertEquals(Optional.of(1),list.previous());
        assertEquals(Optional.of(0),list.previous());
    }
    @Test
    public void testReset(){
        list.add(0);
        list.next();
        list.add(1);
        list.next();
        list.reset();
        assertEquals(Optional.of(0),list.next());
    }
    @Test
    public void testEvenStrategy(){
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(4);
        assertEquals(Optional.of(4),list.next(evenStrategy));
    }
    @Test
    public void testMultipleOfStrategy(){
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(10);
        assertEquals(Optional.of(5),list.next(multipleOfStrategy));
    }
    @Test
    public void testEqualsStrategy(){
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(10);
        assertEquals(Optional.of(10),list.next(equalsStrategy));
    }
}
