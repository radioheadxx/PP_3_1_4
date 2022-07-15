//package ru.kata.spring.boot_security.demo.service;
//
//import org.springframework.stereotype.Service;
//import ru.kata.spring.boot_security.demo.entity.Role;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//@Service
//public class RoleService {
//
//    private final EntityManager entityManager;
//
//    public RoleService(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public List<Role> getAllRoles() {
//        String jpql = "from Role";
//        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);
//        return query.getResultList();
//    }
//}
