public class Main {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("Robert Grin", "48 Laws of Power",1998,480);
        LibraryItem book2 = new Book("Leo Tolstoy", "War and Peace",1867,1225);
        LibraryItem book3 = new Book("Hilary Mantel", "Wolf Hall",2009,672);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());


    }
}