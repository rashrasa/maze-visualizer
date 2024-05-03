package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.ConfigEntry;
import ca.rashrasa.mazevisualizer.building.MazeConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeConfigurationTest {
    @Test
    public void constructorTest(){
        MazeConfiguration c0 = new MazeConfiguration(0,0,0,0,
                new ConfigEntry[]{new ConfigEntry(true, 9)});
        MazeConfiguration c1 = new MazeConfiguration("0$0$0$0$O#9$");

        assertEquals(c0.toString(), c1.toString());
    }
}
