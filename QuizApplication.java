import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
<applet code="QuizApplication" width="500" height="400">
</applet>
*/
public class QuizApplication extends Applet{
	int quesNo = 0;
	Label question;
	Font font;
	CheckboxGroup cbg;
	Checkbox[] cb = new Checkbox[5];
	Button button;
	Question[] questions = Question.questions;
	float totalScore = 0f;
	float quesScore = 0f;
	public void init(){
		font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		setLayout(new GridLayout(7, 1));
		cbg = new CheckboxGroup();
		question = new Label();
		question.setBackground(Color.ORANGE);
		question.setForeground(Color.white);
		question.setFont(font);
		question.setAlignment(Label.CENTER);
		add(question);
		for(int i = 0; i < questions[quesNo].answers.length; i++){
			cb[i] = new Checkbox(questions[quesNo].answers[i], false);
			cb[i].setFont(font);
			cb[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent itemEvent) {
					float score = questions[quesNo].crtAnswers.length == 1? questions[quesNo].score: (questions[quesNo].score)/questions[quesNo].crtAnswers.length;
					if(questions[quesNo].crtAnswers.length ==1){
						if(itemEvent.getStateChange() == ItemEvent.SELECTED){
								if(questions[quesNo].crtAnswers[0].equals(itemEvent.getItem().toString())){
									quesScore += score;
								}else{
									quesScore = 0;
								}
						}
					}else{
						if(itemEvent.getStateChange() == ItemEvent.SELECTED){
							for(String answer: questions[quesNo].crtAnswers){
								if(answer.equals(itemEvent.getItem().toString())){
									quesScore += score;
								}
							}
						}else{
							for(String answer: questions[quesNo].crtAnswers){
								if(answer.equals(itemEvent.getItem().toString())){
									if((int)quesScore == (int)score) {
										quesScore = 0f;
									}
									else quesScore -= score;
								}
							}
						}
					}
					System.out.println(quesScore);
				}
			});
			add(cb[i]);
		}
		button = new Button("Next");
		button.setBackground(Color.orange);
		button.setForeground(Color.white);
		button.setFont(font);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				totalScore += quesScore;
				quesScore = 0;
				if(quesNo < questions.length-1){
					quesNo++;
				}else{
					new GetUserName(totalScore);
					quesNo = 0;
					totalScore = 0f;
				}


				System.out.println(quesNo);
				System.out.println(totalScore);
				repaint();
			}
		});
		add(button);
		showStatus("Each Question has 10 marks!!");
	}

	public void paint(Graphics g) {
		question.setText(questions[quesNo].question);
		for (int i = 0; i < questions[quesNo].answers.length; i++) {
			cb[i].setLabel(questions[quesNo].answers[i]);
			cb[i].setState(false);
			if (questions[quesNo].crtAnswers.length == 1) {
				cb[i].setCheckboxGroup(cbg);
			} else {
				cb[i].setCheckboxGroup(null);
				cb[i].setState(false);
			}
		}

		if(quesNo == questions.length - 1){
			button.setLabel("Submit");

		}else{
			button.setLabel("Next");
		}
	}

}


