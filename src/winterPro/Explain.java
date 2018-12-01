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

	Explain() {	//생성자
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/우마루아이콘.png")); // 자바 아이콘 변경 
		setSize(1100, 400);// 사이즈 설정 width,height
		setTitle("How to play");//
		setLocationRelativeTo(null); // 출력시 중앙 위치
		setResizable(false); // 사용자가 사이즈 변경 불가
		
		panel3 = new JPanel(); // 패널생성
		imagePanel = new JPanel(){ImageIcon i = new ImageIcon("img/설명배경.png");
		public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(), 0, 0, 900, 590, null);
		}
	};		
		
		button4 = new JButton("닫기"); // '닫기'버튼 생성
		button4.addActionListener(new ActionListener() { // button4 클릭시 창 종료
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button4) {
					setVisible(false);
				}
			}
		});// end of anonymous class
		
		label2 = new JLabel("\n\n\n▶주어진 시간동안 화면의 소스코드를 보고 어떤 출력문이 나오는지 알아 맞추는 방식입니다");
		label3 = new JLabel("▶내용은 랜덤이며 총 7문제로 구성, 문제별로 제출시간이 한정되있으며 정답시 일정량의 포인트를 획득가능합니다");
		label4 = new JLabel("▶포인트는 각 버튼활성화에 사용 가능하며,정답은 3회까지 입력가능합니다.");
		label2.setFont(f3); // label 폰트 스타일 적용
		label3.setFont(f3);
		label4.setFont(f3);
		
		////각 label과 button4를 panel3에 삽입////
		panel3.add(label2); 
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(button4);
		panel3.add(imagePanel);
		panel3.setLayout(null); // 절대 위치 고정
		
		////label 위치조정////
		label2.setBounds(155, 20, 2000, 70); 
		label3.setBounds(25, 100, 2000, 70);
		label4.setBounds(195, 180, 2000, 70);
		button4.setBounds(500, 300, 90, 45);
		imagePanel.setBounds(575,60,900,590);
		
		////버튼 폰트 컬러 적용////
		button4.setFocusPainted(false); //버튼 테두리삭제
		button4.setForeground(Color.YELLOW); 
		button4.setBackground(Color.BLACK);
		panel3.setBackground(Color.white);

		add(panel3);
		setVisible(true); // 프레임을 화면에 출력
		
		
	}//end of Explain()
	
}// end of Explain class