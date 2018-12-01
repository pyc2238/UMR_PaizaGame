package winterPro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeOut extends GameCommandCenter{
	
	public TimeOut() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/�츶�������.png")); // �ڹ� ������ ����
		
		Font laF = new Font("����", Font.BOLD, 28); // label ��Ʈ ��ü ����
		Font buf = new Font("����", Font.BOLD, 25); // button ��Ʈ ��ü ����
		
		setSize(400, 240); // ������
		setTitle("EndChoice!"); // Ÿ��Ʋ
		setLocationRelativeTo(null); // ��½� �߾� ��ġ
		setResizable(false); // ����ڰ� ������ ���� �Ұ�
		
		panel5 = new JPanel(); // �ǳ� ����
		choLabel = new JLabel("�ð��� �ʰ��Ǿ����ϴ�"); // label ����
		
		panel5.add(choLabel); // panel5�� choLabel ����
		
		button7 = new JButton("�絵��"); // �� ��ư ������Ʈ ����
		button8 = new JButton("����");
		panel5.add(button7); // panel5�� ��ư ������Ʈ ����
		panel5.add(button8);
		
		button7.setBounds(63, 110, 110, 50); // ��ư ��ġ����
		button8.setBounds(213, 110, 110, 50);
		choLabel.setBounds(40, 20, 500, 70); // label ��ġ ����
		choLabel.setFont(laF); // label ��Ʈ ����
		
		//// ��ư ��Ʈ �÷� ���� �� �̺�Ʈ ���////
		button7.addActionListener(this);
		button8.addActionListener(this);
		button7.setFocusPainted(false); //��ư �׵θ�����
		button7.setFont(buf); // ��ư ��Ʈ ����
		button8.setFont(buf);
		button7.setForeground(Color.YELLOW); 
		button8.setForeground(Color.YELLOW);
		button7.setBackground(Color.BLACK);
		button8.setBackground(Color.BLACK);
		panel5.setBackground(Color.white);
		
		add(panel5); // �ǳ� ����
		panel5.setLayout(null); // ���� ��ġ ��ġ
		setVisible(true); // �������� ȭ�鿡 ���
		
		

	}//end of TimeOut()
	
	
	public void actionPerformed(ActionEvent e) { // Actio6nListenerŬ������ �߻�޼ҵ�

		switch (e.getActionCommand()) { // String���� �ݳ�
		case "�絵��":
			setVisible(false);
			new GameBoard(); // winterGameGui() �����
			break; // '�絵��' ��ư Ŭ���� setVisible�� false�� ����
		case "����":
			System.exit(0); // ��� �ý����� ����
			break; // '����' ��ư Ŭ���� ��������
		default:
			break;
		}// end of switch
	}// end of actionPerformed
}//end of TimeOut Class
