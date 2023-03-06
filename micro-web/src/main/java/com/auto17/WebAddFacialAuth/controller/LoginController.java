package com.auto17.WebAddFacialAuth.controller;

import com.auto17.WebAddFacialAuth.domain.AjaxResult;
import com.auto17.WebAddFacialAuth.domain.WebUser;
import com.auto17.WebAddFacialAuth.service.IWebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Login Controller
 *
 * @author jianxiang sun
 */

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController
{
    protected final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IWebUserService webUserService;


    @PostMapping("/signInLogin")
    public AjaxResult signInLogin(HttpServletRequest request,WebUser user) {
        if(user.getLoginName()==null || user.getPassWord()==null){
            return AjaxResult.error("signIn fail");
        }
        user.setPassWord(DigestUtils.md5DigestAsHex(user.getPassWord().getBytes()));
        user=webUserService.selectWebUserOne(user);
        if(user==null){
            logger.info("user signIn fail");
            return AjaxResult.error("signIn fail, need reg");
        }else {
            WebUser userUp=new WebUser();
            userUp.setUserId(user.getUserId());
            userUp.setLastLoginTime(new Date());
            userUp.setLastLoginType("Account and password");
            webUserService.updateWebUser(userUp);
            return loginSuccess(request,user.getUserId());
        }
    }

    @PostMapping("/newUserReg")
    public AjaxResult newUserReg(HttpServletRequest request,WebUser user) {
        WebUser userCheck=new WebUser();
        userCheck.setLoginName(user.getLoginName());
        userCheck=webUserService.selectWebUserOne(userCheck);
        if(userCheck!=null){
            logger.info("user reg fail");
            return AjaxResult.error("user reg fail");
        }else {
            user.setPassWord(DigestUtils.md5DigestAsHex(user.getPassWord().getBytes()));
            user.setLastLoginType("Account and password");
            user.setLastLoginTime(new Date());
            webUserService.insertWebUser(user);
            logger.info("new User Reg="+user.getUserId());
            return loginSuccess(request,user.getUserId());
        }
    }

    @PostMapping("/signInFacialAuth")
    public AjaxResult signInFacialAuth(HttpServletRequest request,WebUser user) {
        if(user.getFacialId()==null){
            return AjaxResult.error("signIn fail");
        }
        user=webUserService.selectWebUserOne(user);
        if(user==null){
            logger.info("user signIn fail");
            return AjaxResult.error("signIn fail, need reg");
        }else {
            WebUser userUp=new WebUser();
            userUp.setUserId(user.getUserId());
            userUp.setLastLoginTime(new Date());
            userUp.setLastLoginType("Facial Auth");
            webUserService.updateWebUser(userUp);
            return loginSuccess(request,user.getUserId());
        }
    }


    @PostMapping("/addFacialAuth")
    public AjaxResult addFacialAuth(HttpServletRequest request,WebUser user) {
        HttpSession session = request.getSession();
        Long loginUserId=(Long)session.getAttribute("userId");
        if(user.getFacialId()==null || loginUserId==null){
            return AjaxResult.error("data fail");
        }
        String userFacialId=user.getFacialId();
        user=webUserService.selectWebUserOne(user);
        if(user==null){
            WebUser userUp=new WebUser();
            userUp.setUserId(loginUserId);
            userUp.setFacialId(userFacialId);
            webUserService.updateWebUser(userUp);
            return AjaxResult.success();
        }else {
            logger.info("user add Facial Auth fail");
            return AjaxResult.error("user add Facial Auth, need only one");
        }
    }

    private AjaxResult loginSuccess(HttpServletRequest request, Long userId){
        HttpSession session = request.getSession();
        session.setAttribute("userId",userId);
        return AjaxResult.success();
    }



    @PostMapping("/faceIOAppCode")
    public AjaxResult faceIOAppCode() {
        String faceIOAppCode="fioab497";
        return AjaxResult.success(faceIOAppCode);
    }
}
