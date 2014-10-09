/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.UserDAO;
import com.bhageshri.schoolart.domain.User;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mahavir Singh
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<Long, User> implements UserDAO {

    @Override
    public User findUser(String username, char[] password, Long schoolId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findUser(String username, char[] password) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User )query.getSingleResult();
    }
    
}
