package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.JOptionPane;

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

}
