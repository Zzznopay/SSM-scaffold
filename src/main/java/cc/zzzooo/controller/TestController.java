package cc.zzzooo.controller;

import cc.zzzooo.pojo.Test;
import cc.zzzooo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: TestController
 * Package: cc.zzzooo.controller
 * Description:
 *
 * @Author: zzz
 * @Create: 2024/6/15-14:05
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        List<Test> tests = testService.selectAll();
        System.out.println(tests);
        return "test SSM";
    }
}
