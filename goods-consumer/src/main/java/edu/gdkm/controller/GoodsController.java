package edu.gdkm.controller;

import edu.gdkm.model.Cart;
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
        request.setAttribute("goods1",goods3);
        request.setAttribute("goods2",goods2);
        request.setAttribute("goods3",goods1);
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
    public String getOne(HttpServletRequest request,String name){
        List<Goods> goods1=new ArrayList<>();
        List<Goods> goods2=new ArrayList<>();
        List<Goods> goods3=new ArrayList<>();
        List<Goods> goods4=new ArrayList<>();
        List<Goods> oldgoods=goodsService.getOnegoods(name);
        for (Goods newgoods:oldgoods){
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

    /**
     *加入购物车-将商品加入购物车之前先查询购物车是否有此商品，如果有就修改商品数量，如果没有就添加商品
     */
    @GetMapping(value = "cart")
    public String cart(HttpServletRequest request,String name,String price,
                       String che,String number,HttpSession session){
        String uid=(String) session.getAttribute("uaccount");
        List<Cart> usercart=goodsService.getAllcart(Integer.parseInt(uid));
        int n=Integer.parseInt(price);
        for (int i = 0; i < usercart.size(); i++) {
            if(usercart.get(i).getGoodid()==Integer.parseInt(che)){
                goodsService.updateCart(Integer.parseInt(number),usercart.get(i).getId());
                return "redirect:/goods/cartAll";
            }
        }
        goodsService.intcart(name,Integer.parseInt(number),n,
                Integer.parseInt(che),Integer.parseInt(uid));
        return "redirect:/goods/cartAll";
    }

    /**
     * 查询购物车全部商品
     */
    @GetMapping(value = "/cartAll")
    public String cartAll(HttpServletRequest request,HttpSession session){
        String uid= (String) session.getAttribute("uaccount");
        request.setAttribute("carts",goodsService.getAllcart(Integer.parseInt(uid)));
        return "Settle";
    }

    /**
     * 删除购物车：根据id删除购物车商品
     */
    @GetMapping(value = "/deleteCart")
    public String deleteCart(HttpServletRequest request,String did){
        goodsService.deleteCart(Integer.parseInt(did));
        return "/redirect:/goods/cartAll";
    }

    /**
     * 添加订单并调用删除购物车功能-购买后删除购物车该商品信息
     */
    @GetMapping(value = "/paygoods")
    public String paygoods(HttpServletRequest request,HttpSession session,String[] goodid,
                           String[] numaa,String[] id){
        String uid=(String) session.getAttribute("uaccount");
        if(goodid.length==0||numaa.length==0||id.length==0){
            return "redirect:/goods/cartAll";
        }else {
            for (int i = 0; i < goodid.length; i++) {
                goodsService.insertOrder(goodsService.getOnegid(Integer.parseInt(goodid[i])).getGname(),
                        Integer.parseInt(numaa[i]),Integer.parseInt(numaa[i])*
                        goodsService.getOnegid(Integer.parseInt(goodid[i])).getGprice(),Integer.parseInt(uid));
                goodsService.deleteCart(Integer.parseInt(id[i]));
            }
            request.setAttribute("mag3","购买失败");
            return "redirect:/goods/getAllorder";
        }

    }

    /**
     * 根据查询用户登录者的历史购买记录
     */
    @GetMapping(value = "getAllorder")
    public String getAllorder(HttpServletRequest request,HttpSession session){
        String uid=(String) session.getAttribute("uaccount");
        request.setAttribute("order",goodsService.getAllorder(Integer.parseInt(uid)));
        if(uid==null){
            return "redirect:http://localhost:8893/admin/tologin";
        }
        return "order";
    }
}
