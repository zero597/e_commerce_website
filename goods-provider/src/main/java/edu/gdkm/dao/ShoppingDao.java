package edu.gdkm.dao;

import edu.gdkm.model.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: ShoppingDao
 * Package: edu.gdkm.dao
 * Description:
 *  购物车接口
 * @Author 林
 * @Create 2023/6/18 15:29
 * @Version 1.0
 */
@Mapper
public interface ShoppingDao {
    /**
     * 查询用户购物车所有商品
     * @param uid 用户id
     * @return
     */
    List<Cart> getAllcart(@Param(value = "uid")int uid);

    /**
     * 插入一条购物车记录
     * @param goodsname
     * @param number
     * @param price
     * @param goodid
     * @param uid
     * @return
     */
    int intcart(@Param(value = "goodsname")String goodsname,@Param(value = "number")int number,
                @Param(value = "price")int price,@Param(value = "goodid")int goodid,@Param(value = "uid")int uid);

    /**
     * 修改购物车商品数量
     */
    int updateCart(@Param(value = "number")int number,@Param(value = "id")int id);
}
