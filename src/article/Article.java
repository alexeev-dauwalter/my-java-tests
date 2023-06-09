package article;

import java.util.*;

public class Article {
    protected final String id = UUID.randomUUID().toString();
    protected String author;
    protected String title;
    protected String anons;
    protected String description;
    protected final Date date = new Date();

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    protected void setAnons(String anons) {
        this.anons = anons;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    protected Article(String author, String title, String anons, String description) {
        this.author = author;
        this.title = title;
        this.anons = anons;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article {" + '\n' +
                "  id='" + id + "'\n" +
                "  author='" + author + "'\n" +
                "  title='" + title + "'\n" +
                "  anons='" + anons + "'\n" +
                "  description='" + description + "'\n" +
                "  date=" + date + '\n' +
                '}';
    }
}
