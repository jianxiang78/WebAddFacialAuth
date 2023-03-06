package com.auto17.WebAddFacialAuth.domain;

import java.util.Date;

/**
 * webUser Object web_user
 *
 * @author jianxiang sun
 * @date 2023-03-04
 */
public class WebUser
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long userId;

    /**  */
    private String userName;

    /**  */
    private String loginName;

    /**  */
    private String passWord;

    /**  */
    private String facialId;

    /**  */
    private String lastLoginType;

    /**  */
    private Date lastLoginTime;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginName()
    {
        return loginName;
    }
    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public String getPassWord()
    {
        return passWord;
    }
    public void setFacialId(String facialId)
    {
        this.facialId = facialId;
    }

    public String getFacialId()
    {
        return facialId;
    }
    public void setLastLoginType(String lastLoginType)
    {
        this.lastLoginType = lastLoginType;
    }

    public String getLastLoginType()
    {
        return lastLoginType;
    }
    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

}
