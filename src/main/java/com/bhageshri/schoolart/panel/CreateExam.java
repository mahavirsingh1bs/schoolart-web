/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.panel;

import com.bhageshri.schoolart.dao.StuClassDAO;
import com.bhageshri.schoolart.dao.SubjectDAO;
import com.bhageshri.schoolart.domain.StuClass;
import com.bhageshri.schoolart.domain.Subject;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.util.BeanResolverUtil;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public class CreateExam extends javax.swing.JPanel {

    /**
     * Creates new form CreateExam
     */
    public CreateExam() {
        init();
        // initComponents();
    }

    private class ComboItem implements Serializable {
        private Long value;
        private String label;

        public ComboItem() { }
        
        public ComboItem(Long value, String label) {
            this.value = value;
            this.label = label;
        }
        
        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
        
        @Override
        public String toString() {
            return label;
        }
        
    }
    
    private void init() {
        subjectPanel = new javax.swing.JPanel();
        subjectLabel = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox();
        haderLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        classComboBox = new javax.swing.JComboBox();
        questionsPanel = new javax.swing.JPanel();
        
        subjectDAO = (SubjectDAO ) BeanResolverUtil.getBean("subjectDAO");
        List<Subject> subjects = null;
        try {
            subjects = subjectDAO.findAll();
        } catch (DAOException ex) {
            // Logger.getLogger(CreateExam.class).log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        
        ComboItem[] subjectOptions = new ComboItem[subjects.size() + 1];
        int index = 0;
        subjectOptions[index++] = new ComboItem(-1l, "select");
        for (Subject subject : subjects) {
            subjectOptions[index++] = new ComboItem(subject.getId(), subject.getName());
        }
        
        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel(subjectOptions));
        subjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboBoxActionPerformed(evt);
            }
        });
        
        classLabel.setText("Class: ");

        StuClassDAO stuClassDAO = (StuClassDAO ) BeanResolverUtil.getBean("stuClassDAO");
        List<StuClass> stuClasses = null;
        try {
            stuClasses = stuClassDAO.findAll();
        } catch (DAOException ex) {
            ex.printStackTrace();
        }
        
        ComboItem[] classOptions = new ComboItem[stuClasses.size() + 1];
        index = 0;
        classOptions[index++] = new ComboItem(-1l, "select");
        for (StuClass stuClass : stuClasses) {
            classOptions[index++] = new ComboItem(stuClass.getId(), stuClass.getName());
        }
        
        classComboBox.setModel(new javax.swing.DefaultComboBoxModel(classOptions));
        
        classComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBoxActionPerformed(evt);
            }
        });
        
        haderLabel.setText("Please select a subject");

         javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
        subjectPanel.setLayout(subjectPanelLayout);
        subjectPanelLayout.setHorizontalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addComponent(haderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addComponent(classLabel)
                        .addGap(18, 18, 18)
                        .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        subjectPanelLayout.setVerticalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(haderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classLabel)
                    .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        subjectPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {subjectComboBox, subjectLabel});

        javax.swing.GroupLayout questionsPanelLayout = new javax.swing.GroupLayout(questionsPanel);
        questionsPanel.setLayout(questionsPanelLayout);
        questionsPanelLayout.setHorizontalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        questionsPanelLayout.setVerticalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subjectPanel = new javax.swing.JPanel();
        subjectLabel = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox();
        haderLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        classComboBox = new javax.swing.JComboBox();
        questionsPanel = new javax.swing.JPanel();

        subjectLabel.setText("Subject: ");

        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        subjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboBoxActionPerformed(evt);
            }
        });
        subjectComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                subjectComboBoxPropertyChange(evt);
            }
        });

        haderLabel.setText("Please select a subject");

        classLabel.setText("Class: ");

        classComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        classComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBoxActionPerformed(evt);
            }
        });
        classComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                classComboBoxPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
        subjectPanel.setLayout(subjectPanelLayout);
        subjectPanelLayout.setHorizontalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addComponent(haderLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addComponent(classLabel)
                        .addGap(18, 18, 18)
                        .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        subjectPanelLayout.setVerticalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(haderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classLabel)
                    .addComponent(classComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        subjectPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {subjectComboBox, subjectLabel});

        javax.swing.GroupLayout questionsPanelLayout = new javax.swing.GroupLayout(questionsPanel);
        questionsPanel.setLayout(questionsPanelLayout);
        questionsPanelLayout.setHorizontalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        questionsPanelLayout.setVerticalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void subjectComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_subjectComboBoxPropertyChange
        ComboItem subjectComboItem = (ComboItem )subjectComboBox.getSelectedItem();
        ComboItem classComboItem = (ComboItem )classComboBox.getSelectedItem();
        if (subjectComboItem.getValue() != -1l && classComboItem.getValue() != -1l) {
            questionsPanel.add(new CreateExamPanel(subjectComboItem.getValue(), classComboItem.getValue()));
        }
    }//GEN-LAST:event_subjectComboBoxPropertyChange

    private void classComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_classComboBoxPropertyChange
        ComboItem subjectComboItem = (ComboItem )subjectComboBox.getSelectedItem();
        ComboItem classComboItem = (ComboItem )classComboBox.getSelectedItem();
        if (subjectComboItem.getValue() != -1l && classComboItem.getValue() != -1l) {
            questionsPanel.add(new CreateExamPanel(subjectComboItem.getValue(), classComboItem.getValue()));
        }
    }//GEN-LAST:event_classComboBoxPropertyChange

    private void classComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboBoxActionPerformed
        ComboItem subjectComboItem = (ComboItem )subjectComboBox.getSelectedItem();
        ComboItem classComboItem = (ComboItem )classComboBox.getSelectedItem();
        if (subjectComboItem.getValue() != -1l && classComboItem.getValue() != -1l) {
            questionsPanel = new CreateExamPanel(subjectComboItem.getValue(), classComboItem.getValue());
        }
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) this.getLayout();
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        this.repaint(); questionsPanel.repaint();
    }//GEN-LAST:event_classComboBoxActionPerformed

    private void subjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboBoxActionPerformed
        ComboItem subjectComboItem = (ComboItem )subjectComboBox.getSelectedItem();
        ComboItem classComboItem = (ComboItem )classComboBox.getSelectedItem();
        if (subjectComboItem.getValue() != -1l && classComboItem.getValue() != -1l) {
            questionsPanel = new CreateExamPanel(subjectComboItem.getValue(), classComboItem.getValue());
        }
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) this.getLayout();
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        this.repaint(); questionsPanel.repaint();
    }//GEN-LAST:event_subjectComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classComboBox;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel haderLabel;
    private javax.swing.JPanel questionsPanel;
    private javax.swing.JComboBox subjectComboBox;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JPanel subjectPanel;
    // End of variables declaration//GEN-END:variables

    private SubjectDAO subjectDAO;
}
