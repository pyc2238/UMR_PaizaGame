package winterPro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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

public class GameBoard extends GameCommandCenter { // winterEventBox 클래스 상속

	public GameBoard() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/우마루아이콘.png")); // 자바 아이콘 변경

		setTitle("play to game");
		setSize(900, 800);
		setLocationRelativeTo(null); // 중앙출력
		setResizable(false); // 사용자가 사이즈 변경 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel4 = new JPanel() {
			ImageIcon i = new ImageIcon("img/게임보더.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 900, 800, null);
			}
		};

		panel4.setLayout(null);

		pointLabel = new JLabel("포인트: 0");

		//// 소스코드 출력 부분 ////

		tArea = new JTextArea(600, 743);// height,width
		tArea.setFont(new Font("Dialog", Font.BOLD, 15));
		test_change();

		JScrollPane scroll = new JScrollPane(tArea); // scroll 객체 생성
		panel4.add(scroll);
		scroll.setBounds(10, 10, 600, 743);

		//// 정답 입력 및 시간연장 메뉴 부분 ////

		countPanel = new JPanel() {
			ImageIcon i = new ImageIcon("img/시간테두리.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 270, 350, null);
			}
		};// 카운터 시간이 삽입된 패널
		inputPanel = new JPanel();// 정답 입력 메뉴 패널
		button5 = new JButton("등록"); // 정답입력 버튼
		resetBtn = new JButton("리셋");
		spBtn = new JButton("스페셜");
		spBtn.addMouseListener(this); // spBtn의 MouseListener
		tField = new JTextField(); // 정답입력 텍스트

		inputCountLabel = new JLabel("등록횟수 : 0");
		inputPanel.setLayout(null);
		inputPanel.add(resetBtn);
		inputPanel.add(tField);
		inputPanel.add(button5); // 정답 입력버튼
		inputPanel.add(spBtn);
		inputPanel.add(inputCountLabel);

		inputCountLabel.setFont(f4);
		tField.setBounds(10, 300, 170, 25); // 좌,우,넓이,높이
		button5.setBounds(190, 300, 70, 25); // 입력 버튼 위치 지정
		resetBtn.setBounds(190, 240, 70, 25); // 초기화 버튼 위치 지정
		spBtn.setBounds(185, 210, 80, 25);
		inputCountLabel.setBounds(28, 237, 200, 50);

		inputPanel.setBackground(Color.ORANGE);
		inputPanel.setBounds(617, 402, 270, 350);

		//// 콤보박스////
		umrList = new JComboBox(umrFriends);
		umrList.setSelectedIndex(0);
		umrList.addActionListener(this);

		comboLabel = new JLabel();
		comboLabel.setHorizontalAlignment(JLabel.CENTER);
		changePicture(umrFriends[umrList.getSelectedIndex()]);

		comboPanel = new JPanel();
		comboPanel.setLayout(null);
		comboPanel.add(umrList);
		comboPanel.add(comboLabel);
		umrList.setBounds(32, 0, 150, 30);
		comboLabel.setBounds(5, 35, 205, 185);
		comboPanel.setBackground(Color.ORANGE);
		comboPanel.setBounds(30, 15, 210, 230);

		inputPanel.add(comboPanel);
		panel4.add(inputPanel);

		//// 시간 카운트 부분 ////

		button6 = new JButton("연장"); // 시간 연장 버튼
		timeLabel = new JLabel(); // 남은 시간을 나타내는 label
		countPanel.setLayout(null);
		inputPanel.setLayout(null);
		button6.setBounds(190, 270, 70, 25); // 연장 버튼 위치조정
		timeLabel.setFont(f2);
		timeLabel.setBounds(22, 125, 300, 25); // 타임라벨 위치조정
		pointLabel.setFont(f2);
		pointLabel.setBounds(30, 180, 300, 25);

		inputPanel.add(button6);
		countPanel.add(timeLabel);
		countPanel.add(pointLabel);
		countPanel.setBounds(617, 15, 270, 350);
		panel4.add(countPanel);

		spBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == spBtn) {
					if (point <= 2) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point >= 3) {
						point -= 3;
						minute += 5;
						second += 0;
						time += 300;
						inputCount = 0;
						inputCountLabel.setText("등록횟수 : " + inputCount);
						pointLabel.setText("포인트: " + point);

					}
				}
			}
		});

		

		button6.addActionListener(new ActionListener() { // button6의 무명(=익명)클래스
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button6) {
					if (point == 0) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point > 0) {
						point--;
						minute += 1;
						second += 20;
						time += 80;
						if (second >= 60) {
							second -= 60;
							minute++;
						}
						pointLabel.setText("포인트: " + point);
					} else {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
					}
				}
			}
		}); // end of anonymous class

		resetBtn.addActionListener(new ActionListener() { // resetBtn의 무명(=익명)클래스
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == resetBtn) {
					if (point == 0) {
						JOptionPane.showMessageDialog(null, shortagePoint_message);
						return;
					} else if (point > 0) {
						point--;
						inputCount = 0;
						inputCountLabel.setText("등록횟수 : " + inputCount);
						pointLabel.setText("포인트: " + point);
					}
				}

			}
		});

		button5.addActionListener(new ActionListener() { // button5의 무명(=익명)클래스
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button5) {
					if (randomValue == 1) {
						if (tField.getText().equals(test.test[0][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));

						}
					} else if (randomValue == 2) {
						if (tField.getText().equals(test.test[1][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					} else if (randomValue == 3) {
						if (tField.getText().equals(test.test[2][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();

						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					} else if (randomValue == 4) {
						if (tField.getText().equals(test.test[3][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							inputCount = 0;
							test_change();
						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					} else if (randomValue == 5) {
						if (tField.getText().equals(test.test[4][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					} else if (randomValue == 6) {
						if (tField.getText().equals(test.test[5][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					} else if (randomValue == 7) {
						if (tField.getText().equals(test.test[6][1])) {
							second = 0;
							pointLabel.setText("포인트: " + (++point));
							tField.setText("");
							pointCount++;
							inputCount = 0;
							inputCountLabel.setText("등록횟수 : " + inputCount);
							test_change();
						} else {
							inputCountLabel.setText("등록횟수 : " + (++inputCount));
						}
					}
				}
			}
		});

		add(panel4);
		setVisible(true);

		TimeClass tc = new TimeClass();
		Thread tr = new Thread(tc); // 쓰레드 클레스를 생성자에 넣어준후 start메소드를 이용해 동작
		tr.start();

	} // end of winterGameGui()

	class TimeClass implements Runnable { // 쓰레드 사용 클래스(innerClass)
		public void run() {
			for (; time >= 0; time--) { // 600초 부터 0초가 될때 까지 반복
				second--; // time변수가 1씩 감소될때마다 second변수값도 1감소
				if (second == -1) { // second변수값이 0보다 작아지면 minute(=분) -1
					second = 59; // 다시 59초로 설정
					minute--; // 1분감소
				}
				if (pointCount >= 7) {// 7문제를 풀었을시 게임클리어
					minute = 0;
					second = 0;
					setVisible(false);

				}
				if (inputCount == 3) {// 3회 이상 오답시 게임종료
					minute = 0;
					second = 0;
					time = 0;

				}

				if (minute < 10) { // 단순히 십의자리에 0을 추가하기위한 수행
					space_1 = "0";
				} else if (minute > 10) { // 분이 10 초과일때 십의자리 공백으로 채움
					space_1 = "";
				}

				if (second < 10) { // 단순히 십의자리에 0을 추가하기위한 수행
					space_2 = "0";
				} else if (second > 10) { // 초가 10 초과일때 십의자리 공백으로 채움
					space_2 = "";
				}

				timeLabel.setText(
						"남은시간: " + space_1 + Integer.toString(minute) + ":" + space_2 + Integer.toString(second) + "초");
				if (time == 0) {
					point = 0;
					button5.setEnabled(false); // time 0초가 되었을 때 '입력'버튼 비활성화
					button6.setEnabled(false); // time 0초가 되었을 때 '연장'버튼 비활성화
					new TimeOut(); // 스레드가 0초가 되면 TimeOut 생성자 출력
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.err.println(e.toString());
				}

			}
		}// end of run()

	}// end of TimeClass Class

	////콤보박스 액션리스너////
	public void actionPerformed(ActionEvent e) {
		JComboBox cd = (JComboBox) e.getSource();
		String name = (String) cd.getSelectedItem();
		changePicture(name);

	}

	@Override
	public void mousePressed(MouseEvent e) { // 마우스 클릭시 버튼 효과음 발생
		JButton btn = (JButton) e.getSource();
		String indexTemp = umrFriends[umrList.getSelectedIndex()]; 
		// 콤보박스에서 선택되어있는 첨자값을 umrFrineds에 적용시켜 현재 선택되어있는 캐릭터를 지정하는데 이 값을 같고 밑에서 비교하게 된다.
		
		if (point >= 3) {
			try {
				if (indexTemp == "우마루.png") { // 현재 선택되어 있는 캐릭터가 우마루.png 일때
					System.out.println("[우마루 선택]");
					FileInputStream fileInputStream = new FileInputStream("우마루.mp3"); // File 변수에 mp3파일 삽입
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "실핀.png") { // 현재 선택되어 있는 캐릭터가 실핀.png 일때
					System.out.println("[실핀 선택]");
					FileInputStream fileInputStream = new FileInputStream("실핀.mp3"); // File 변수에 mp3파일 삽입
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "에비나.png") { // 현재 선택되어 있는 캐릭터가 에비나.png 일때 
					System.out.println("[에비나 선택]");
					FileInputStream fileInputStream = new FileInputStream("에비나.mp3"); // File 변수에 mp3파일 삽입
					Player player = new Player(fileInputStream);
					player.play();
				} else if (indexTemp == "키리에.png") { // 현재 선택되어 있는 캐릭터가 키리에.png 일때
					System.out.println("[키리에 선택]");
					FileInputStream fileInputStream = new FileInputStream("키리에.mp3"); // File 변수에 mp3파일 삽입
					Player player = new Player(fileInputStream);
					player.play();
				}
			} catch (FileNotFoundException s) {
				s.printStackTrace();

			} catch (JavaLayerException s) {
				s.printStackTrace();
			}
		}

	}// end of MousePressed()

}// end of winterGameGui Class