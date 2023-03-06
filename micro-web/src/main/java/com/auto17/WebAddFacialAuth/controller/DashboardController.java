package com.auto17.WebAddFacialAuth.controller;

import com.auto17.WebAddFacialAuth.domain.WebUser;
import com.auto17.WebAddFacialAuth.service.IWebUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * dashboard
 *
 * @author jianxiang sun
 */

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(DashboardController.class);

    private String prefix = "dashboard";

    @Autowired
    private IWebUserService webUserService;

    @GetMapping()
    public String index(ModelMap modelMap, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        logger.info("login user="+userId);
        if(userId==null){
            logger.error("user is not login");
            return "redirect:/login.html";
        }else {
            WebUser webUser=webUserService.selectWebUserById(userId);
            modelMap.put("webUser",webUser);
        }

        return prefix + "/index";
    }

}
