/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

/**
 *
 * @author mahavir.singh
 */
public class StudentClass {
    private Long id;
    private String name;

    public StudentClass() { }
    
    public StudentClass(Long id, String name) {
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
