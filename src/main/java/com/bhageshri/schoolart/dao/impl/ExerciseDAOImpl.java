/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.ExerciseDAO;
import com.bhageshri.schoolart.domain.Exercise;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mahavir.singh
 */
@Repository
public class ExerciseDAOImpl extends GenericDAOImpl<Long, Exercise> implements ExerciseDAO {

    @Override
    public Exercise findExerciseByName(String name) {
        Query query = entityManager.createQuery("SELECT e FROM Exercise e WHERE e.name = :name");
        query.setParameter("name", name);
        return (Exercise) query.getSingleResult();
    }

    @Override
    public List<Exercise> findExerciseByClassAndSubject(Long classId, Long subjectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Integer> findChaptersBySubject(Long subjectId) {
        Query query = entityManager.createQuery("SELECT DISTINCT e.chapter FROM Exercise e WHERE e.subject.id = :subjectId");
        query.setParameter("subjectId", subjectId);
        return query.getResultList();
    }
}
