package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.Position;
import ca.rashrasa.mazevisualizer.solving.algorithms.BFSAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position p,q;

    @BeforeEach
    public void init(){
        p = new Position(0,0);
        q = new Position(0,0);
    }

    @Test
    public void equivalenceTest(){
        assertEquals(p, q);

        //reflexivity
        assertTrue(p.equals(p));

        //instance check
        assertFalse(p.equals(new Object()));

        //null check
        assertFalse(p.equals(null));

        //symmetry
        assertEquals(q.equals(p), p.equals(q));


    }
    @Test
    public void setTest(){
        Set<Position> test = new HashSet<>();
        test.add(p);
        assertTrue(BFSAlgorithm.containsPosition(test,q));
    }
}
