package edu.gdkm.controller;

import edu.gdkm.dao.ShoppingDao;
import edu.gdkm.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: ShoppingCart
 * Package: edu.gdkm.controller
 * Description:
 *
 * @Author 林
 * @Create 2023/6/18 15:45
 * @Version 1.0
 */
@RestController
public class ShoppingCart {
    @Autowired
    ShoppingDao shoppingDao;

    @RequestMapping(value = "/getAllcart",method = RequestMethod.GET)
    public List<Cart> getAllcart(@RequestParam(value = "uid")int uid){
        return shoppingDao.getAllcart(uid);
    }

    @RequestMapping(value = "/intcart",method = RequestMethod.GET)
    public int intcart(@RequestParam(value = "goodsname")String goodsname,@RequestParam(value = "number")int number,
                       @RequestParam(value = "price")int price,@RequestParam(value = "goodid")int goodid,
                       @RequestParam(value = "uid")int uid){
        return shoppingDao.intcart(goodsname,number,price,goodid,uid);
    }

    @RequestMapping(value = "/updateCart",method = RequestMethod.GET)
    public int updateCart(@RequestParam(value = "number")int number,@RequestParam(value = "id")int id){
        return shoppingDao.updateCart(number,id);
    }
}
