package com.auto17.WebAddFacialAuth.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auto17.WebAddFacialAuth.mapper.WebUserMapper;
import com.auto17.WebAddFacialAuth.domain.WebUser;
import com.auto17.WebAddFacialAuth.service.IWebUserService;

/**
 * webUserService Business layer processing
 *
 * @author jianxiang sun
 * @date 2023-03-04
 */
@Service
public class WebUserServiceImpl implements IWebUserService
{
    @Autowired
    private WebUserMapper webUserMapper;

    /**
     *
     * @param userId webUserID
     * @return webUser
     */
    @Override
    public WebUser selectWebUserById(Long userId)
    {
        return webUserMapper.selectWebUserById(userId);
    }

    @Override
    public WebUser selectWebUserOne(WebUser webUser)
    {
        List<WebUser> list=selectWebUserList(webUser);
        if(list!=null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    /**
     *
     * @param webUser webUser
     * @return webUser
     */
    @Override
    public List<WebUser> selectWebUserList(WebUser webUser)
    {
        return webUserMapper.selectWebUserList(webUser);
    }

    /**
     *
     * @param webUser webUser
     * @return int
     */
    @Override
    public int insertWebUser(WebUser webUser)
    {
        return webUserMapper.insertWebUser(webUser);
    }

    /**
     *
     * @param webUser webUser
     * @return int
     */
    @Override
    public int updateWebUser(WebUser webUser)
    {
        return webUserMapper.updateWebUser(webUser);
    }


    /**
     *
     * @param userId webUserID
     * @return int
     */
    @Override
    public int deleteWebUserById(Long userId)
    {
        return webUserMapper.deleteWebUserById(userId);
    }
}
