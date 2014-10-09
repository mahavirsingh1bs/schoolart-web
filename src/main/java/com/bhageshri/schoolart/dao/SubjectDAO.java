/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.domain.Subject;
import java.util.List;

/**
 *
 * @author Mahavir Singh
 */
public interface SubjectDAO extends GenericDAO<Long, Subject> {
    List<Subject> findSubjectsByClass(Long classId);
}
