package models;

public class GeneralNews extends News {
    private static final String scope="General News";

    public GeneralNews(String articleTitle, String articleContent, String articleAuthor, String articleScope) {
        this.articleTitle=articleTitle;
        this.articleContent=articleContent;
        this.articleAuthor=articleAuthor;
        this.articleScope=scope;

    }
}

