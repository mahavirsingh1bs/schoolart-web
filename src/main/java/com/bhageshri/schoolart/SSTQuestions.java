package com.bhageshri.schoolart;

import com.bhageshri.schoolart.bean.ChapterCriteria;
import com.bhageshri.schoolart.dao.ExerciseDAO;
import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.domain.Exercise;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.util.BeanResolverUtil;
import com.bhageshri.schoolart.util.Operand;
import com.bhageshri.schoolart.util.QuestionType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SSTQuestions {

    private static final String TAB_SPACE = "   ";
    private static final String SPACE = " ";
    private static final String QUES_CONT = "Q.";

    /**
     * public static void main(String...args) throws DAOException { Question
     * question = new Question(QuestionType.VERY_SHORT, "what tell us about
     * past", "History"); QuestionDAO questionDAO = (QuestionDAO)
     * BeanResolverUtil.getBean("questionDAO"); questionDAO.create(question); }
     */
    public static void main(String... args) throws DAOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            ExerciseDAO exerciseDAO = (ExerciseDAO) BeanResolverUtil.getBean("exerciseDAO");
            List<Exercise> exercises = exerciseDAO.findAll();

            System.out.println("Please, Select the exercise's serial No: ");
            int serialNo = 1;
            for (Exercise exercise : exercises) {
                System.out.println(TAB_SPACE + serialNo++ + ". " + exercise.getName());
            }

            Integer exerciseId = Integer.parseInt(reader.readLine());
            QuestionDAO questionDAO = (QuestionDAO) BeanResolverUtil.getBean("questionDAO");
            System.out.println("Please, give the answer of following question");
            Exercise exercise = exercises.get(exerciseId);
            char engChar = 'A';
            for (QuestionType type : QuestionType.values()) {
                System.out.println(engChar + "." + SPACE + type.getName());
                int questionSerialNo = 1;
                List<Question> questions = questionDAO.findQuestionByExerciseAndType(exercise, type);
                for (Question question : questions) {
                    System.out.println(TAB_SPACE + QUES_CONT + questionSerialNo++ + SPACE + question.getQuestion());
                }
                engChar = (char) ((int) engChar + 1);
            }
            
            ChapterCriteria chapters = ChapterCriteria.instance(1, Operand.OR);
            chapters.setNext(
                ChapterCriteria.instance(5, Operand.OR).setNext(
                    ChapterCriteria.instance(7, Operand.TO).setNext(
                        ChapterCriteria.instance(9))));
            
            System.out.println(questionDAO.findQuestionByTypeAndSubject(1l, 2l, QuestionType.SHORT, chapters).size());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /**
         * Question question = new Question(QuestionType.VERY_SHORT, "what tell
         * us about past", "History"); QuestionDAO questionDAO = (QuestionDAO)
         * BeanResolverUtil.getBean("questionDAO");
         * questionDAO.create(question);
         */
    }
}
