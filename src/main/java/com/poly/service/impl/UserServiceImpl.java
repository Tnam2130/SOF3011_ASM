package com.poly.service.impl;

import com.poly.DAO.UserDAO;
import com.poly.DAO.impl.UserDAOimpl;
import com.poly.Dto.UserDto;
import com.poly.constant.NameParameter;
import com.poly.entity.User;
import com.poly.service.UserService;
import com.poly.utils.EmailUtils;
import com.poly.utils.RandomNumberUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDAO dao = new UserDAOimpl();
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public User login(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public List<User> findAll(int pageNumber, int pageSize) {
        return dao.findAll(pageNumber, pageSize);
    }

    @Override
    public User create(String username, String password, String email) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setAdmin(false);
        newUser.setActive(true);
        return dao.create(newUser);
    }


    @Override
    public User update(User entity) {
        return dao.update(entity);
    }

    @Override
    public User delete(String username) {
        User user = dao.findByUsername(username);
        user.setActive(false);
        return dao.update(user);
    }
    @Override
    public List<UserDto> findUserLikedByVideoHref(String href) {
        Map<String, Object> params = new HashMap<>();
        params.put(NameParameter.VIDEO_HREF, href);
        List<User> users =  dao.findUserLikeVideoByVideoHref(params);
        List<UserDto> result = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUsername());
            userDto.setEmail(user.getEmail());
            result.add(userDto);
        });
        return result;
    }
}
