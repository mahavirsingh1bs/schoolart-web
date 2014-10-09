/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.ChapterBean;
import com.bhageshri.schoolart.bean.SubjectBean;
import com.bhageshri.schoolart.dao.ExerciseDAO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahavir.singh
 */
@RestController
public class ExerciseController {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseController.class);
    
    @Inject
    private ExerciseDAO exerciseDAO;
    
    @RequestMapping(value = "/exercises/{chapterId}")
    public List<ChapterBean> exercises(@PathVariable Long chapterId) {
        List<ChapterBean> chapters = new ArrayList<>();   
        for (Integer chapter : exerciseDAO.findChaptersBySubject(chapterId)) {
            chapters.add(new ChapterBean(chapter, "Chapter " + chapter));
        }
        return chapters;
    }
}
