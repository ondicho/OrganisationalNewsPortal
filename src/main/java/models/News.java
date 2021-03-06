package models;

import java.util.Objects;

public abstract class News {
    public int articleId;
    public String articleTitle;
    public String articleContent;
    public String articleAuthor;
    public String articleScope;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public String getArticleScope() {
        return articleScope;
    }

    public void setArticleScope(String articleScope) {
        this.articleScope = articleScope;
    }
}
