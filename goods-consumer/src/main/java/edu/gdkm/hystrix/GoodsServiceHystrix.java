package edu.gdkm.hystrix;

import edu.gdkm.model.Goods;
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
        System.out.println("getAllgoods");
        return null;
    }

    @Override
    public List<Goods> getOnegoods(String gname) {
        return null;
    }

    @Override
    public Goods getOnegid(int gid) {
        System.out.println("getOnegid");
        return null;
    }
}
