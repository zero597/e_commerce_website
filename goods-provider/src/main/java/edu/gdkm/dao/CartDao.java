package edu.gdkm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: CartDao
 * Package: edu.gdkm.dao
 * Description:
 *
 * @Author 林
 * @Create 2023/6/18 22:32
 * @Version 1.0
 */
@Mapper
public interface CartDao {
    /**
     * 根据id删除订单
     */
    int deleteCart(@Param(value = "id")int id);

    /**
     * 购买商品后添加一条订单数据
     */
    int insertOrder(@Param(value = "goodsname")String goodsname,
                    @Param(value = "number")int number,@Param(value = "price")int price,
                    @Param(value = "uid")int uid);
}
