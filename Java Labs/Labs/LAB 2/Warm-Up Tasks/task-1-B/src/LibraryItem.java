public abstract class LibraryItem {
    private String author;
    private String title;
    private int publicationYear;

    public LibraryItem(String author, String title, int publicationYear) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;

    }

    protected String  getAuthor(){return author;}
    protected String getTitle() {return title;}
    protected int getPublicationYear() {return publicationYear;}

    protected void setAuthor(String author){this.author = author;}
    protected void setTitle(String title){this.title = title;}
    protected void setPublicationYear(int publicationYear){this.publicationYear = publicationYear;}

    public abstract String toString();

}
