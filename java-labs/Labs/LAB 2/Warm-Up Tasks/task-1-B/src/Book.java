public class Book extends LibraryItem {
    private int numberOfPages;
    public Book(String author, String title, int yearOfPublication,int numberOfPages){
        super(author,title,yearOfPublication);
        this.numberOfPages = numberOfPages;
    }
    @Override public String toString() {
        return "Title: " + getTitle() + " Author: " + getAuthor() + " Pages: " + numberOfPages + " Year of Publication: " + getPublicationYear();
    }

    public boolean equals(Object that){
        if ( this == that ) return true;
        if(that == null || this.getClass() != that.getClass()) return false;
        Book thatBook = (Book) that;
        return this.numberOfPages == (((Book) that).numberOfPages);
    }
}
