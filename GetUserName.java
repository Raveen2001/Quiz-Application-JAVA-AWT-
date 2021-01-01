import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class GetUserName {
	private static Dialog d;
	String name, rollNo, cls;
	Float score;
	TextField t1;
	TextField t2;
	GetUserName(Float score) {
		this.score = score;
		cls = "CSE A";
		Frame f = new Frame();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		d = new Dialog(f, "Enter your details");
		d.setLayout(new GridLayout(7, 1));
		Button b = new Button("View Score");
		Label l1 = new Label("Name :");
		Label l2 = new Label("Roll No :");
		Label l3 = new Label("Class :");
		t1 = new TextField();
		t2 = new TextField();
		Choice choice = new Choice();
		choice.add("CSE A");
		choice.add("CSE B");
		choice.add("CSE C");
		choice.add("CSE D");
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				cls = itemEvent.getItem().toString();

			}
		});
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		b.setBackground(Color.orange);
		b.setForeground(Color.white);
		b.setFont(font);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = t1.getText();
				rollNo = t2.getText();
				if(name.isEmpty() || rollNo.isEmpty()) {
					return;
				}
				new TotalScoreDialog(name, rollNo, cls, score);
				GetUserName.d.setVisible(false);

//				System.out.println(t1.getText() + t2.getText() + cls);

			}
		});
		d.add(l1);
		d.add(t1);
		d.add(l2);
		d.add(t2);
		d.add(l3);
		d.add(choice);
		d.add(b);
		d.setSize(300, 300);
		d.setVisible(true);
	}
}
