package com.hantianle.web.service.Impl;

import com.hantianle.web.dao.FindUserDao;
import com.hantianle.web.dao.Impl.FindUserDaoImpl;
import com.hantianle.web.domain.Student;
import com.hantianle.web.service.FindUserService;

public class FindUserServiceImpl implements FindUserService {

    private FindUserDao findUserDao = new FindUserDaoImpl();

    /**
     * 判断是否存在改用户名
     * @param username
     * @return
     */
    @Override
    public boolean FindUserByUsername(String username) {
        Student s = findUserDao.FindUserByUsername(username);
        Boolean exist = null;
        if (s != null){
            exist = true;
        }else {
            exist = false;
        }
        return exist;
    }
}

