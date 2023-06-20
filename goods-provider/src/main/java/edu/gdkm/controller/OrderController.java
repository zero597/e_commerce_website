package edu.gdkm.controller;

import edu.gdkm.dao.OrderDao;
import edu.gdkm.model.Userirder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: OrderController
 * Package: edu.gdkm.controller
 * Description:
 *
 * @Author 林
 * @Create 2023/6/19 18:33
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @RequestMapping(value = "getAllorder",method = RequestMethod.GET)
    public List<Userirder> getAllorder(@RequestParam(value = "uid")int uid){
        return orderDao.getAllorder(uid);
    }


}
