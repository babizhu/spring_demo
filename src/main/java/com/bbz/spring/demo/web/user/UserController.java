package com.bbz.spring.demo.web.user;

import com.bbz.spring.demo.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    //    @RequestMapping(value="/login",method= RequestMethod.GET)
    @GetMapping("/login")
    @ApiOperation(value="用户登录", notes="用户输入用户名和密码进行登陆")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String index() {
        return "登录成功";
    }

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/get")
    public User get() {
        try {

            int[] a = new int[0];
            int b =a[3];
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
        return new User("liulaoye", 88);
    }

    @ApiOperation(value="创建用户", notes="")
    @PostMapping("/creat")
    public User creat(@RequestBody  User user) {


        user.setAge(user.getAge() + 100);

        return user;


    }
}
