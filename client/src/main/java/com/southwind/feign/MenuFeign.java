package com.southwind.feign;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//关联到另外一个微服务
@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
    //调用menu子项目的controller.MenuHandler方法
    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();
    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);
    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable long id);
    @PostMapping("/menu/update")
    public void update(Menu menu);
}
