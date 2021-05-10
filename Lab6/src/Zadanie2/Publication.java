package Zadanie2;

public class Publication {
    private String key;
    private String itemType;
    private String year;
    private String author;
    private String title;
    private String publicationtitle;
    private String ISBN;
    private String ISSN;
    private String DOI;
    private String date;

    public String getKey() {
        return key;
    }

    public String getItemType() {
        return itemType;
    }

    public String getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationtitle() {
        return publicationtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getDOI() {
        return DOI;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "key='" + key + '\'' +
                ", itemType='" + itemType + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationtitle='" + publicationtitle + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", ISSN='" + ISSN + '\'' +
                ", DOI='" + DOI + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Publication(String key, String itemType, String year, String author, String title, String publicationTitle, String ISBN, String ISSN, String DOI, String date) {
        this.key = key;
        this.itemType = itemType;
        this.year = year;
        this.author = author;
        this.title = title;
        this.publicationtitle = publicationTitle;
        this.ISBN = ISBN;
        this.ISSN = ISSN;
        this.DOI = DOI;
        this.date = date;
    }
}
