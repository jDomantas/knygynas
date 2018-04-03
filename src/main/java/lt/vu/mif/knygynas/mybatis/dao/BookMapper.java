package lt.vu.mif.knygynas.mybatis.dao;

import java.util.List;
import lt.vu.mif.knygynas.mybatis.model.Book;
import org.mybatis.cdi.Mapper;

@Mapper
public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int deleteByPrimaryKey(String isbn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int insert(Book record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    Book selectByPrimaryKey(String isbn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    List<Book> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.BOOK
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int updateByPrimaryKey(Book record);
}