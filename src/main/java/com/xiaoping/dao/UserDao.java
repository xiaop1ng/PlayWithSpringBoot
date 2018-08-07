package com.xiaoping.dao;

import com.xiaoping.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    public User findByUserNameAndPassword(String userName, String password);

    public User findByUserName(String userName);
}
