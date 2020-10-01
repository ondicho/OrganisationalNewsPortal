package models;


public class DepartmentNews extends News{
    private static final String scope="Department News";

    public DepartmentNews(String articleTitle, String articleContent, String articleAuthor, String articleScope) {
        this.articleTitle=articleTitle;
        this.articleContent=articleContent;
        this.articleAuthor=articleAuthor;
        this.articleScope=scope;

    }

    public static String getScope() {
        return scope;
    }

}
