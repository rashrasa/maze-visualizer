package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.Path;
import ca.rashrasa.mazevisualizer.building.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PathTest {
    private Path p;
    @BeforeEach
    public void init(){
        p = new Path();
        p.append(new Position(0,0));
        p.append(new Position(0,1));
    }

    @Test
    public void appendTest(){
        try{
            p.append(new Position(1,2));
        }
        catch (IllegalArgumentException ignored){}
        Path q = new Path();
        q.append(new Position(0,0));
        q.append(new Position(0,1));
        assertEquals(q.toString(), p.toString());
    }

    @Test
    public void removeTest(){
        p.remove();
        Path q = new Path();
        q.append(new Position(0,0));
        assertEquals(q.toString(),p.toString());
    }
}
