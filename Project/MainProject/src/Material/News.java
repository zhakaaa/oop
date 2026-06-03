package Material;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News {
    private String title;
    private String content;
    private Date publicationDate;
    private String author;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override public String toString() {
        return "News [title=" + title + ", content=" + content + ", publicationDate=" + publicationDate + ", author=" + author + "]";
    }

}
