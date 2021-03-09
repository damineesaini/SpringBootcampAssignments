package com.restApi2.RestfulWebServices2.Filtering;


import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserStaticFilterService {
    private static ArrayList<UserStaticFilterBean> userStaticFilterBeans = new ArrayList<>();

    private static int userCount = 12;

    static {
        userStaticFilterBeans.add(new UserStaticFilterBean(11,"Parth","2834@ds#DL"));
        userStaticFilterBeans.add(new UserStaticFilterBean(12,"Megha","2834@SEs#a"));
    }

    public UserStaticFilterBean createUserStaticFilter(UserStaticFilterBean userStaticFilterBean){
        if(userStaticFilterBean.getId()==null){
            userStaticFilterBean.setId(++userCount);
        }
        else
            return null;
        userStaticFilterBeans.add(userStaticFilterBean);
        return userStaticFilterBean;
    }
}
