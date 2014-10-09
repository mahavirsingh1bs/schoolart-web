/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao.impl;

import com.bhageshri.schoolart.bean.ChapterCriteria;
import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.domain.Exercise;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.util.Operand;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mahavir.singh
 */
@Repository
public class QuestionDAOImpl extends GenericDAOImpl<Long, Question> implements QuestionDAO {

    @Override
    public List<Question> findQuestionByType(QuestionType type) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.questionType = :type");
        query.setParameter("type", type);
        return (List<Question>) query.getResultList();
    }

    @Override
    public List<Question> findQuestionByExerciseAndType(Exercise exercise, QuestionType type) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.exercise = :exercise AND q.questionType = :type");
        query.setParameter("exercise", exercise);
        query.setParameter("type", type);
        return (List<Question>) query.getResultList();
    }

    @Override
    public List<Question> findQuestionByExerciseId(Long id) {
        Query query = entityManager.createQuery("SELECT q FROM Question q WHERE q.exercise.id = :exerciseId");
        query.setParameter("exerciseId", id);
        return (List<Question>) query.getResultList();
    }

    @Override
    public List<Question> findQuestionByTypeAndSubject(long classId, long subjectId, QuestionType type, ChapterCriteria chapterCriteria) {
        StringBuilder sb = new StringBuilder("SELECT q FROM Question q WHERE q.questionType = :type AND q.exercise.chapter.subject.id = :subjectId AND q.exercise.chapter.subject.stuClass.id = :classId");
        
        if (chapterCriteria.getOperand() != Operand.ALL) {
            sb.append(" AND (");
            ChapterCriteria temp = chapterCriteria;
            ChapterCriteria nextTemp = chapterCriteria.getNext();
            int index = 0;
            while (nextTemp.getOperand() != null) {
                if (temp.getOperand() == Operand.TO) {
                    if (index != 0) {
                        sb.append(" OR ");
                        sb.append(" (q.exercise.chapter.serialNo BETWEEN ");
                        sb.append(temp.getChapter());
                        sb.append(" AND ");
                        sb.append(nextTemp.getChapter());
                        sb.append(")");
                    } else {
                        sb.append(" (q.exercise.chapter.serialNo BETWEEN ");
                        sb.append(temp.getChapter());
                        sb.append(" AND ");
                        sb.append(nextTemp.getChapter());
                        sb.append(")");
                    }
                } else if (temp.getOperand() == Operand.AND) {
                    if (index != 0) {
                        sb.append(" AND ");
                        sb.append(" q.exercise.chapter.serialNo = ");
                        sb.append(temp.getChapter());
                    } else {
                        sb.append(" q.exercise.chapter.serialNo = ");
                        sb.append(temp.getChapter());
                    }
                } else if (temp.getOperand() == Operand.OR) {
                    if (index != 0) {
                        sb.append(" OR ");
                        sb.append(" q.exercise.chapter.serialNo = ");
                        sb.append(temp.getChapter());
                    } else {
                        sb.append(" q.exercise.chapter.serialNo = ");
                        sb.append(temp.getChapter());
                    }
                }
                temp = temp.getNext();
                nextTemp = temp.getNext();
                index++;
            }
            
            if (temp.getOperand() == Operand.AND) {
                if (index != 0) {
                    sb.append(" AND ");
                    sb.append(" q.exercise.chapter.serialNo = ");
                    sb.append(temp.getChapter());
                } else {
                    sb.append(" q.exercise.chapter.serialNo = ");
                    sb.append(temp.getChapter());
                }
            } else if (temp.getOperand() == Operand.OR) {
                if (index != 0) {
                    sb.append(" OR ");
                    sb.append(" q.exercise.chapter.serialNo = ");
                    sb.append(temp.getChapter());
                } else {
                    sb.append(" q.exercise.chapter.serialNo = ");
                    sb.append(temp.getChapter());
                }
            } else if (temp.getOperand() == Operand.TO) {
                if (index != 0) {
                    sb.append(" OR ");
                    sb.append(" (q.exercise.chapter.serialNo BETWEEN ");
                    sb.append(temp.getChapter());
                    sb.append(" AND ");
                    sb.append(nextTemp.getChapter());
                    sb.append(")");
                } else {
                    sb.append(" (q.exercise.chapter.serialNo BETWEEN ");
                    sb.append(temp.getChapter());
                    sb.append(" AND ");
                    sb.append(nextTemp.getChapter());
                    sb.append(")");
                }
            }
            sb.append(" )");
        }
        
        System.out.println(sb.toString());
        
        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("classId", classId);
        query.setParameter("subjectId", subjectId);
        query.setParameter("type", type);
        return query.getResultList();
    }
}
