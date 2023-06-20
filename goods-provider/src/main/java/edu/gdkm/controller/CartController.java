package edu.gdkm.controller;

import edu.gdkm.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: CartController
 * Package: edu.gdkm.controller
 * Description:
 *
 * @Author 林
 * @Create 2023/6/18 22:40
 * @Version 1.0
 */
@RestController
public class CartController {
    @Autowired
    CartDao cartDao;

    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    int deleteCart(@RequestParam(value = "id")int id){
        return cartDao.deleteCart(id);
    }

    @RequestMapping(value = "insertOrder",method = RequestMethod.GET)
    int insertOrder(@RequestParam(value = "goodsname")String goodsname,
                    @RequestParam(value = "number")int number,@RequestParam(value = "price")int price,
                    @RequestParam(value = "uid")int uid){
        return cartDao.insertOrder(goodsname,number,price,uid);
    }
}
