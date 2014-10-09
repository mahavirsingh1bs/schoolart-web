/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import java.io.Serializable;

/**
 *
 * @author mahavir.singh
 */
public class ExamBean implements Serializable {
    private Long id;
    private String name;

    public ExamBean() { }
    
    public ExamBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
