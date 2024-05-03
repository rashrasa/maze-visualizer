package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.ConfigEntry;
import ca.rashrasa.mazevisualizer.building.Maze;
import ca.rashrasa.mazevisualizer.building.MazeConfiguration;
import ca.rashrasa.mazevisualizer.building.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MazeTest {
    Maze maze;
    @BeforeEach
    public void init(){

    }

    @Test
    public void formatTest(){
        this.maze=new Maze(new MazeConfiguration(
                5,
                5,
                2,
                2,
                new ConfigEntry[]{new ConfigEntry(true,9)}
        ));
        System.out.println(this.maze);
        assertFalse(this.maze.isBlocked(new Position(2,2)));
    }

}
