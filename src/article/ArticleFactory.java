package article;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

abstract public class ArticleFactory {
    public static List<Article> articles = new ArrayList<>();

    public static Article create(String author, String title, String anons, String description) {
        Article article = new Article(author, title, anons, description);
        articles.add(article);
        return article;
    }

    public static Article find(String id) {
        for (Article article : articles) {
            if (Objects.equals(article.id, id)) return article;
        }

        return null;
    }

    public static List<Article> findMany(String author, String title, String anons, String description) {
        List<Article> foundArticles = new ArrayList<>();

        for (Article article : articles) {
            if (author != null && !Objects.equals(article.author, author)) continue;
            if (title != null && !Objects.equals(article.title, title)) continue;
            if (anons != null && !Objects.equals(article.anons, anons)) continue;
            if (description != null && !Objects.equals(article.description, description)) continue;

            foundArticles.add(article);
        }

        return foundArticles;
    }

    public static void update(Article article, String author, String title, String anons, String description) {
        if (article != null) {
            if (author != null) article.author = author;
            if (title != null) article.title = title;
            if (anons != null) article.anons = anons;
            if (description != null) article.description = description;
        }
    }

    public static Article delete(String id) {
        Article article = find(id);

        if (article != null) articles.remove(article);

        return article;
    }
}
