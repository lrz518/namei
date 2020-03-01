package com.jk.controller;




import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.UserModel;
import com.jk.service.UserService;
import com.jk.util.CheckSumBuilder;
import com.jk.util.HttpClientUtil;
import com.jk.util.Md5Util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("user")
@ComponentScan(basePackages = {"com.jk.*"})
public class UserController {
    private  Logger  logger =  LoggerFactory.getLogger(UserController.class);
    @Reference
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //注册账号
    @RequestMapping("register")
    @ResponseBody
    public
    void   register(UserModel  userModel){
         userModel.setUserimg(null);
         userModel.setMember(1);
         userModel.setAddress(null);
         userModel.setJifen(null);
         userModel.setAddressjibie(1);
         userModel.setYue(null);
         userModel.setUserpassword(Md5Util.getMd532(userModel.getUserpassword()));
        userService.register(userModel);
    }
    //注册验证账号是否存在
    @RequestMapping("checkUser")
    @ResponseBody
    public
    String  checkUser(String  useriphone){
        UserModel  userIphone = userService.findUserPhone(useriphone);
        if(userIphone  != null){
            return  "aail";
        }
        return "success";
    }

    //短信验证码登陆
    @RequestMapping("smLogin")
    @ResponseBody
    public
    Map  smLogin(String useriphone,String  checkcode,HttpSession session){
        HashMap<String, Object> result = new  HashMap<>();
        //判断缓存中是否有该账号的验证码

        String  cachecode = redisTemplate.opsForValue().get("smscode"+useriphone).toString();
            if(!cachecode.equals(checkcode)){
                result.put("code" , 2);
                result.put("msg","验证码错误，请重新输入");
                return  result;
            }
            UserModel  findUserPhone = userService.findUserPhone(useriphone);
            if(findUserPhone ==  null){
                result.put("code" , 3);
                result.put("msg","账号或密码错误，请重新输入");
                return  result;
            }
            session.setAttribute(session.getId(),findUserPhone);
                result.put("code" , 4);
                result.put("msg","登陆成功");
                return  result;
    }
    //短信验证码下发
    @RequestMapping("sendSmsCode")
    @ResponseBody
    public
    Map sendSmsCode(String useriphone){
        HashMap<String, Object> result = new  HashMap<>();
        try{
            if (redisTemplate.hasKey("smslock"+useriphone)) {
                result.put("code", 2);
                result.put("msg", "1分钟内不能重复获取");
                return result;
            }
            HashMap<String, Object> header = new  HashMap<>();
            header.put("AppKey","6a9fe256cad5b845008dc24a88cbbdb8");
            String nonce = UUID.randomUUID().toString().replace("-","");
            header.put("Nonce",nonce);
            String curTime = String.valueOf(System.currentTimeMillis());
            header.put("CurTime",curTime);
            String  checkSum = CheckSumBuilder.getCheckSum("d7922b7e8ce6",nonce,curTime);
            header.put("CheckSum",checkSum);
            HashMap<String, Object> params = new  HashMap<>();
            params.put("mobile",useriphone);
            params.put("templateid","14828827");
            int authCode = (int) ((Math.random() * 9 + 1) * 100000);
            params.put("authCode",authCode);
            String post = HttpClientUtil.post("https://api.netease.im/sms/sendcode.action",params,header);
            JSONObject parseObject = JSONObject.parseObject(post);
            int  code = parseObject.getIntValue("code");
            if(code == 200){
                redisTemplate.opsForValue().set("smscode"+useriphone,authCode,2, TimeUnit.MINUTES);

                result.put("code" , 0);
                result.put("msg","发送成功");
                return  result;
            }else{
                result.put("code" , 1);
                result.put("msg","发送失败");
                return  result;
            }

        }catch(Exception e){
            logger.error("sendSmsCode()=?",e);
            result.put("code" , 1);
            result.put("msg","发送失败");
            return  result;
        }
    }
    //验证登陆手机号/密码
    @RequestMapping("login")
    @ResponseBody
    public
    Map loginUser(UserModel userModel, HttpSession session) {
    HashMap<String, Object> result = new HashMap<>();
    UserModel  userInfo = userService.findUserPhone(userModel.getUseriphone());
    if(userInfo == null){
        result.put("code",1);
        result.put("msg","账号不存在");
        return result;
    }
    String  md532 = Md5Util.getMd532(userModel.getUserpassword());
    if(!userInfo.getUserpassword().equals(md532)){
        result.put("code",2);
        result.put("msg","密码错误");
        return result;
    }
    session.setAttribute(session.getId(),userInfo);
        result.put("code",0);
        result.put("msg","登陆成功");
    return result;
    }


    //跳转到登陆页面
    @RequestMapping("toLogin")
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login");
        return mv;
    }
    //跳转到验证码登陆页面
    @RequestMapping("smsLogin")
    public ModelAndView smsLogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/smslogin");
        return mv;
    }
    //跳转到注册页面
    @RequestMapping("toRegister")
    public ModelAndView toRegister() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/register");
        return mv;
    }
    //跳转到发货时间页面
    @RequestMapping("toDeliver")
    public ModelAndView toDeliver() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/deliver");
        return mv;
    }
    //跳转到商品问题页面
    @RequestMapping("toCommodity")
    public ModelAndView toCommodity() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/commodity");
        return mv;
    }
    //跳转到售后退款页面
    @RequestMapping("toSale")
    public ModelAndView toSale() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/sale");
        return mv;
    }
    //跳转到售后退款页面
    @RequestMapping("toAaa")
    public ModelAndView toAaa() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/aaa");
        return mv;
    }
    //跳转到运费支付页面
    @RequestMapping("toFreight")
    public ModelAndView toFreight() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/freight");
        return mv;
    }
    //跳转到支付问题页面
    @RequestMapping("toPayment")
    public ModelAndView toPayment() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/payment");
        return mv;
    }
}
