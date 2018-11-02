package com.demo.controller;

import com.demo.core.exception.BusinessException;
import com.demo.entity.UserInfo;
import com.demo.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, UserInfo loginUser){

        try {

            if(StringUtils.isBlank(loginUser.getLoginName())){
                request.setAttribute("errorMsg", "请输入用户名");
                throw new BusinessException("L_01", "请输入用户名");
            }

            if(StringUtils.isBlank(loginUser.getLoginName())){
                request.setAttribute("errorMsg", "请输入密码");
                throw new BusinessException("L_02", "请输入密码");
            }

            List<UserInfo> userInfoList = userInfoService.selectListBySelective(loginUser);
            if (CollectionUtils.isEmpty(userInfoList)) {
                request.setAttribute("errorMsg", "用户不存在");
                throw new BusinessException("L_03", "用户不存在");
            }

            UserInfo userInfo = userInfoList.get(0);
            if (!StringUtils.equals(userInfo.getPassword(), loginUser.getPassword())) {
                request.setAttribute("errorMsg", "密码输入不正确");
                throw new BusinessException("L_04", "密码输入不正确");
            }

            request.getSession().setAttribute("userInfo", userInfo);

            return "main/admin_index";
        } catch (Exception e) {
            logger.error("login in error:{}", e);
        }
        return "login";
    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response){
        try {

            response.setCharacterEncoding("utf-8");

            HttpSession session = request.getSession();

            //清空session
            session.invalidate();

            PrintWriter out = response.getWriter();
            out.print("<script>alert('退出成功！'); parent.window.location.href='"+request.getContextPath()+"/login/toLogin';</script>");
        } catch (Exception e) {
            logger.error("login out error:{}", e);
        }
    }

    @RequestMapping("/top")
    public String top(){
        return "main/admin_top";
    }

    @RequestMapping("/left")
    public String left(){
        return "main/admin_left";
    }

}
