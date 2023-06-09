package article;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArticleFactoryTest {
    @BeforeEach
    void setUp() {
        ArticleFactory.articles.clear();
    }

    @Test
    void createArticleSuccess() {
        Article article = ArticleFactory.create("Иванов Иван", "Заголовок", "Анонс", "Описание");

        assertNotNull(article);
        assertEquals("Иванов Иван", article.getAuthor());
        assertEquals("Заголовок", article.getTitle());
        assertEquals("Анонс", article.getAnons());
        assertEquals("Описание", article.getDescription());
        assertTrue(ArticleFactory.articles.contains(article));
    }

    @Test
    void findArticleByIdSuccess() {
        Article article = ArticleFactory.create("Иванов Иван", "Заголовок", "Анонс", "Описание");

        Article foundArticle = ArticleFactory.find(article.getId());

        assertNotNull(foundArticle);
        assertEquals(article, foundArticle);
    }

    @Test
    void findManyArticlesSuccess() {
        Article article1 = ArticleFactory.create("Иванов Иван", "Заголовок 1", "Анонс 1", "Описание 1");
        Article article2 = ArticleFactory.create("Иванов Иван", "Заголовок 2", "Анонс 2", "Описание 2");
        ArticleFactory.create("Петров Петр", "Заголовок 3", "Анонс 3", "Описание 3");

        List<Article> foundArticles = ArticleFactory.findMany("Иванов Иван", null, null, null);

        assertNotNull(foundArticles);
        assertEquals(2, foundArticles.size());
        assertTrue(foundArticles.contains(article1));
        assertTrue(foundArticles.contains(article2));
    }

    @Test
    void updateArticleSuccess() {
        Article article = ArticleFactory.create("Иванов Иван", "Заголовок", "Анонс", "Описание");

        ArticleFactory.update(article, "Петров Петр", "Обновленный заголовок", null, "Обновленное описание");

        assertEquals("Петров Петр", article.getAuthor());
        assertEquals("Обновленный заголовок", article.getTitle());
        assertEquals("Обновленный анонс", article.getAnons());
        assertEquals("Обновленное описание", article.getDescription());
    }

    @Test
    void deleteArticleSuccess() {
        Article article = ArticleFactory.create("Иванов Иван", "Заголовок", "Анонс", "Описание");

        Article deletedArticle = ArticleFactory.delete(article.getId());

        assertNotNull(deletedArticle);
        assertEquals(article, deletedArticle);
        assertFalse(ArticleFactory.articles.contains(article));
    }

    @Test
    void deleteArticleNotFound() {
        Article deletedArticle = ArticleFactory.delete("nonexistent_id");

        assertNull(deletedArticle);
    }
}
