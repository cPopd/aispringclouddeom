package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;
    @GetMapping("/index")
    public String index(){
        return "hello spring cloud ip:"+this.port;
    }

    @Autowired
    private OrderRepository orderRepository;
    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }
    @GetMapping("/findAllByUId/{index}/{limit}/{uid}")
    public OrderVO findAllByUId(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid")long uid){
        OrderVO orderVO=new OrderVO();
        orderVO.setMsg("");
        orderVO.setCode(0);
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUId(index,limit,uid));
        return orderVO;
    }
    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid")int uid){
        return orderRepository.countByUid(uid);
    }

}
