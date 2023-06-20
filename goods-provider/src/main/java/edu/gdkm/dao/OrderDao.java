package edu.gdkm.dao;

import edu.gdkm.model.Userirder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: OrderDao
 * Package: edu.gdkm.dao
 * Description:
 *
 * @Author 林
 * @Create 2023/6/19 18:27
 * @Version 1.0
 */
@Mapper
public interface OrderDao {
    /**
     * 查询所有订单
     */
    List<Userirder> getAllorder(@Param(value = "uid")int uid);


}
