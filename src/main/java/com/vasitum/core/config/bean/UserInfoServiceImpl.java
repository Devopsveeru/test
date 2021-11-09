package com.vasitum.core.config.bean;

import com.vasitum.core.dto.UserInfo;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfo userInfo;

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public UserInfo getUserInfo() {
        return this.userInfo;
    }
}
