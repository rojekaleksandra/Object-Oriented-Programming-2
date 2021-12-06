import java.util.Objects;
import java.util.Random;

public class Vampire {
    private int x;
    private int y;

    public Vampire(int maxX, int maxY) {
        randomize(maxX, maxY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction, int maxX, int maxY) {
        if(x+direction.getX()>0 && x+direction.getX()<maxX )
            x+=direction.getX();
        if (y-direction.getY()>0 && y-direction.getY()<maxY)
            y-=direction.getY();
    }

    public void randomize(int maxX, int maxY) {
        Random r= new Random();
        this.x = r.nextInt(maxX);
        this.y = r.nextInt(maxY);
    }

    public boolean isDifferentThanCoordinates(Vampire vampire) {
        return isDifferentThanCoordinates(vampire.getX(), vampire.getY());
    }

    public boolean isDifferentThanCoordinates(int x, int y) {
        if(this.x == x && this.y ==y) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vampire))
            return false;
        Vampire vampire = (Vampire) o;
        return getX() == vampire.getX() && getY() == vampire.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "v " + y + ", " + x;
    }
}
