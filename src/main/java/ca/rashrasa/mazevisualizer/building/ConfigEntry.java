package ca.rashrasa.mazevisualizer.building;

public class ConfigEntry {
    private boolean open;
    private int dist;

    public ConfigEntry(boolean open, int dist){
        this.open=open;
        this.dist=dist;
    }

    public int getDist() {
        return dist;
    }

    public boolean isOpen() {
        return open;
    }

    public String toString(){
        return this.open? "("+"O"+", "+ this.dist+")":
                          "("+"B"+", "+ this.dist+")";
    }
}
