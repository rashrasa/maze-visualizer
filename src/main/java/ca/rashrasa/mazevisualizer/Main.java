package ca.rashrasa.mazevisualizer;

import ca.rashrasa.mazevisualizer.building.ConfigEntry;
import ca.rashrasa.mazevisualizer.building.Maze;
import ca.rashrasa.mazevisualizer.building.MazeConfiguration;
import ca.rashrasa.mazevisualizer.solving.SolutionSequence;
import ca.rashrasa.mazevisualizer.solving.algorithms.BFSAlgorithm;
import ca.rashrasa.mazevisualizer.solving.algorithms.SearchAlgorithm;

public class Main {
    public static void main(String [] args){
        System.out.println("Running CLI maze visualizer...");
        Maze maze = new Maze(
                new MazeConfiguration(
                        6,
                        6,
                        2,
                        2,
                        new ConfigEntry[]{
                                new ConfigEntry(false,1),
                                new ConfigEntry(true,2),
                                new ConfigEntry(false,1),
                                new ConfigEntry(true,1),
                                new ConfigEntry(false,1),
                                new ConfigEntry(true,1),
                                new ConfigEntry(false,1),
                                new ConfigEntry(true,1),
                                new ConfigEntry(false,1),
                                new ConfigEntry(true,4),
                                new ConfigEntry(false,3)
                        }
                        )
        );
        System.out.println(maze);
        SearchAlgorithm runner = new BFSAlgorithm();
        SolutionSequence search = runner.getSolution(maze);
        System.out.println("Path: " + search.getShortestPath().toString());
        System.out.println("Done");
    }
}
