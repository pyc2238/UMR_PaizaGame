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

	//// ��Ʈ ��ü ////
	protected Font f1 = new Font("����", Font.BOLD, 1); // StartMenu Class button ��Ʈ ��ü
	protected Font f2 = new Font("����", Font.BOLD, 25); // GameBoard Class timeLabel ��Ʈ ��ü
	protected Font f3 = new Font("����ü", Font.BOLD, 19);// Explain label��Ʈ ��ü
	protected Font f4 = new Font("����ü", Font.BOLD, 18);// inputCountLabel��Ʈ ��ü
	protected Font f5 = new Font("����ü", Font.BOLD, 15);// inputCountLabel��Ʈ ��ü

	//// TestCollection/////
	TestCollection test = new TestCollection(); // new�����ڷ� GameCommandCenter�� TestCollection�� ��ü ����

	////////// StartMenu////////////
	protected JPanel panel1; // ��ŸƮ �г�
	protected JPanel panel2; // Ÿ��Ʋ �г�
	protected JLabel label1; // Ÿ��Ʋ ���̺�
	protected JButton button1; // ���� ��ư
	protected JButton button2; // ���� ��ư
	protected JButton button3; // ���� ��ư

	protected ImageIcon normal_1 = new ImageIcon("img/����1.png");
	protected ImageIcon roll_1 = new ImageIcon("img/����2.png");
	protected ImageIcon normal_2 = new ImageIcon("img/����1.png");
	protected ImageIcon roll_2 = new ImageIcon("img/����2.png");
	protected ImageIcon normal_3 = new ImageIcon("img/����1.png");
	protected ImageIcon roll_3 = new ImageIcon("img/����2.png");

	////////// Explain////////////
	protected JPanel panel3, imagePanel; // ���� �г�
	protected JButton button4; // '�ݱ�'��ư
	protected JLabel label2, label3, label4; // ���� ���� ����	
	
	////////// GameBoard////////////
	protected String clear_message = "[��� ������ Ǫ�̽��ϴ�!]";
	protected String shortagePoint_message = "[����Ʈ�� �����մϴ�!]\n" + "������ ���߼ż� ����Ʈ�� ȹ���ϼ���";
	protected String space_1 = "";
	protected String space_2 = "";

	protected int randomValue; // ������ ������ ���������� ����
	protected int point = 0; // �ʱ� ����Ʈ�� 0��
	protected int minute = 10; // ���� ��Ÿ���� ����
	protected int second = 0; // �ʸ� ��Ÿ���� ����
	protected int time = 599; // �ʱ� Thread ���� �ð� 600��(=6��)
	protected int pointCount = 0; // ����Ʈ ī���Ͱ� '7'�Ͻ� ���� Ŭ����
	protected int inputCount = 0; // �����Է� Ƚ�� ����(3ȸ)
	
	protected boolean test_1_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_2_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_3_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_4_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_5_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_6_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����
	protected boolean test_7_out = false; // ������ �ߺ��� ���� �� �������� �䱸�Ǵ� ����

	protected JPanel panel4; // ��ü �г�,ī��Ʈ�ٿ� �г�,�����Է¸޴��г�
	protected JPanel countPanel; // ī��Ʈ�ٿ� �ð��ʰ� ���Ե� �г�
	protected JPanel inputPanel; // �����Է� �޴� �г�
	protected JButton button5;// '���' ��ư
	protected JButton button6; // '����' ��ư
	protected JButton resetBtn; // '�ʱ�ȭ' ��ư
	protected JButton spBtn; // ����� ��ư
	protected JLabel timeLabel; // ���� �ð��� ��Ÿ���� label
	protected JLabel pointLabel;//���� ����Ʈ�� ��Ÿ���� label
	protected JLabel inputCountLabel; // ��� Ƚ�� ǥ��
	protected JTextArea tArea; // �ҽ��ڵ� ���� ��� �ʵ�
	protected JTextField tField; // ���� �Է� �ʵ�
	protected JScrollPane scroll; // ��ũ�� ��ü
	
	//// �޺��ڽ�////
	protected JPanel comboPanel;
	protected JLabel comboLabel;
	protected JComboBox umrList;
	protected ImageIcon icon;
	protected String[] umrFriends = { "�츶��.png", "����.png", "����.png", "Ű����.png" };
	
	////////// TimeOut////////////
	protected JPanel panel5;
	protected JLabel choLabel; // �絵�� ���� ����
	protected JButton button7, button8; // �����,���� ��ư

	//// ���� ���� �޼ҵ�////

	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon("img\\" + name);
		comboLabel.setIcon(icon);
		if (icon != null) {
			comboLabel.setText(null);
		} else {
			comboLabel.setText("�̹����� �߰ߵ��� �ʾҽ��ϴ�");
		}

	}

	protected void test_change() {

		randomValue = (int) (Math.random() * 7 + 1); // ������ �������� ���������� ��ȣ�� ����

		if (test_1_out == true && test_2_out == true && test_3_out == true && test_4_out == true && test_5_out == true
				&& test_6_out == true && test_7_out == true) {
			JOptionPane.showMessageDialog(null, clear_message);

			new StartMenu();// ������ ��� Ǯ������ �ٽ� �޴� ����â���� �̵�
			return; // ������ ��� Ǯ�����ÿ� �ش�Ǵ� ���ǹ��̹Ƿ� �� �޼ҵ� ����
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
	
	
	//// ���� ���� �̺�Ʈ////
	public void actionPerformed(ActionEvent e) { // Actio6nListenerŬ������ �߻�޼ҵ�
	
	}// end of actionPerformed()

	@Override // ���콺�� ��ư ������ ������ �Ͼ������ �ٲ�
	public void mouseEntered(MouseEvent e) {

	}

	@Override // ���콺�� ��ư ������ ������ ���������� �ٲ�
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { // ���콺 Ŭ���� ��ư ȿ���� �߻�
		JButton btn = (JButton) e.getSource();
		try {
			FileInputStream fileInputStream = new FileInputStream("��ư��.mp3"); // File ������ mp3���� ����
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
