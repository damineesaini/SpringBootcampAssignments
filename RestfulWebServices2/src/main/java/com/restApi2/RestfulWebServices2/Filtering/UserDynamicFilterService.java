package com.restApi2.RestfulWebServices2.Filtering;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDynamicFilterService {
    private static ArrayList<UserDynamicFilterBean> userDynamicFilterBeans = new ArrayList<>();

    private static int userCount = 22;

    static  {
        userDynamicFilterBeans.add(new UserDynamicFilterBean(21,"Parth","2834@ds#DL"));
        userDynamicFilterBeans.add(new UserDynamicFilterBean(22,"Megha","2834@SEs#a"));
    }

    public UserDynamicFilterBean createUserDynamicFilter(UserDynamicFilterBean userDynamicFilterBean){
        if(userDynamicFilterBean.getId()==null){
            userDynamicFilterBean.setId(++userCount);
        }
        else
            return null;
        userDynamicFilterBeans.add(userDynamicFilterBean);
        return userDynamicFilterBean;
    }
}
