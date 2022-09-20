package com.quintrix.jfs.usermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.usermicroservice.VO.Department;
import com.quintrix.jfs.usermicroservice.VO.ResponseTemplateVO;
import com.quintrix.jfs.usermicroservice.entity.User;
import com.quintrix.jfs.usermicroservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User postUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(
                "http://localhost:9001/departments " + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
