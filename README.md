# 启动流程
1.eurekaserver->configserver->menu->user->order->account->client



eurekaserver //注册中心
configserver //配置中心

user、order、menu、account //服务提供者

client 服务消费者

前端页面在client.src.main.resources.static

示例： client调用menu过程

服务消费者client只负责前后端交互 页面跟controller.MenuHandler交互 然后调用feign.MenuFeign 然后feigan在调用服务提供者menu 到menu.controller.MenuHandler的业务方法再来调用
repository 然后repository再去访问mappimg.xml文件 再去访问数据库 完成对数据的管理
由menu提供数据交互