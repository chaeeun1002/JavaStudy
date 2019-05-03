package exam;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CustomerSystem extends Frame implements ActionListener{
	
	Label[] labels;
	TextField[] texts;
	Button[] btns;
	Panel[] panels;
	
	String[] titles = {"ID","이름","주소","가입일"};
	
	String[] btn_titles = {"달력","삽입","삭제","변경","조회","지우기"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btns[0]) {//달력
			
		}else if(obj == btns[1]) {//삽입
			String id = texts[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.SelectCusId(id);
			
			if(info != null) {
				JOptionPane.showConfirmDialog(this, "이미 등록되어 있는 ID입니다.");
			}else if(id.equals("")){
				JOptionPane.showConfirmDialog(this, "고객 ID는 필수입력 사항입니다.");
			}
			
			else {
				String[] str = {"가 입","취 소"};
					int select = JOptionPane.showOptionDialog(this, "가입하시겠습니까?", "가 입", JOptionPane.YES_NO_OPTION, 
							JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
					if(select == JOptionPane.YES_OPTION) {
						
						String name = texts[1].getText();
						String addr = texts[2].getText();
						String join_date = texts[3].getText();
						
						Customer_info cus_info = new Customer_info();
						
						cus_info.setId(id);
						cus_info.setName(name);
						cus_info.setAddr(addr);
						cus_info.setJoin_date(join_date);
						int result = crud.insertIntoCusInfo(cus_info);
						if(result > 0) {
							JOptionPane.showMessageDialog(this, "정상적으로 가입되었습니다.");
						}else {
							JOptionPane.showMessageDialog(this, "가입 중 문제가 발생하였습니다.");
						}
					}
			}	
		}else if(obj == btns[2]) {//삭제
			String id = texts[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.SelectCusId(id);
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "고객 ID는 필수입력 사항입니다.");
			}else if(info == null) {
				JOptionPane.showMessageDialog(this, "입력하신 ID의 고객정보가 존재하지 않습니다.");
			}else {
				String[] str = {"삭 제","취 소"};
				int select = JOptionPane.showOptionDialog(this, "삭제하시겠습니까?", "삭 제", JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
				if(select == JOptionPane.YES_OPTION) {
					int result = crud.deleteCusInfo(id);
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "정상적으로 삭제되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, "삭제 중 문제가 발생하였습니다.");
					}
				}	
			}
		}else if(obj == btns[3]) {//변경
			String id = texts[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.SelectCusId(id);
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "고객 ID는 필수입력 사항입니다.");
			}else if(info == null) {
				JOptionPane.showMessageDialog(this, "입력하신 ID의 고객정보가 존재하지 않습니다.");
			}else {
				String[] str = {"변 경","취 소"};
				int select = JOptionPane.showOptionDialog(this, "변경하시겠습니까?", "변 경", JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
				if(select == JOptionPane.YES_OPTION) {
					String name = texts[1].getText();
					String addr = texts[2].getText();
					String join_date = texts[3].getText();
					Customer_info cus_info = new Customer_info();
					cus_info.setId(id);
					cus_info.setName(name);
					cus_info.setAddr(addr);
					cus_info.setJoin_date(join_date);
					int result = crud.updateCusInfo(cus_info);
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "정상적으로 변경되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, "변경 중 문제가 발생하였습니다.");
					}
				}
			}
			
		}else if(obj == btns[4]) {//조회
			String id = texts[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.SelectCusId(id);
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "고객 ID는 필수입력 사항입니다.");
			}else if(info == null) {
				JOptionPane.showMessageDialog(this, "입력하신 ID의 고객정보가 존재하지 않습니다.");
			}else {
				texts[1].setText(info.getName());
				texts[2].setText(info.getAddr());
				texts[3].setText(info.getJoin_date());
			}
		}else if(obj == btns[5]) {//지우기
			texts[0].setText(" ");
			texts[0].setText("");
			texts[1].setText(" ");
			texts[1].setText("");
			texts[2].setText(" ");
			texts[2].setText("");
			texts[3].setText(" ");
			texts[3].setText("");
		}
	}

	void makeLabels() {
		labels = new Label[4];
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new Label(titles[i]);
		}
	}
	
	void makeTextFields() {
		texts = new TextField[4];
		for(int i = 0; i < texts.length; i++) {
			texts[i] = new TextField(20);
		}
	}
	
	void makeButtons() {
		btns = new Button[6];
		for(int i = 0; i < btns.length; i++) {
			btns[i] = new Button(btn_titles[i]);
			btns[i].addActionListener(this);
		}
	}
	
	void makePanels() {
		panels = new Panel[7];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new Panel(new FlowLayout());
		}
		panels[0].add(new Label());
		panels[1].add(labels[0]); panels[1].add(texts[0]);
		panels[2].add(labels[1]); panels[2].add(texts[1]);
		panels[3].add(labels[2]); panels[3].add(texts[2]);
		panels[4].add(labels[3]); panels[4].add(texts[3]); panels[4].add(btns[0]);
		panels[5].add(btns[1]); panels[5].add(btns[2]); panels[5].add(btns[3]); 
		panels[5].add(btns[4]); panels[5].add(btns[5]);
		panels[6].add(new Label());
	}
	
	public CustomerSystem(String str) {
		super(str);
		this.setLayout(new GridLayout(7,1));
		
		makeLabels();
		makeTextFields();
		makeButtons();
		makePanels();
		
		for(int i = 0; i < panels.length;i++) {
			this.add(panels[i]);
		}
		
		this.addWindowListener(new LoginSystemExit());
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CustomerSystem("고객 관리 시스템");
	}

}
