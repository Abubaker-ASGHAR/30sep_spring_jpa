package com.example.spacedemo.service;

import com.example.spacedemo.entity.User;
import com.example.spacedemo.repository.UserRepository;
import com.example.spacedemo.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Page<User> searchUsers(String username,String email,Integer minAge,Integer maxAge,String sortBy,String sortDir,int page,int size){
        Specification<User> spec =Specification.where(null);
        if(username!=null && !username.isEmpty()){
            spec=spec.and(UserSpecification.hasUsername(username));
        }

        if(email!=null && !email.isEmpty()){
            spec=spec.and(UserSpecification.hasEmail(email));
        }

        if(minAge!=null && minAge>0){
            spec=spec.and(UserSpecification.ageGreaterThan(minAge));
        }
        if(maxAge!=null && maxAge>0){
            spec=spec.and(UserSpecification.ageLessThan(maxAge));
        }

        Sort sort = Sort.by("id").descending();

        if(sortBy!=null && !sortBy.isEmpty()){
            if("desc".equals(sortDir)){
                sort = Sort.by(sortBy).descending();
            }
            else {
                sort = Sort.by(sortBy).ascending();
            }
        }

        Pageable pageable = PageRequest.of(page,size,sort);

        return userRepository.findAll(spec,pageable);
    }

    public  User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

}
