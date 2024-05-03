package ca.rashrasa.mazevisualizer.building;

import java.util.ArrayList;
import java.util.List;

public class MazeConfiguration {
    private int height;
    private int width;
    private int startY;
    private int endY;
    private ArrayList<ConfigEntry> mazeEntries;
    /*
     * String representation of maze:
     * "height$width$start$end$maze"
     * where:
     *    - height is the height of the maze as an integer
     *    - width is the width of the maze as an integer
     *    - start is the y position of the starting position (x=0)
     *    - end is the y position of the end position (x=width-1)
     *    - maze is:
     *        - from x=1 to x=width-2, from line=1 to line=height-2
     *        - representing the maze from left to right, line by line
     *        - B#X$ where X is the number of consecutive blocked positions
     *        - O#Y$ where Y is the number of consecutive open positions
     *        - repeated until exactly all positions are covered
     */

    //String format will only be used in GUI to be copied and pasted
    public MazeConfiguration(String configuration){
        //logger.debug("PARSING MAZE: Parsing attributes...");
        String [] config = configuration.split("\\$");

        this.mazeEntries=new ArrayList<>();
        this.height=Integer.parseInt(config[0]);
        this.width=Integer.parseInt(config[1]);
        this.startY=Integer.parseInt(config[2]);
        this.endY=Integer.parseInt(config[3]);


        String [] ident;
        //for each identifier ({B,X} or {O,Y})
        for(int i =4; i<config.length; i++){
            System.out.println("Parsing "+config[i]);
            ident = config[i].split("#");
            switch (ident[0]) {
                case "B" -> mazeEntries.add(new ConfigEntry(false, Integer.parseInt(ident[1])));
                case "O" -> mazeEntries.add(new ConfigEntry(true, Integer.parseInt(ident[1])));
                default -> throw new IllegalArgumentException("Invalid configuration string format.");
            }
        }
    }


    public MazeConfiguration(int height, int width, int startY, int endY, ConfigEntry[] mazeEntries){

        this.height=height;
        this.width=width;
        this.startY=startY;
        this.endY=endY;

        this.mazeEntries=new ArrayList<>();
        this.mazeEntries.addAll(List.of(mazeEntries));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndY() {
        return endY;
    }

    public ConfigEntry[] getMazeEntries(){
        ConfigEntry [] entries = new ConfigEntry[mazeEntries.size()];
        for (int i=0; i<entries.length;i++){
            entries[i]=mazeEntries.get(i);
        }
        return entries;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("$").append(this.height);
        s.append("$").append(this.width);
        s.append("$").append(this.startY);
        s.append("$").append(this.endY);
        s.append("$");
        for(ConfigEntry entry: this.mazeEntries){
            String toAppend = entry.isOpen()?"O#"+entry.getDist():
                                             "B#"+entry.getDist();
            s.append(toAppend).append("$");
        }
        return s.toString();
    }

}
