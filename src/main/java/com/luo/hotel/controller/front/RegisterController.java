package com.luo.hotel.controller.front;

import com.luo.hotel.config.Result;
import com.luo.hotel.domain.Account;
import com.luo.hotel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AccountService accountService;
    /*
    * 注册
    * */
    @GetMapping("")
    public String RegisterHtml(){return "/register";}
    @PostMapping("")
    public String Register(@RequestParam("user_tel") String user_tel, @RequestParam("user_password") String user_password,
                           @RequestParam("confirm_password") String confirm_password,
                           @RequestParam String user_name, @RequestParam String user_sex, Model model)

    {
        if (!user_password.equals(confirm_password)) {
            model.addAttribute("msg","两次密码不一致");
            return "/register";
        }
        Account account = new Account();
        account.setUser_tel(user_tel);
        account.setUser_password(user_password);
        account.setUser_name(user_name);
        account.setUser_sex(user_sex);
        account.toString();
        Result result = accountService.UserRegister(account);
        if(result.getMsg().equals("该手机号已被注册")){
            model.addAttribute("msg","该手机号已注册");
            return "/register";
        }else {
            return "/login";
        }
    }
}
