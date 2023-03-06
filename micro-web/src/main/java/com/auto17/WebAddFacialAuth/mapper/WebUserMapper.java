package com.auto17.WebAddFacialAuth.mapper;

import java.util.List;
import com.auto17.WebAddFacialAuth.domain.WebUser;
import org.springframework.stereotype.Component;

/**
 * webUserMapper interface
 *
 * @author jianxiang sun
 * @date 2023-03-04
 */

public interface WebUserMapper
{
    /**
     *
     * @param userId webUserID
     * @return webUser
     */
    public WebUser selectWebUserById(Long userId);

    /**
     *
     * @param webUser webUser
     * @return webUser List
     */
    public List<WebUser> selectWebUserList(WebUser webUser);

    /**
     *
     * @param webUser webUser
     * @return int
     */
    public int insertWebUser(WebUser webUser);

    /**
     *
     * @param webUser webUser
     * @return int
     */
    public int updateWebUser(WebUser webUser);

    /**
     *
     * @param userId webUserID
     * @return int
     */
    public int deleteWebUserById(Long userId);

}
