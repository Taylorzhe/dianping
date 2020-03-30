package com.wangzhe.dianping.dal;

import com.wangzhe.dianping.model.ShopModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    int insert(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    int insertSelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    ShopModel selectByPrimaryKey(Integer id);

    List<ShopModel> selectAll();

    Integer countAllShop();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    int updateByPrimaryKeySelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Sun Mar 29 19:05:19 CST 2020
     */
    int updateByPrimaryKey(ShopModel record);
}