package edu.gdkm.service;

import edu.gdkm.hystrix.GoodsServiceHystrix;
import edu.gdkm.model.Cart;
import edu.gdkm.model.Goods;
import edu.gdkm.model.Userirder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName: GoodsService
 * Package: edu.gdkm.service
 * Description:
 *
 * @Author 林
 * @Create 2023/6/17 17:11
 * @Version 1.0
 */
@Component
@FeignClient(value = "b2b-goods-provider",fallback = GoodsServiceHystrix.class)
public interface GoodsService {
    @RequestMapping(value = "/getAllgoods", method = RequestMethod.GET)
    List<Goods> getAllgoods();

    @RequestMapping(value = "/getOnegoods", method = RequestMethod.GET)
    List<Goods> getOnegoods(@RequestParam(value = "gname") String gname);

    @RequestMapping(value = "/getOnegid")
    Goods getOnegid(@RequestParam(value = "gid") int gid);

    @RequestMapping(value = "updateCart", method = RequestMethod.GET)
    int updateCart(@RequestParam(value = "number") int number, @RequestParam(value = "id") int id);

    @RequestMapping(value = "/getAllcart", method = RequestMethod.GET)
    List<Cart> getAllcart(@RequestParam(value = "uid") int uid);

    @RequestMapping(value = "/intcart", method = RequestMethod.GET)
    int intcart(@RequestParam(value = "goodsname") String goodsname, @RequestParam(value = "number") int number,
                @RequestParam(value = "price") int price, @RequestParam(value = "goodid") int goodid,
                @RequestParam(value = "uid") int uid);

    @RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
    int deleteCart(@RequestParam(value = "id") int id);

    @RequestMapping(value = "insertOrder", method = RequestMethod.GET)
    int insertOrder(@RequestParam(value = "goodsname") String goodsname,
                    @RequestParam(value = "number") int number, @RequestParam(value = "price") int price,
                    @RequestParam(value = "uid") int uid);

    @RequestMapping(value = "getAllorder",method = RequestMethod.GET)
    List<Userirder> getAllorder(@RequestParam(value = "uid")int uid);
}