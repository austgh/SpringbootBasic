package com.austgh.mapper;

import com.austgh.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by think on 2021/1/14.
 */
@Repository
public interface UserMapper {
    User getUserById(Integer id);
}
