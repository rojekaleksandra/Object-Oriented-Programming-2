public class Laptop extends Item{
    private final String mark;

    public Laptop(int volume, String itemId, String mark){
        super(volume, itemId);
        this.mark=mark;
    }

    public Laptop(zad4.Laptop anotherLaptop){
        super(anotherLaptop);
        mark = anotherLaptop.mark;
    }

    @Override
    public String toString(){
        return "[Laptop] mark: " + this.mark + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        zad4.Laptop anotherLaptop = (zad4.Laptop) o;
        return super.equals(o) && mark.equals(anotherLaptop.mark);
    }

}