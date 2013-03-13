package gui.widgets;

import javax.swing.JTextField;

import org.jdesktop.xswingx.PromptSupport;
import org.jdesktop.xswingx.PromptSupport.FocusBehavior;

public class MyTextField extends JTextField {
	public MyTextField() {
		PromptSupport.setFocusBehavior(FocusBehavior.SHOW_PROMPT, this);
	}
	
	public MyTextField(String prompt) {
		this();
		this.setPrompt(prompt);
	}
	
	public void setPrompt(String prompt) {
		PromptSupport.setPrompt(prompt, this);
	}
}
