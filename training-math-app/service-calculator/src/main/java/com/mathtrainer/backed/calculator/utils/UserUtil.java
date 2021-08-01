package com.mathtrainer.backed.calculator.utils;

import com.mathtrainer.backed.common.constants.CommonConsant;
import com.mathtrainer.backed.common.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {

    @Autowired
    private HttpServletRequest request;

    public UserInfoDto getLoginUserInfo() {
        // get from header
        String userId = request.getHeader(CommonConsant.HEADER_USER_ID);
        String userName = request.getHeader(CommonConsant.HEADER_USER_NAME);

        // return
        UserInfoDto userInfo = new UserInfoDto();
        userInfo.setUserName(userName);
        userInfo.setUserId(userId);
        return  userInfo;
    }
}
