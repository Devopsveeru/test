package com.vasitum.core.config.bean;

import com.vasitum.core.dto.UserInfo;

public interface UserInfoService {
    void setUserInfo(UserInfo user);

    UserInfo getUserInfo();
}
