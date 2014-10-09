/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.ChapterBean;
import com.bhageshri.schoolart.bean.SubjectBean;
import com.bhageshri.schoolart.dao.ChapterDAO;
import com.bhageshri.schoolart.domain.Chapter;
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
public class ChapterController {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ChapterController.class);
    
    @Inject
    private ChapterDAO chapterDAO;
    
    @RequestMapping(value = "/chapters/{subjectId}")
    public List<ChapterBean> chapters(@PathVariable Long subjectId) {
        List<ChapterBean> chapters = new ArrayList<>();   
        for (Chapter chapter : chapterDAO.findChaptersBySubject(subjectId)) {
            chapters.add(new ChapterBean(chapter.getSerialNo(), 
                    chapter.getName()));
        }
        return chapters;
    }
}
