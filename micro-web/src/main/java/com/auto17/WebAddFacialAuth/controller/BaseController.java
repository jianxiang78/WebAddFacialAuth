package com.auto17.WebAddFacialAuth.controller;

import com.auto17.WebAddFacialAuth.domain.AjaxResult;

/**
 * Base Controller
 *
 * @author
 */
public class BaseController{

    /**
     * Response Result
     *
     * @param rows
     * @return AjaxResult
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * Response
     *
     * @param result
     * @return AjaxResult
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * Response success
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * Response error
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * Response success
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    public AjaxResult success(String message,Object data)
    {
        return AjaxResult.success(message,data);
    }

    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    public AjaxResult error(String message,Object data)
    {
        return AjaxResult.error(message,data);
    }

}
