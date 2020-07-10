package com.wxk.cmdb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: nonpricklycactus
 * @CreateDate: 2020/5/11
 */
public class CreateDate {
    public String NowDate(){
        return dateToString(new Date());
    }

    public  String dateToString(Date date) {
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String tiem = sformat.format(date);

        return tiem;
    }

}
