import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
    private int moves;
    private List<Vampire> vampires;
    private int playerX;
    private int playerY;
    private final int maxX;
    private final int maxY;
    private final char[][] map;
    private final int numberOfVampires;

    public Dungeon(int maxX, int maxY, int numberOfVampires, int moves) {
        this.maxX = maxX;
        this.maxY = maxY;
        map = new char[maxX][maxY + 1];
        this.moves = moves;
        vampires = new ArrayList<Vampire>();
        addVampires(numberOfVampires);
        this.numberOfVampires = numberOfVampires;
    }

    public void reload() {
        this.vampires.clear();
        this.playerX=0;
        this.playerY=0;
        this.moves=10;
        this.vampires=new ArrayList<>();
        addVampires(numberOfVampires);

    }

    public int getMoves() {
        return moves;
    }

    public void printStatus() {
        System.out.println("Current coordinates: (" + playerX + ", " + playerY + ")");
        if (vampires != null)
            vampires.forEach(System.out::println);
        System.out.println("Moves left: " + moves);
    }

    public void refreshMap() {
        moveVampires();
        checkStatus();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                map[i][j] = '.';
            }
            map[i][maxY] = '\n';
        }
        for(Vampire i : vampires){
            map[i.getY()][i.getX()]='v';
        }
        map[playerY][playerX]='@';
    }

    public void drawMap() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    public boolean isItWin() {
        return vampires != null && vampires.size() == 0;
    }

    public void movePlayer(Direction direction) {
        if(playerX+direction.getX()>=0 && playerX+direction.getX()<maxX )
            playerX+=direction.getX();
        if (playerY-direction.getY()>=0 && playerY-direction.getY()<maxY)
            playerY-=direction.getY();
        this.moves--;
    }

    private void checkStatus() {
        List<Vampire> v = new ArrayList<>();
        for(Vampire i : vampires){
            if(playerX == i.getX() && playerY == i.getY())
                v.add(i);
        }
        vampires.removeAll(v);
    }

    private void moveVampires() {
        int r = new Random().nextInt(4);
        for(Vampire v : vampires){
            if(Math.random() > 0.5){
                switch(r){
                    case 0:
                        v.move(Direction.LEFT, maxX, maxY);
                    case 1:
                        v.move(Direction.RIGHT, maxX, maxY);
                    case 2:
                        v.move(Direction.UP, maxX, maxY);
                    case 3:
                        v.move(Direction.DOWN, maxX, maxY);
                }
            }
        }
    }

    private void addVampires(int number) {
        while(number>0){
            Vampire v = new Vampire(maxX, maxY);
            if(v.getX() != 0 && v.getY() !=0 ){
                if(vampires.isEmpty()){
                    vampires.add(new Vampire(maxX, maxY));
                    number--;
                }else if(vampires.get(0).getX() != v.getX() && vampires.get(0).getY() != v.getY()){
                    vampires.add(new Vampire(maxX, maxY));
                    number--;
                }
            }
        }
    }
}
