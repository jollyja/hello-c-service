package cn.hello.c.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RefreshScope
public class CController {

    @Value("${whoami:unkonwn}")
    private String whoami;

//    @Autowired
//    private RestTemplate restTemplate;

    @PostMapping(path = "/c/confirm")
    public Map<String, String> confirm(@RequestBody Map<String, String> req) {
        Map<String, String> res = new HashMap<>();
        res.put("abc", "def");
        res.put("whoami", whoami);
        System.out.println("who am I : " + whoami);

//        Map<String, String> resFromD = restTemplate.postForObject("http://hello_d/d/done", res, Map.class);
//        System.out.println(resFromD);
//
//        return resFromD;
        return res;
    }
}
