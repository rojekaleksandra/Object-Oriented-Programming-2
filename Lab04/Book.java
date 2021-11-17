public class Book extends Item {
    private final String author;
    private final String title;
    public Book(int volume, String itemId, String author, String title){
        super(volume, itemId);
        this.author=author;
        this.title=title;
    }

    public Book(zad4.Book anotherBook){
        super(anotherBook);
        author = anotherBook.author;
        title = anotherBook.title;
    }

    @Override
    public String toString(){
        return "[Book] author: " + this.author + ", title: " + this.title + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o==null || o.getClass() != getClass()) return false;
        zad4.Book anotherBook = (zad4.Book) o;
        return super.equals(o) && author.equals(anotherBook.author) && title.equals(anotherBook.title);
    }
}