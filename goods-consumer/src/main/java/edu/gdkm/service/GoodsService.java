package edu.gdkm.service;

import edu.gdkm.hystrix.GoodsServiceHystrix;
import edu.gdkm.model.Goods;
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
    @RequestMapping(value = "/getAllgoods",method = RequestMethod.GET)
    List<Goods> getAllgoods();

    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    List<Goods> getOnegoods(@RequestParam(value = "gname")String gname);

    @RequestMapping(value = "/getOnegid")
    Goods getOnegid(@RequestParam(value = "gid")int gid);
}
