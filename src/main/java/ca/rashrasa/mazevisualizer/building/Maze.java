package ca.rashrasa.mazevisualizer.building;

/**
 * Immutable n*m-sized maze implemented as a boolean 2D array.
 * Contains one opening on the West and East borders and
 * no openings on the North and South borders.
 */
public class Maze {
    private int width;
    private int height;
    private int start;
    private int end;

    private final boolean[][] isOpen;
    private final String configuration;

    public Maze(MazeConfiguration configuration){
        this.configuration=configuration.toString();

        this.height=configuration.getHeight();
        this.width=configuration.getWidth();
        this.start=configuration.getStartY();
        this.end=configuration.getEndY();

        this.isOpen=new boolean[height][width];

        //initialize entrance/exit
        for (int i=0; i<this.height; i++){
            this.isOpen[i][0] = height-1-start == i;
            this.isOpen[i][width-1] = height-1-end == i;
        }

        //initialize North/South borders
        for (int i=0; i<this.width; i++){
            this.isOpen[0][i] = false;
            this.isOpen[height-1][i] = false;
        }

        //initialize maze
        int currentLine = 1;
        int currentElement = 1;
        int numPositionsProvided = 0;
        for (ConfigEntry entry: configuration.getMazeEntries()){
            for(int k=0; k<entry.getDist(); k++){
                this.isOpen[currentLine][currentElement]=entry.isOpen();
                currentElement++;
                numPositionsProvided++;
                if(currentElement>width-2){
                    currentElement=1;
                    currentLine++;
                }
            }
        }

        //maze requires info for (width-2)*(height-2) positions (all, excluding the borders)
        if(numPositionsProvided!= (width-2)*(height-2)){
            throw new IllegalArgumentException("Not enough information provided to generate maze.");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Position getStart() {
        return new Position(0, start);
    }

    public Position getEnd() {
        return new Position(width-1, end);
    }

    public String getConfiguration(){
        return this.configuration;
    }
    public boolean isBlocked(Position p){
        boolean blocked;
        try{
            blocked =!isOpen[height-p.y()-1][p.x()];
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Position entered is outside the maze.");
        }
        return blocked;
    }
    public boolean isInBounds(Position p){
        return p.x()>=0 && p.x()<width && p.y()>=0 && p.y()<height;
    }

    public String toString(){
        StringBuilder mazeString = new StringBuilder();
        for(int i=0; i<isOpen.length;i++){
            for (int j=0; j<isOpen[i].length;j++){
                if(isOpen[i][j]){
                    mazeString.append(" ");
                }
                else{
                    mazeString.append("*");
                }
            }
            mazeString.append("\n");
        }
        return mazeString.toString();
    }

}
