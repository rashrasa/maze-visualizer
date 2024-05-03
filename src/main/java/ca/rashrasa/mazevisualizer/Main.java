package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.Maze;
import ca.rashrasa.mazevisualizer.building.MazeConfiguration;

public class Main {
    public static void main(String [] args){
        System.out.println("Running CLI maze visualizer...");
        Maze maze = new Maze(new MazeConfiguration("5$5$2$2$B#3$O#3$B#3$"));
        System.out.println(maze);
        System.out.println("Done");
    }
}
