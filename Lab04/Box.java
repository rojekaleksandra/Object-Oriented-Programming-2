import java.util.*;

public class Box extends Item {

    private final int capacity;
    ArrayList<Item> list = new ArrayList<>();

    public Box(int volume, String itemId, int capacity){
        super(volume, itemId);
        this.capacity=capacity;
    }

    public Box(zad4.Box anotherBox){
        super(anotherBox);
        this.capacity=anotherBox.capacity;
        this.list = new ArrayList<>(anotherBox.list);
        for(int i=0;i<list.size();i++){
            if(anotherBox.list.get(i).getClass().equals(getClass())){
                list.set(i, new zad4.Box((zad4.Box) list.get(i)));
            }
        }
    }


    public void addItem(Item item){
        if(this.getClass().equals(item.getClass()) && ((zad4.Box)item).list.contains(this)){
            System.out.println("Cannot put this box into a box when a box is in this box?");
            return;
        }
        if(this.equals(item)){
            System.out.println("Cannot put box in same box?");
            return;
        }
        if (getUsedCapacity() + (getClass().equals(item.getClass()) ? ((zad4.Box) item).getUsedCapacity() + item.getVolume() : item.getVolume()) > capacity) {
            System.out.println("Cannot add more items to the box");
            return;
        }
        list.add(item);
    }

    public int getUsedCapacity(){
        int volumeSum = 0;
        for (Item item : list) {
            if (item.getClass().equals(getClass())) {
                volumeSum += ((zad4.Box) item).getUsedCapacity();
            }
            volumeSum += item.getVolume();
        }
        return volumeSum;
    }

    public void removeItem(Item item){
        for(int i=0;i<list.size();i++){
            if(getClass().equals(list.get(i).getClass())){
                ((zad4.Box) list.get(i)).removeItem(item);
            }
            if(list.get(i).equals(item)) {
                list.remove(item);
                return;
            }
        }
    }

    public boolean containsItem(Item item){
        boolean result =false;
        for (Item value : list) {
            if (getClass().equals((value.getClass()))) {
                result = ((zad4.Box) value).containsItem(item);
            }
            if (value.equals(item)) return true;
        }
        return result;
    }

    @Override
    public String toString(){
        return "[Box] capacity: " + capacity + ", items: [" + Arrays.toString(list.toArray()) + "], " + super.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        zad4.Box anotherBox = (zad4.Box) o;
        if(this.list.size() != anotherBox.list.size()) return false;
        for(int i=0;i<this.list.size();i++){
            if(!this.list.get(i).equals(anotherBox.list.get(i))) return false;
        }
        return super.equals(anotherBox) && capacity == anotherBox.capacity;
    }
}