package models;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Objects;

public abstract class News {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private String articleAuthor;

    public News(String articleTitle, String articleContent, String articleAuthor){
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleAuthor = articleAuthor;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return articleId == news.articleId &&
                Objects.equals(articleTitle, news.articleTitle) &&
                Objects.equals(articleContent, news.articleContent) &&
                Objects.equals(articleAuthor, news.articleAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, articleTitle, articleContent, articleAuthor);
    }
}
