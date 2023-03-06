package com.auto17.WebAddFacialAuth.controller;

import java.util.List;

import com.auto17.WebAddFacialAuth.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.auto17.WebAddFacialAuth.domain.WebUser;
import com.auto17.WebAddFacialAuth.service.IWebUserService;

/**
 * webUserController
 *
 * @author jianxiang sun
 * @date 2023-03-04
 */
@Controller
@RequestMapping("/webUser/webUser")
public class WebUserController extends BaseController
{

    @Autowired
    private IWebUserService webUserService;

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WebUser webUser)
    {
        return toAjax(webUserService.insertWebUser(webUser));
    }


    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WebUser webUser)
    {
        return toAjax(webUserService.updateWebUser(webUser));
    }

}
