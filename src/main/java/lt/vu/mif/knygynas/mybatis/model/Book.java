package lt.vu.mif.knygynas.mybatis.model;

public class Book {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    private String isbn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.TITLE
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.PUBLISHER_ID
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    private Integer publisherId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.ISBN
     *
     * @return the value of PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.ISBN
     *
     * @param isbn the value for PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.TITLE
     *
     * @return the value of PUBLIC.BOOK.TITLE
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.TITLE
     *
     * @param title the value for PUBLIC.BOOK.TITLE
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.PUBLISHER_ID
     *
     * @return the value of PUBLIC.BOOK.PUBLISHER_ID
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.PUBLISHER_ID
     *
     * @param publisherId the value for PUBLIC.BOOK.PUBLISHER_ID
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
}