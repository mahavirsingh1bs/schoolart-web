/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function ChapterCriteria() {
    this.operand;
    this.chapter;
    this.next;
    
    this.create = function(chapter, operand, next) {
        this.chapter = chapter;
        this.operand = operand;
        this.next = next;
        return this;
    };
    
    this.getOperand = function() {
        this.operand;
    };
    
    this.getChapter = function() {
        this.chapter;
    };
    
    this.getNext = function() {
        this.next;
    };
    
    this.setOperand = function(operand) {
        this.operand = operand;
    };
    
    this.setChapter = function(chapter) {
        this.chapter = chapter;
    };
    
    this.setNext = function(next) {
        this.next = next;
        return this;
    };
};

var criteria = ChapterCriteria.create();