/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service;

/**
 *
 * @author Mahavir Singh
 */
public interface UserService {    
    boolean login(String username, char[] password, Long schoolId);
    boolean login(String username, char[] password);
    void logout(Long userId);
}
