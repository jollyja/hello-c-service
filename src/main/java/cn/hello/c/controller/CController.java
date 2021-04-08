package cn.hello.c.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CController {

    @NacosValue(value = "${whoami:unkonwn}", autoRefreshed = true)
    private String whoami;

    @NacosInjected
    private NamingService namingService;

    @PostMapping(path = "/c/confirm")
    public Map<String, String> confirm(@RequestBody Map<String, String> req) throws NacosException {
        Map<String, String> res = new HashMap<>();
        res.put("abc", "def");
        res.put("whoami", whoami);
        System.out.println("who am I : " + whoami);
        System.out.println(namingService.getAllInstances("hello_c", "helloGroup"));
        return res;
    }



}
