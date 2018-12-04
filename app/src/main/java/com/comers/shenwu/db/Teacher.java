package com.comers.shenwu.db;

import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * Created by 79653 on 2018/9/29.
 * 描述：
 */
public class Teacher {
    public List<Student> students;
    public String name;
    @Id
    public Long id;
}
