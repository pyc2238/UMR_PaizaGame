package winterPro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explain extends GameCommandCenter {

	Explain() {	//������
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/�츶�������.png")); // �ڹ� ������ ���� 
		setSize(1100, 400);// ������ ���� width,height
		setTitle("How to play");//
		setLocationRelativeTo(null); // ��½� �߾� ��ġ
		setResizable(false); // ����ڰ� ������ ���� �Ұ�
		
		panel3 = new JPanel(); // �гλ���
		imagePanel = new JPanel(){ImageIcon i = new ImageIcon("img/������.png");
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 900, 590, null);
		}
	};		
		
		button4 = new JButton("�ݱ�"); // '�ݱ�'��ư ����
		button4.addActionListener(new ActionListener() { // button4 Ŭ���� â ����
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button4) {
					setVisible(false);
				}
			}
		});// end of anonymous class
		
		label2 = new JLabel("\n\n\n���־��� �ð����� ȭ���� �ҽ��ڵ带 ���� � ��¹��� �������� �˾� ���ߴ� ����Դϴ�");
		label3 = new JLabel("�������� �����̸� �� 7������ ����, �������� ����ð��� ������������ ����� �������� ����Ʈ�� ȹ�氡���մϴ�");
		label4 = new JLabel("������Ʈ�� �� ��ưȰ��ȭ�� ��� �����ϸ�,������ 3ȸ���� �Է°����մϴ�.");
		label2.setFont(f3); // label ��Ʈ ��Ÿ�� ����
		label3.setFont(f3);
		label4.setFont(f3);
		
		////�� label�� button4�� panel3�� ����////
		panel3.add(label2); 
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(button4);
		panel3.add(imagePanel);
		panel3.setLayout(null); // ���� ��ġ ����
		
		////label ��ġ����////
		label2.setBounds(155, 20, 2000, 70); 
		label3.setBounds(25, 100, 2000, 70);
		label4.setBounds(195, 180, 2000, 70);
		button4.setBounds(500, 300, 90, 45);
		imagePanel.setBounds(575,60,900,590);
		
		////��ư ��Ʈ �÷� ����////
		button4.setFocusPainted(false); //��ư �׵θ�����
		button4.setForeground(Color.YELLOW); 
		button4.setBackground(Color.BLACK);
		panel3.setBackground(Color.white);

		add(panel3);
		setVisible(true); // �������� ȭ�鿡 ���
		
		
	}//end of Explain()
	
}// end of Explain class