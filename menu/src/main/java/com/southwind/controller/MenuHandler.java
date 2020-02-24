package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.repository.MenuReqepository;
import com.southwind.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Value("{server.port}")
    private String port;

    @Autowired
    private MenuReqepository menuReqepository;
    @Autowired
    private TypeRepository typeRepository;
    @GetMapping("/index")
    public String index(){
        return "hello cloud :"+port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return new MenuVO(0,"",menuReqepository.count(),menuReqepository.findAll(index,limit));
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
            menuReqepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuReqepository.save(menu);
    }
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuReqepository.findById(id);
    }
    @PostMapping("/update")
    public void undate(@RequestBody Menu menu){
        menuReqepository.update(menu);
    }

}
