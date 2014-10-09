/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.SubjectDAO;
import com.bhageshri.schoolart.domain.Subject;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mahavir Singh
 */
@Repository
public class SubjectDAOImpl extends GenericDAOImpl<Long, Subject> implements SubjectDAO {

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Subject> findSubjectsByClass(Long classId) {
        Query query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.stuClass.id = :classId");
        query.setParameter("classId", classId);
        return query.getResultList();
    }
    
}
