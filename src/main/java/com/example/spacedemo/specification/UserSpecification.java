package com.example.spacedemo.specification;

import com.example.spacedemo.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasUsername(String username) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username));
    }

    public static Specification<User> hasEmail(String email) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email));
    }
    public static Specification<User> ageGreaterThan(Integer age) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("age"), age));
    }
    public static Specification<User> ageLessThan(Integer age) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("age"), age));
    }
    public static Specification<User> UsernameLike(String usernamePattern) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("username"), "%" + usernamePattern + "%"));
    }
}
