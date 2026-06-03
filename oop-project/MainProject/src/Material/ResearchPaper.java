package Material;

import java.util.Date;
import java.util.List;

public class ResearchPaper {
    private String author;
    private String title;
    private Date publicationDate;
    private int pageCount;
    private List<String> citations;
    // changes
    private int citationId;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCitationId() {
        return citationId;
    }

    public void setCitations(int citations) {
        this.citationId = citations;
    }

    public String getCitation(String format) {
        return String.join(", ", citations);
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", pageCount=" + pageCount +
                ", citations=" + citations +
                '}';
    }
}

