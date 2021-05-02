package APItest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {

	public static void main(String[] args) {
		
		Caller caller = new Caller();

		JFrame GUI = new JFrame();
		GUI.setSize(800, 700);
		GUI.setLocationRelativeTo(null);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setResizable(false);
		GUI.setTitle("API_Test");

		

		JPanel panel = new JPanel(null);

		String[] listStrings = new String[] { "","JSpell Checker", "GrammarBot", "TextGears.Readability"
				, "TextGears.Summarization and keywords" , "TextGears.Spell checker", "TextGears.Grammar check"
				, "WebSpellChecker.spellCheck", "WebSpellChecker.grammarCheck"
		};
		
		JComboBox<String> comboBox = new JComboBox<String>(listStrings);
		comboBox.setBounds(300, 0, 200, 50);
		comboBox.setSelectedIndex(0);		
		
		JTextArea textArea1 = new JTextArea(10, 10);
		JScrollPane scrollPane1 = new JScrollPane(textArea1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(10, 50, 380, 550);

		JTextArea textArea2 = new JTextArea(10, 10);
		JScrollPane scrollPane2 = new JScrollPane(textArea2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBounds(410, 50, 380, 550);
		
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("test")) {	
					
					textArea2.setText( caller.Call(comboBox.getSelectedItem().toString(), textArea1.getText()) );					
				}
			}
		};
		

		JButton button = new JButton("測試");
		button.setBounds(350, 612, 100, 50);
		button.setActionCommand("test");
		button.addActionListener(listener);

		panel.add(comboBox);
		panel.add(scrollPane1);
		panel.add(scrollPane2);
		panel.add(button);

		GUI.setContentPane(panel);
		GUI.setVisible(true);

	}

}
