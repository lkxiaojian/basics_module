package com.zky.basics.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lk
 * Date 2019-11-05
 * Time 17:56
 * Detail: 自定义校验
 */
public class Verify {

    /**
     * 验证手机号
     * 手机号码格式错误，请输入11位手机号码！
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return false;
        }


        String type = "^[1]\\d{10}$";
        Pattern p = Pattern.compile(type);
        Matcher m = p.matcher(phone);
        boolean isPhone = m.matches();
        return isPhone;
    }

    /**
     * 验证字符串是否为空
     *
     * @param message
     * @return
     */

    public static boolean isEmpty(String message) {
        if (message == null || message.length() == 0) {
            return true;
        }
        return false;

    }

    /**
     * 验证密码符合规范  请输入6-20位字母和数字组合，必须同时含有字母和数字
     *
     * @param pwd
     * @return
     */
    public static boolean isPwd(String pwd) {
        if (pwd == null) {
            return false;
        }

        String type = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        Pattern p = Pattern.compile(type);
        Matcher m = p.matcher(pwd);
        boolean isPwd = m.matches();
        return isPwd;
    }

}

