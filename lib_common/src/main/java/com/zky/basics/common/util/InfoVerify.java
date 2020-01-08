package com.zky.basics.common.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InfoVerify {
    /**
     * 校验邮箱
     *
     * @param paramString
     * @return
     */
    public static boolean isValidEmail(String paramString) {

        String regex = "[a-zA-Z0-9_\\.]{1,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        if (paramString.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验ＱＱ
     *
     * @param paramString
     * @return
     */
    public static boolean isValidQQ(String paramString) {
        String regex = "^[1-9](\\d){4,9}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 校验车牌号
     *
     * @param paramString
     * @return
     */
    public static boolean isValidPlatnum(String paramString) {
        if (TextUtils.isEmpty(paramString)) return false;
        String regex = "^[\u4e00-\u9fa5]{1}[A-Z_a-z]{1}[A-Z_0-9_a-z]{5}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    /**
     * 校验手机号
     *
     * @param paramString
     * @return
     */
    public static boolean isValidMobiNumber(String paramString) {
        // String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (paramString == null) return false;
        String regex = "^1\\d{10}$";
        if (paramString.matches(regex)) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[0-9]+\\.?[0-9]*[0-9]$");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }


    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}