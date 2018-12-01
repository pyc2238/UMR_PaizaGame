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
	 
	StartMenu(){//StartMenu 생성자
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/우마루아이콘.png")); // 자바 아이콘 변경		
		setSize(550, 450); // 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 전체 프로그램 종료
		setTitle("StartChoice!"); // 타이틀

		panel1 = new JPanel(){ImageIcon i = new ImageIcon("img/시작배경.png");
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 550,450,null);
		}};

		panel1.setLayout(null); // 절대 좌표 위치
		panel2 = new JPanel();	
		label1 = new JLabel("코딩 출력 맟추기");
		panel2.add(label1); // label1 패널

		////버튼 이미지 등록////
		button1 = new JButton("시작",normal_1);
		button1.setRolloverIcon(roll_1);
		button2 = new JButton("설명",normal_2);
		button2.setRolloverIcon(roll_2);
		button3 = new JButton("종료",normal_3);
		button3.setRolloverIcon(roll_3);
		
		////버튼 컴포넌트에 ActionListener 이벤트 등록////
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		////버튼 테두리 및 배경 설정////
		button1.setFont(f1);
		button2.setFont(f1);
		button3.setFont(f1);
		button1.setBorderPainted(false); // 버튼 전체 테두리 
		button1.setContentAreaFilled(false); // 버튼 배경 투명 설정
		button1.setFocusPainted(false); //버튼 테두리삭제
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false); 
		button2.setFocusPainted(false);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false); 
		button3.setFocusPainted(false); 

		////panel1에 버튼 컴포넌트 삽입////
		panel1.add(panel2); 
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);

		////버튼 위치 지정////
		button1.setBounds(115, 25, 178, 70); 
		button2.setBounds(115, 145, 178, 70);
		button3.setBounds(115, 265, 178, 70);

		add(panel2, BorderLayout.PAGE_START); // panel1 위치배치(상단)
		add(panel1);	//프레임에 패널삽입

		setVisible(true); // 프레임을 화면에 출력
		setLocationRelativeTo(null); // 프레임 화면 출력시 중앙 위치 고정
		setResizable(false); // 사용자가 사이즈 변경 불가

		//// 버튼 마우스 이벤트 등록////
		GameCommandCenter listener = new GameCommandCenter(); //EventBox 객체 생성
		button1.addMouseListener(listener); 
		button2.addMouseListener(listener);
		button3.addMouseListener(this);

	}//end of StartMenu()	
	
	
	@Override
	public void mousePressed(MouseEvent e) { // 종료버튼은 listener의 이벤트를 받지못함
	}

	@Override
	public void actionPerformed(ActionEvent e) { // ActionListener클래스의 추상메소드

		switch (e.getActionCommand()) { // String형을 반환
		case "시작":	 setVisible(false); new GameBoard(); break;
		case "설명":	 new Explain(); break; // '설명' 버튼 클릭시 winterStartGuiExplan() 출력
		case "종료":	setVisible(false);break; // '닫기' 버튼 클릭시 setVisible를 false로 지정
		default: break;
		}// end of switch
	}// end of actionPerformed()
}//end of StartMenu Class
