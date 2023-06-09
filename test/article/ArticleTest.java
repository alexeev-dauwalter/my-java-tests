package article;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArticleTest {
    @Test
    void createArticleSuccess() {
        String author = "Иванов Иван";
        String title = "Заголовок";
        String anons = "Анонс";
        String description = "Описание";

        Article article = new Article(author, title, anons, description);

        assertNotNull(article.getId());
        assertEquals(author, article.getAuthor());
        assertEquals(title, article.getTitle());
        assertEquals(anons, article.getAnons());
        assertEquals(description, article.getDescription());
        assertNotNull(article.getDate());
    }

    @Test
    void updateArticleSuccess() {
        Article article = new Article("Иванов Иван", "Заголовок", "Анонс", "Описание");

        article.setAuthor("Петров Петр");
        article.setTitle("Обновленный заголовок");
        article.setAnons(null);
        article.setDescription("Обновленное описание");

        assertEquals("Петров Петр", article.getAuthor());
        assertEquals("Обновленный заголовок", article.getTitle());
        assertNull(article.getAnons());
        assertEquals("Обновленное описание", article.getDescription());
    }
}
