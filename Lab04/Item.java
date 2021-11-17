public abstract class Item{
    private final int volume;
    private final String itemId;

    public Item(int volume, String itemId){
        this.volume=volume;
        this.itemId=itemId;
    }

    public Item(zad4.Item anotherItem){
        this(anotherItem.volume, anotherItem.itemId);
    }

    public int getVolume(){
        return volume;
    }

    @Override
    public String toString(){
        return "ID: " + this.itemId + ", volume: " + this.volume;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        zad4.Item anotherItem = (zad4.Item) o;
        return volume == anotherItem.volume && itemId.equals(anotherItem.itemId);
    }


}