import article.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Article article1 = ArticleFactory.create("Hello", "World", "Hello World", "Hello World.");
        Article article2 = ArticleFactory.create("Hello", "Hello", "World Mega Hello", "Hello Mega World.");
        Article article3 = ArticleFactory.create("Test", "Test", "Super Test", "Hello Super Test.");

        System.out.println("Созданная статья:");
        System.out.println(article1);
        System.out.println('\n');

        String searchableId = article1.getId();
        Article searchedArticle = ArticleFactory.find(searchableId);
        System.out.println("Одна искомая статья:");
        System.out.println(searchedArticle);
        System.out.println('\n');

        List<Article> searchedArticles = ArticleFactory.findMany("Hello", null, null, null);
        System.out.println("Искомые статьи по автору:");
        System.out.println(searchedArticles);
        System.out.println('\n');

        ArticleFactory.update(searchedArticle, null, "World Hello", null, null);

        System.out.println("Все статьи:");
        System.out.println(ArticleFactory.articles);
        System.out.println('\n');
    }
}