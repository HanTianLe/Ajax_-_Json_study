package com.hantianle.web.dao;

import com.hantianle.web.domain.Student;

public interface FindUserDao {
    public Student FindUserByUsername(String username);
}
