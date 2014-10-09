/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

/**
 *
 * @author mahavir.singh
 */
public class ChapterBean {
    private Integer id;
    private String name;
    
    public ChapterBean() { }
    
    public ChapterBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
