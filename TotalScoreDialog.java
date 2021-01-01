import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TotalScoreDialog {
	private static Dialog d;
	TotalScoreDialog(String name, String rollNo, String cls, Float score) {
		Frame f = new Frame();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		d = new Dialog(f, "Your Score");
		d.setLayout(new GridLayout(3, 1));
		Button b = new Button("Restart Quiz");
		Label l1 = new Label("Hey "+ name + " !!  ("+ rollNo + ")"+ "   ("+ cls + ")");
		Label l2 = new Label("Your score is : "  + score.intValue());
		l1.setFont(font);
		l2.setFont(font);
		b.setBackground(Color.orange);
		b.setForeground(Color.white);
		b.setFont(font);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalScoreDialog.d.setVisible(false);
			}
		});
		d.add(l1);
		d.add(l2);
		d.add(b);
		d.setSize(400, 130);
		d.setVisible(true);
	}
}
