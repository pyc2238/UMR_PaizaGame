package winterPro;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends GameCommandCenter {
	 
	StartMenu(){//StartMenu ������
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/�츶�������.png")); // �ڹ� ������ ����		
		setSize(550, 450); // ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ��ü ���α׷� ����
		setTitle("StartChoice!"); // Ÿ��Ʋ

		panel1 = new JPanel(){ImageIcon i = new ImageIcon("img/���۹��.png");
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 550,450,null);
		}};

		panel1.setLayout(null); // ���� ��ǥ ��ġ
		panel2 = new JPanel();	
		label1 = new JLabel("�ڵ� ��� ���߱�");
		panel2.add(label1); // label1 �г�

		////��ư �̹��� ���////
		button1 = new JButton("����",normal_1);
		button1.setRolloverIcon(roll_1);
		button2 = new JButton("����",normal_2);
		button2.setRolloverIcon(roll_2);
		button3 = new JButton("����",normal_3);
		button3.setRolloverIcon(roll_3);
		
		////��ư ������Ʈ�� ActionListener �̺�Ʈ ���////
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		////��ư �׵θ� �� ��� ����////
		button1.setFont(f1);
		button2.setFont(f1);
		button3.setFont(f1);
		button1.setBorderPainted(false); // ��ư ��ü �׵θ� 
		button1.setContentAreaFilled(false); // ��ư ��� ���� ����
		button1.setFocusPainted(false); //��ư �׵θ�����
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false); 
		button2.setFocusPainted(false);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false); 
		button3.setFocusPainted(false); 

		////panel1�� ��ư ������Ʈ ����////
		panel1.add(panel2); 
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);

		////��ư ��ġ ����////
		button1.setBounds(115, 25, 178, 70); 
		button2.setBounds(115, 145, 178, 70);
		button3.setBounds(115, 265, 178, 70);

		add(panel2, BorderLayout.PAGE_START); // panel1 ��ġ��ġ(���)
		add(panel1);	//�����ӿ� �гλ���

		setVisible(true); // �������� ȭ�鿡 ���
		setLocationRelativeTo(null); // ������ ȭ�� ��½� �߾� ��ġ ����
		setResizable(false); // ����ڰ� ������ ���� �Ұ�

		//// ��ư ���콺 �̺�Ʈ ���////
		GameCommandCenter listener = new GameCommandCenter(); //EventBox ��ü ����
		button1.addMouseListener(listener); 
		button2.addMouseListener(listener);
		button3.addMouseListener(this);

	}//end of StartMenu()	
	
	
	@Override
	public void mousePressed(MouseEvent e) { // �����ư�� listener�� �̺�Ʈ�� ��������
	}

	@Override
	public void actionPerformed(ActionEvent e) { // ActionListenerŬ������ �߻�޼ҵ�

		switch (e.getActionCommand()) { // String���� ��ȯ
		case "����":	 setVisible(false); new GameBoard(); break;
		case "����":	 new Explain(); break; // '����' ��ư Ŭ���� winterStartGuiExplan() ���
		case "����":	setVisible(false);break; // '�ݱ�' ��ư Ŭ���� setVisible�� false�� ����
		default: break;
		}// end of switch
	}// end of actionPerformed()
}//end of StartMenu Class
