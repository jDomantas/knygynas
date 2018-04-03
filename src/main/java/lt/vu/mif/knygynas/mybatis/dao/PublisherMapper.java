package lt.vu.mif.knygynas.mybatis.dao;

import java.util.List;
import lt.vu.mif.knygynas.mybatis.model.Publisher;
import org.mybatis.cdi.Mapper;

@Mapper
public interface PublisherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PUBLISHER
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PUBLISHER
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int insert(Publisher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PUBLISHER
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    Publisher selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PUBLISHER
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    List<Publisher> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PUBLISHER
     *
     * @mbg.generated Wed Apr 04 00:05:11 EEST 2018
     */
    int updateByPrimaryKey(Publisher record);
}