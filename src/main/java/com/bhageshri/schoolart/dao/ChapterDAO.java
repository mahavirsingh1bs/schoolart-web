/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.domain.Chapter;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public interface ChapterDAO extends GenericDAO<Long, Chapter> {
    List<Chapter> findChaptersBySubject(Long subjectId);
}
