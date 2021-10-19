package com.xiaoping.cmdtest.hutool;

import cn.hutool.core.util.ObjectUtil;
import com.xiaoping.utils.DataRow;

public class CloneTest {

    public static void main(String[] args) {
        DataRow data = new DataRow();
        data.set("key1", "val1");
        data.set("key2", "val2");
        System.out.println(data);
        DataRow copy = ObjectUtil.cloneByStream(data);
        System.out.println(copy);
    }
}
