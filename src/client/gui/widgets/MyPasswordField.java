package gui.widgets;

import javax.swing.JPasswordField;

import org.jdesktop.xswingx.PromptSupport;
import org.jdesktop.xswingx.PromptSupport.FocusBehavior;


public class MyPasswordField extends JPasswordField {
	public MyPasswordField() {
		PromptSupport.setFocusBehavior(FocusBehavior.SHOW_PROMPT, this);
	}
	
	public MyPasswordField(String prompt) {
		this();
		this.setPrompt(prompt);
	}
	
	public void setPrompt(String prompt) {
		PromptSupport.setPrompt(prompt, this);
	}
}
