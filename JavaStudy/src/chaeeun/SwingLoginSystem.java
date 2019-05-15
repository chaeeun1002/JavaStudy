package chaeeun;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

class MyLoginEvent implements ActionListener{
	SwingLoginSystem login;
	SwingWindow02 total;
	
	MyLoginEvent(SwingLoginSystem login, SwingWindow02 total){
		this.login = login;
		this.total = total;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == login.login || obj == login.pw_txt) {
			String id = login.id_txt.getText();
			String pwd = login.pw_txt.getText();
			
			UserIdPwd idPwd = new UserIdPwd();
			idPwd.setId(id);
			idPwd.setPwd(pwd);
			
			CRUDprocess crud = new CRUDprocess();
			ManagerInfo info = crud.selectIdAndPwd(idPwd);
			
			if(info == null) {
				JOptionPane.showMessageDialog(total, "ID와 암호를 확인하세요.");
			}else {
				JOptionPane.showMessageDialog(total, "로그인되었습니다.");
//				total.card.show(total.total_panel, "background");
				
				login.id_txt.setText(" ");
				login.id_txt.setText("");
				
				login.pw_txt.setText(" ");
				login.pw_txt.setText("");
				
				total.logout.setEnabled(true);
				total.fruit.setEnabled(true);
				total.drink.setEnabled(true);
				total.item.setEnabled(true);
				total.home.setEnabled(true);
				total.emp.setEnabled(true);
				total.sales.setEnabled(true);
				total.image.setEnabled(true);
			}
		}
	}
	
}

public class SwingLoginSystem extends JPanel{

	JButton login,cancel;
	JLabel id_lbl,pw_lbl;
	JTextField id_txt;
	JPasswordField pw_txt;
	
	JPanel[] panels;
	
	Font font;
	
	SwingWindow02 total;
	
	Border blackline, raisedetched, loweredetched, raisedbevel, loweredbevel, empty;
	
	void makeJPanels() {
		panels = new JPanel[7];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel(new FlowLayout());
			panels[i].setBackground(new Color(255,193,158));
		}
	}
	
	public SwingLoginSystem(SwingWindow02 total) {
//		super(str);
		this.setLayout(new GridLayout(7,1));
		
		makeJPanels();
		
		font = new Font("굴림체",Font.BOLD,20);
		
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder();
		
		//버튼생성
		login = new JButton("로그인");
		login.setFont(font);
		login.addActionListener(new MyLoginEvent(this,total));
		cancel = new JButton("다시입력");
		cancel.setFont(font);
		cancel.addActionListener(new MyLoginEvent(this,total));
		
		//레이블생성
		id_lbl = new JLabel("아이디",JLabel.CENTER);//가운데 정렬
		id_lbl.setFont(font);
		pw_lbl = new JLabel("패스워드",JLabel.CENTER);
		pw_lbl.setFont(font);
		
		//텍스트필드생성
		id_txt = new JTextField(20);
		id_txt.setFont(font);
		
		//패스워드필드생성
		pw_txt = new JPasswordField(20);
		pw_txt.setFont(font);
		pw_txt.setEchoChar('*');
		
		//패널에 컴포넌트 붙이기
		panels[0].add(new JLabel());
		panels[0].setBorder(blackline);
		
		panels[1].add(id_lbl);panels[1].add(id_txt);
		panels[1].setBorder(raisedetched);
		
		panels[2].add(new JLabel());
		panels[2].setBorder(loweredetched);
		
		panels[3].add(pw_lbl);panels[3].add(pw_txt);
		panels[3].setBorder(raisedbevel);
		
		panels[4].add(new JLabel());
		panels[4].setBorder(loweredbevel);
		
		panels[5].add(login);panels[5].add(cancel);
		panels[5].setBorder(empty);
		
		panels[6].add(new JLabel());
		
		//LoginSystem에 패널 붙이기
		for(int i = 0; i < 7; i++) {
			this.add(panels[i]);
		}
		
		this.setBounds(200,200,800,500);//200,200위치에 가로 800, 세로 500 크기의 위도우 출력
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new SwingLoginSystem("로그인 화면");
//	}

}
