package com.ljl.service;

import com.ljl.dao.SysuserMapper;
import com.ljl.entity.Sysuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25/025.
 */
@Service
public class LoginService {

    @Autowired
    private SysuserMapper sysuserMapper;

    public Sysuser getUserByUsercode(String usercode) {
        return  sysuserMapper.selectByUsercode(usercode);

    }
    public Sysuser getUserByUserid(String userid) {
        return  sysuserMapper.selectByPrimaryKey(userid);
    }


}
