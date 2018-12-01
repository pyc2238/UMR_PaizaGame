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
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/우마루아이콘.png")); // 자바 아이콘 변경
		
		Font laF = new Font("굴림", Font.BOLD, 28); // label 폰트 객체 생성
		Font buf = new Font("굴림", Font.BOLD, 25); // button 폰트 객체 생성
		
		setSize(400, 240); // 사이즈
		setTitle("EndChoice!"); // 타이틀
		setLocationRelativeTo(null); // 출력시 중앙 위치
		setResizable(false); // 사용자가 사이즈 변경 불가
		
		panel5 = new JPanel(); // 판넬 생성
		choLabel = new JLabel("시간이 초과되었습니다"); // label 생성
		
		panel5.add(choLabel); // panel5에 choLabel 삽입
		
		button7 = new JButton("재도전"); // 각 버튼 컴포넌트 생성
		button8 = new JButton("종료");
		panel5.add(button7); // panel5에 버튼 컴포넌트 삽입
		panel5.add(button8);
		
		button7.setBounds(63, 110, 110, 50); // 버튼 위치조정
		button8.setBounds(213, 110, 110, 50);
		choLabel.setBounds(40, 20, 500, 70); // label 위치 조정
		choLabel.setFont(laF); // label 폰트 적용
		
		//// 버튼 폰트 컬러 적용 및 이벤트 등록////
		button7.addActionListener(this);
		button8.addActionListener(this);
		button7.setFocusPainted(false); //버튼 테두리삭제
		button7.setFont(buf); // 버튼 폰트 적용
		button8.setFont(buf);
		button7.setForeground(Color.YELLOW); 
		button8.setForeground(Color.YELLOW);
		button7.setBackground(Color.BLACK);
		button8.setBackground(Color.BLACK);
		panel5.setBackground(Color.white);
		
		add(panel5); // 판넬 삽입
		panel5.setLayout(null); // 절대 위치 배치
		setVisible(true); // 프레임을 화면에 출력
		
		

	}//end of TimeOut()
	
	
	public void actionPerformed(ActionEvent e) { // Actio6nListener클래스의 추상메소드

		switch (e.getActionCommand()) { // String형을 반납
		case "재도전":
			setVisible(false);
			new GameBoard(); // winterGameGui() 재시작
			break; // '재도전' 버튼 클릭시 setVisible를 false로 지정
		case "종료":
			System.exit(0); // 모든 시스템을 종료
			break; // '종료' 버튼 클릭시 게임종료
		default:
			break;
		}// end of switch
	}// end of actionPerformed
}//end of TimeOut Class
