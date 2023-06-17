package edu.gdkm.controller;

import edu.gdkm.model.Goods;
import edu.gdkm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GoodsController
 * Package: edu.gdkm.controller
 * Description:
 *
 * @Author 林
 * @Create 2023/6/17 17:18
 * @Version 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    //退出登录并跳转到登录页面
    @GetMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/admin/tologin";
    }

    //首页查询全部商品
    @GetMapping(value = "/getAll")
    public String getAll(HttpServletRequest request,String uaccount,String upassword,
                         String uname,String usex,HttpSession session){
        session.setAttribute("uaccount",uaccount);
        List<Goods> goods1=new ArrayList<>();
        List<Goods> goods2=new ArrayList<>();
        List<Goods> goods3=new ArrayList<>();
        List<Goods> goods4=new ArrayList<>();
        List<Goods> oldgoods=goodsService.getAllgoods();
        for (Goods newgoods:oldgoods){
            System.out.print(newgoods.getTypes());
            switch (newgoods.getTypes()){
                case 0:
                    goods1.add(newgoods);
                    break;
                case 1:
                    goods2.add(newgoods);
                    break;
                case 2:
                    goods3.add(newgoods);
                    break;
                case 3:
                    goods4.add(newgoods);
                    break;
            }
        }
        request.setAttribute("goods1",goods1);
        request.setAttribute("goods2",goods2);
        request.setAttribute("goods3",goods3);
        request.setAttribute("goods4",goods4);
        return "index";
    }

    //商品详情:根据id查询单个商品
    @GetMapping("/detail")
    public String detail(HttpServletRequest request,int gid){
        request.setAttribute("detail",goodsService.getOnegid(gid));
        return "detail";
    }

    //商城首页搜索:根据名称模糊查询展示商品
    @GetMapping("/getOne")
    public String getOne(HttpServletRequest request,String gname){
        List<Goods> goods1=new ArrayList<>();
        List<Goods> goods2=new ArrayList<>();
        List<Goods> goods3=new ArrayList<>();
        List<Goods> goods4=new ArrayList<>();
        List<Goods> oldgoods=goodsService.getOnegoods(gname);
        for (Goods newgoods:oldgoods){
            System.out.print(newgoods.getTypes());
            switch (newgoods.getTypes()){
                case 0:
                    goods1.add(newgoods);
                    break;
                case 1:
                    goods2.add(newgoods);
                    break;
                case 2:
                    goods3.add(newgoods);
                    break;
                case 3:
                    goods4.add(newgoods);
                    break;
            }
        }
        request.setAttribute("goods1",goods1);
        request.setAttribute("goods2",goods2);
        request.setAttribute("goods3",goods3);
        request.setAttribute("goods4",goods4);
        return "index";
    }
}
