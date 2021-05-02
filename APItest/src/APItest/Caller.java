package APItest;

public class Caller {
	
	public String Call(String API, String text) {
		
		String result = null;
				
		try {
		
			switch (API) {
			case "JSpell Checker":
				JSpell jSpell = new JSpell();
				result = jSpell.run(text);
				break;
				
			case "GrammarBot":
				GrammarBot bot = new GrammarBot();
				result = bot.run(text);
				break;
				
			case "TextGears.Readability":
				TextGears gear1 = new TextGears();
				result = gear1.readability(text);
				break;
				
			case "TextGears.Summarization and keywords":
				TextGears gear2 = new TextGears();
				result = gear2.summarize(text);
				break;
				
			case "TextGears.Spell checker":
				TextGears gear3 = new TextGears();
				result = gear3.spelling(text);
				break;
				
			case "TextGears.Grammar check":
				TextGears gear4 = new TextGears();
				result = gear4.grammar(text);
				break;
				
			case "WebSpellChecker.spellCheck":
				WebSpellChecker checker1 = new WebSpellChecker();
				result = checker1.spellCheck(text);
				break;
				
			case "WebSpellChecker.grammarCheck":
				WebSpellChecker checker2 = new WebSpellChecker();
				result = checker2.grammarCheck(text);
				break;
			
//			case "test":
//				JSONtest test = new JSONtest();
//				result = test.run(text);
//				break;
			
			default:
				
				result = "no chose";
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return result;
	}
}
