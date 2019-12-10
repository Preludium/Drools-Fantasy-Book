package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.*;

public class DroolsTest {

	public static final void main(String[] args) {
        try {
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static int askQuestion(String question, String[] answers) {
    	return JOptionPane.showOptionDialog(null, question, null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, answers, answers[0]);
    }
    
    public static void showAnswer(String answer) {
    	JOptionPane.showMessageDialog(null, answer, "Answer", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean[] chooseAnswer(String question, String[] answers) {
        Object[] components = new Object[answers.length + 1];
        for (int i = 0; i < answers.length; i++) {
            components[i] = new JCheckBox(answers[i]);
        }
        components[answers.length] = "Confirm";

        JOptionPane.showOptionDialog(null, question, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, components, null);

        boolean[] arr = new boolean[answers.length];
        for(int i = 0; i < answers.length; i++) {
            if (((JCheckBox) components[i]).isSelected())
            	arr[i] = true;
        }
       
        return arr;
    }
    
    public static void showAnswers(String[] books, boolean[] chosen) {
    	String answer = new String("");
    	
    	for (int i=0; i<chosen.length; ++i) {
    		if (chosen[i])
    			answer += books[i] + "\n";
    	}
    	
    	if (answer.isEmpty())
    		answer = "No books for you, I'm sorry :(";
    	
    	showAnswer(answer);
    }

}
