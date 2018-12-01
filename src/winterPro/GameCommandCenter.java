package winterPro;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameCommandCenter extends JFrame implements ActionListener, MouseListener {

	// ===============================================//

	//// 폰트 객체 ////
	protected Font f1 = new Font("굴림", Font.BOLD, 1); // StartMenu Class button 폰트 객체
	protected Font f2 = new Font("굴림", Font.BOLD, 25); // GameBoard Class timeLabel 폰트 객체
	protected Font f3 = new Font("바탕체", Font.BOLD, 19);// Explain label폰트 객체
	protected Font f4 = new Font("바탕체", Font.BOLD, 18);// inputCountLabel폰트 객체
	protected Font f5 = new Font("바탕체", Font.BOLD, 15);// inputCountLabel폰트 객체

	//// TestCollection/////
	TestCollection test = new TestCollection(); // new연산자로 GameCommandCenter가 TestCollection의 객체 참조

	////////// StartMenu////////////
	protected JPanel panel1; // 스타트 패널
	protected JPanel panel2; // 타이틀 패널
	protected JLabel label1; // 타이틀 레이블
	protected JButton button1; // 시작 버튼
	protected JButton button2; // 설명 버튼
	protected JButton button3; // 종료 버튼

	protected ImageIcon normal_1 = new ImageIcon("img/시작1.png");
	protected ImageIcon roll_1 = new ImageIcon("img/시작2.png");
	protected ImageIcon normal_2 = new ImageIcon("img/설명1.png");
	protected ImageIcon roll_2 = new ImageIcon("img/설명2.png");
	protected ImageIcon normal_3 = new ImageIcon("img/종료1.png");
	protected ImageIcon roll_3 = new ImageIcon("img/종료2.png");

	////////// Explain////////////
	protected JPanel panel3, imagePanel; // 설명 패널
	protected JButton button4; // '닫기'버튼
	protected JLabel label2, label3, label4; // 게임 설명 내용	
	
	////////// GameBoard////////////
	protected String clear_message = "[모든 문제를 푸셨습니다!]";
	protected String shortagePoint_message = "[포인트가 부족합니다!]\n" + "문제를 맞추셔서 포인트를 획득하세요";
	protected String space_1 = "";
	protected String space_2 = "";

	protected int randomValue; // 문제의 출제는 난수값으로 지정
	protected int point = 0; // 초기 포인트값 0점
	protected int minute = 10; // 분을 나타내는 변수
	protected int second = 0; // 초를 나타내는 변수
	protected int time = 599; // 초기 Thread 동작 시간 600초(=6분)
	protected int pointCount = 0; // 포인트 카운터가 '7'일시 게임 클리어
	protected int inputCount = 0; // 정답입력 횟수 제한(3회)
	
	protected boolean test_1_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_2_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_3_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_4_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_5_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_6_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수
	protected boolean test_7_out = false; // 문제의 중복시 문제 재 설정에서 요구되는 변수

	protected JPanel panel4; // 전체 패널,카운트다운 패널,정답입력메뉴패널
	protected JPanel countPanel; // 카운트다운 시간초가 삽입된 패널
	protected JPanel inputPanel; // 정답입력 메뉴 패널
	protected JButton button5;// '등록' 버튼
	protected JButton button6; // '연장' 버튼
	protected JButton resetBtn; // '초기화' 버튼
	protected JButton spBtn; // 스페셜 버튼
	protected JLabel timeLabel; // 남은 시간을 나타내는 label
	protected JLabel pointLabel;//현재 포인트를 나타내는 label
	protected JLabel inputCountLabel; // 등록 횟수 표시
	protected JTextArea tArea; // 소스코드 문제 출력 필드
	protected JTextField tField; // 정답 입력 필드
	protected JScrollPane scroll; // 스크롤 객체
	
	//// 콤보박스////
	protected JPanel comboPanel;
	protected JLabel comboLabel;
	protected JComboBox umrList;
	protected ImageIcon icon;
	protected String[] umrFriends = { "우마루.png", "실핀.png", "에비나.png", "키리에.png" };
	
	////////// TimeOut////////////
	protected JPanel panel5;
	protected JLabel choLabel; // 재도전 여부 문장
	protected JButton button7, button8; // 재시작,종료 버튼

	//// 게임 동작 메소드////

	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon("img\\" + name);
		comboLabel.setIcon(icon);
		if (icon != null) {
			comboLabel.setText(null);
		} else {
			comboLabel.setText("이미지가 발견되지 않았습니다");
		}

	}

	protected void test_change() {

		randomValue = (int) (Math.random() * 7 + 1); // 난수값 지정으로 출제문제의 번호와 연동

		if (test_1_out == true && test_2_out == true && test_3_out == true && test_4_out == true && test_5_out == true
				&& test_6_out == true && test_7_out == true) {
			JOptionPane.showMessageDialog(null, clear_message);

			new StartMenu();// 문제를 모두 풀었을시 다시 메뉴 선택창으로 이동
			return; // 문제를 모두 풀었을시에 해당되는 조건문이므로 현 메소드 종료
		} else if (randomValue == 1) {
			if (test_1_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[0][0]);
				time = 299;
				minute = 5;
				test_1_out = true;
			}
		} else if (randomValue == 2) {
			if (test_2_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[1][0]);
				time = 299;
				minute = 5;
				test_2_out = true;
			}
		} else if (randomValue == 3) {
			if (test_3_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[2][0]);
				time = 299;
				minute = 5;
				test_3_out = true;
			}
		} else if (randomValue == 4) {
			if (test_4_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[3][0]);
				time = 479;
				minute = 8;
				test_4_out = true;
			}
		} else if (randomValue == 5) {
			if (test_5_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[4][0]);
				time = 719;
				minute = 12;
				test_5_out = true;
			}
		} else if (randomValue == 6) {
			if (test_6_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[5][0]);
				time = 359;
				minute = 6;
				test_6_out = true;
			}
		} else if (randomValue == 7) {
			if (test_7_out == true) {
				randomValue = (int) (Math.random() * 7 + 1);
				test_change();
			} else {
				tArea.setText(test.test[6][0]);
				time = 299;
				minute = 5;
				test_7_out = true;
			}
		}
	}// end of test_Change()
	
	
	//// 게임 동작 이벤트////
	public void actionPerformed(ActionEvent e) { // Actio6nListener클래스의 추상메소드
	
	}// end of actionPerformed()

	@Override // 마우스가 버튼 안으로 들어오면 하얀색으로 바뀜
	public void mouseEntered(MouseEvent e) {

	}

	@Override // 마우스가 버튼 밖으로 나가면 검은색으로 바뀜
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { // 마우스 클릭시 버튼 효과음 발생
		JButton btn = (JButton) e.getSource();
		try {
			FileInputStream fileInputStream = new FileInputStream("버튼음.mp3"); // File 변수에 mp3파일 삽입
			Player player = new Player(fileInputStream);
			player.play();
		} catch (FileNotFoundException s) {
			s.printStackTrace();

		} catch (JavaLayerException s) {
			s.printStackTrace();
		}

	}// end of MousePressed()

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	class subBox extends GameCommandCenter {
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
}// end of GameCommandCenter()
