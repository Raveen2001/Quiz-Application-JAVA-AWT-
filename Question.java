public class Question {
	String question;
	String[] answers;
	String[] crtAnswers;
	float score;

	Question(String question, String[] answers, String[] crtAnswers, float score){
		this.question = question;
		this.answers = answers;
		this.crtAnswers = crtAnswers;
		this.score = score;
	}
	public static Question[] questions = {
			new Question("Question 1", new String[]{"Answer 1", "Answer 2", "Answer 3"}, new String[]{"Answer 1", "Answer 2", "Answer 3"},10f),
			new Question("Question 2", new String[]{"Answer 1", "Answer 2", "Answer 3"}, new String[]{"Answer 1"},10f),
			new Question("Question 3", new String[]{"Answer 1", "Answer 2", "Answer 3"}, new String[]{"Answer 1", "Answer 2", "Answer 3"},10f ),
	};
}


