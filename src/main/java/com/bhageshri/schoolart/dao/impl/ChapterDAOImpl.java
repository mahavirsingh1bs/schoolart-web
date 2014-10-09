/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.dao.ChapterDAO;
import com.bhageshri.schoolart.domain.Chapter;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mahavir.singh
 */
@Repository
public class ChapterDAOImpl extends GenericDAOImpl<Long, Chapter> implements ChapterDAO {

    @Override
    public List<Chapter> findChaptersBySubject(Long subjectId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.subject.id = :subjectId");
        query.setParameter("subjectId", subjectId);
        return query.getResultList();
    }
    
}
