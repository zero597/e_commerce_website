package edu.gdkm.hystrix;

import edu.gdkm.model.Cart;
import edu.gdkm.model.Goods;
import edu.gdkm.model.Userirder;
import edu.gdkm.service.GoodsService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: GoodsServiceHystrix
 * Package: edu.gdkm.hystrix
 * Description:
 *
 * @Author 林
 * @Create 2023/6/17 17:16
 * @Version 1.0
 */
@Component
public class GoodsServiceHystrix implements GoodsService {
    @Override
    public List<Goods> getAllgoods() {
        return null;
    }

    @Override
    public List<Userirder> getAllorder(int uid) {
        return null;
    }

    @Override
    public List<Goods> getOnegoods(String gname) {
        return null;
    }

    @Override
    public Goods getOnegid(int gid) {
        return null;
    }

    @Override
    public int updateCart(int number, int id) {
        return 0;
    }

    @Override
    public List<Cart> getAllcart(int uid) {
        return null;
    }

    @Override
    public int intcart(String goodsname, int number, int price, int goodid, int uid) {
        return 0;
    }

    @Override
    public int deleteCart(int id) {
        return 0;
    }

    @Override
    public int insertOrder(String goodsname, int number, int price, int uid) {
        return 0;
    }
}
