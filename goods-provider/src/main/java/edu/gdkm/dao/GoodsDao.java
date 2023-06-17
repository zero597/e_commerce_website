package edu.gdkm.dao;

import edu.gdkm.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: GoodsDao
 * Package: edu.gdkm.dao
 * Description:
 *
 * @Author 林
 * @Create 2023/6/17 16:10
 * @Version 1.0
 */
@Mapper
public interface GoodsDao {
//    查询所有商品
    List<Goods> getAllgoods();
//    根据商品名称模糊查找
    List<Goods> getOnegoods(@Param(value = "gname")String gname);
//    根据id查询单个商品详情
    Goods getOnegid(@Param(value = "gid")int gid);
}
