package com.donews.frame.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by 79653 on 2018/9/29.
 * 描述：
 */
@Entity
public class Student {
    public String name;
    public int score;
    @Id
    public Long id ;
    public Long teacherId;
}
