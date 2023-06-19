package edu.gdkm.controller;

import edu.gdkm.dao.GoodsDao;
import edu.gdkm.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: GoodsController
 * Package: edu.gdkm.controller
 * Description:
 *
 * @Author 林
 * @Create 2023/6/17 16:21
 * @Version 1.0
 */
@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @RequestMapping(value = "/getAllgoods",method = RequestMethod.GET)
    public List<Goods> getAllgoods(){
        return goodsDao.getAllgoods();
    }

    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    public List<Goods> getOnegoods(@RequestParam(value = "gname")String gname){
        return goodsDao.getOnegoods(gname);
    }

    @RequestMapping(value = "/getOnegid",method = RequestMethod.GET)
    public Goods getOnegid(@RequestParam(value = "gid")int gid){
        return goodsDao.getOnegid(gid);
    }
}
