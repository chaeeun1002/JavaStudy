package exam;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class EmployeeSystem extends Panel implements ItemListener,ActionListener{
	
	Label[] labels;
	TextField[] text;
	Checkbox[] genders;
	CheckboxGroup group;
	Choice[] choices;
	Button[] btns;
	Panel[] panels;
	
	String[] label_title = {"사 번","이 름","부 서","성 별","주 소","입사일"};
	String[] btn_title = {"삽 입","삭 제","변 경","조 회","지우기","달 력"};
	String[] dpt_name = {"영업부","홍보부","개발부","기획부"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btns[0]) {//삽입버튼
			String id = text[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			EmpInfo info = crud.SelectEmpId(id);
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "사원번호는 반드시 입력해야 합니다.");
			}else if(info != null) {
				JOptionPane.showMessageDialog(this, "이미 등록되어 있는 사원번호입니다.");
			}else {
				//YES or NO 옵션 다이얼로그 생성
				String[] str = {"등 록","취 소"};
				int select = JOptionPane.showOptionDialog(this, "등록하시겠습니까?", "등 록", JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
				
				if(select == JOptionPane.YES_OPTION) {
					String name = text[1].getText();
					String dpt = choices[0].getSelectedItem();
					String gender = "";
					if(genders[0].getState()) {
						gender = "남자";
					}else if(genders[1].getState()) {
						gender = "여자";
					}
					String addr = text[2].getText();
					String hire_date = "";
					String year = choices[1].getSelectedItem();
					String month = choices[2].getSelectedItem();
					String date = choices[3].getSelectedItem();
					hire_date = year+"/"+month+"/"+date;
					
					EmpInfo empinfo = new EmpInfo();
					empinfo.setEmp_id(id);
					empinfo.setEmp_name(name);
					empinfo.setEmp_dpt(dpt);
					empinfo.setEmp_gen(gender);
					empinfo.setEmp_addr(addr);
					empinfo.setEmp_date(hire_date);
					
					int result = crud.insertIntoEmpInfo(empinfo);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "사원 등록이 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, "사원 등록과정에서 오류가 발생하였습니다.");
					}
				}
			}
			
		}else if(obj == btns[1]) {//삭제버튼
			String[] str = {"삭 제","취 소"};
			int select = JOptionPane.showOptionDialog(this, "삭제하시겠습니까?", "삭 제", JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			//Yes와 No 버튼이 있는 다이얼로그 생성
			if(select == JOptionPane.YES_OPTION) {
				String id = text[0].getText();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(this, "사원번호를 입력해주세요");
				}else {
					CRUDprocess crud = new CRUDprocess();
					int result = crud.deleteEmpInfo(id);
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "사원 삭제가 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, "사원 삭제과정에서 오류가 발생하였습니다.");
					}
				}
			}
		}else if(obj == btns[2]) {//변경버튼
			String[] str = {"변 경","취 소"};
			int select = JOptionPane.showOptionDialog(this, "변경하시겠습니까?", "변 경", JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			//Yes와 No 버튼이 있는 다이얼로그 생성
			if(select == JOptionPane.YES_OPTION) {
				String id = text[0].getText();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(this, "사원번호를 입력해주세요");
				}else {
					CRUDprocess crud = new CRUDprocess();
					String name = text[1].getText();
					String dpt = choices[0].getSelectedItem();
					String gender = "";
					if(genders[0].getState()) {
						gender = "남자";
					}else if(genders[1].getState()) {
						gender = "여자";
					}
					String addr = text[2].getText();
					String hire_date = "";
					String year = choices[1].getSelectedItem();
					String month = choices[2].getSelectedItem();
					String date = choices[3].getSelectedItem();
					hire_date = year+"/"+month+"/"+date;
					
					EmpInfo empinfo = new EmpInfo();
					empinfo.setEmp_id(id);
					empinfo.setEmp_name(name);
					empinfo.setEmp_dpt(dpt);
					empinfo.setEmp_gen(gender);
					empinfo.setEmp_addr(addr);
					empinfo.setEmp_date(hire_date);
					
					int result = crud.updateEmpInfoById(empinfo);
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "사원정보 변경이 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(this, "사원정보 변경과정에서 오류가 발생하였습니다.");
					}
				}
			}
		}else if(obj == btns[3]) {//조회버튼
			String id = text[0].getText();
			CRUDprocess crud = new CRUDprocess();
			EmpInfo info = crud.SelectEmpId(id);
			if(info == null) {
				JOptionPane.showMessageDialog(this, "입력하신 사원번호는 존재하지 않습니다.");
			}else {
				text[0].setText(info.getEmp_id());
				text[1].setText(info.getEmp_name());
				String dpt = info.getEmp_dpt();
				switch(dpt) {
				case "영업부":
					choices[0].select(0);
					break;
				case "홍보부":
					choices[0].select(1);
					break;
				case "개발부":
					choices[0].select(2);
					break;
				case "기획부":
					choices[0].select(3);
					break;
				}
				if(info.getEmp_gen().equals("남자")) {
					genders[0].setState(true);
				}else if(info.getEmp_gen().equals("여자")) {
					genders[1].setState(true);
				}
				text[2].setText(info.getEmp_addr());
				String hire_date = info.getEmp_date();
				String[] hire = hire_date.split("/");
				choices[1].select(hire[0]);
				choices[2].select(hire[1]);
				choices[3].select(hire[2]);
			}
		}else if(obj == btns[4]) {//지우기버튼
			for(int i = 0; i < text.length; i++) {
				text[i].setText(" ");
				text[i].setText("");
			}
//			for(int i = 0; i < choices.length; i++) {
//				choices[i].getSelectedIndex();
//			}
			genders[0].setState(true);
			genders[1].setState(false);
			choices[1].select(0);
			choices[2].select(0);
			choices[3].select(0);
		}else if(obj == btns[5]) {//달력버튼
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == choices[2]) {
			int month = Integer.parseInt(choices[2].getSelectedItem());
			switch(month) {
			case 4: 
				choices[3].removeAll();
				for(int i = 1; i <= 30; i++) {
					choices[3].add(i+"");
				}
			case 6:
			case 9:
			case 11:break;
			case 2 :
				choices[3].removeAll();
				for(int i = 1; i <= 28; i++) {
					choices[3].add(i+"");
				}
				break;
			default : 
				choices[3].removeAll();
				for(int i = 1; i <= 31; i++) {
					choices[3].add(i+"");
				}
				break;
			}
		}
	}

	void makeLabel() {
		labels = new Label[6];
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new Label(label_title[i]);
		}
	}
	
	void makeButton() {
		btns = new Button[6];
		for(int i = 0; i < btns.length; i++) {
			btns[i] = new Button(btn_title[i]);
			btns[i].addActionListener(this);
		}
	} 
	
	void makeTextField() {
		text = new TextField[3];
		for(int i = 0; i < text.length; i++) {
			text[i] = new TextField(20);
		}
	}
	
	void makeCheckBox() {
		group = new CheckboxGroup();
		genders = new Checkbox[2];
		genders[0] = new Checkbox("남자",group,true);
		genders[1] = new Checkbox("여자",group,false);
	}
	
	void makeChoice() {
		choices = new Choice[4];
		choices[0] = new Choice();
		for(int i = 0; i < dpt_name.length; i++) {
			choices[0].add(dpt_name[i]);
		}
		choices[1] = new Choice();
		for(int i = 2019; i >= 1980; i--) {
			choices[1].add(i+"");
		}
		choices[2] = new Choice();
		for(int i = 1; i <= 12; i++) {
			choices[2].add(i+"");
		}
		choices[2].addItemListener(this);
		choices[3] = new Choice();
		choices[3].add("    ");
	}
	
	void makePanel() {
		panels = new Panel[9];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());
		}
		panels[0].add(new Label());
		panels[1].add(labels[0]);panels[1].add(text[0]);
		panels[2].add(labels[1]);panels[2].add(text[1]);
		panels[3].add(labels[2]);panels[3].add(choices[0]);
		panels[4].add(labels[3]);panels[4].add(genders[0]);panels[4].add(genders[1]);
		panels[5].add(labels[4]);panels[5].add(text[2]);
		panels[6].add(labels[5]);panels[6].add(choices[1]);panels[6].add(choices[2]);panels[6].add(choices[3]);
		for(int i = 0; i < btns.length; i++) {
			panels[7].add(btns[i]);
		}
		panels[8].add(new Label());
	}
	
	public EmployeeSystem() {
//		super(str);
		this.setLayout(new GridLayout(9,1));
		makeLabel();
		makeButton();
		makeTextField();
		makeCheckBox();
		makeChoice();
		makePanel();
		for(int i = 0; i < panels.length; i++) {
			this.add(panels[i]);
		}
//		this.addWindowListener(new LoginSystemExit());
		this.setSize(800, 500);
		this.setVisible(true);
		
	} 
//	public static void main(String[] args) {
//		new EmployeeSystem("사원 정보 시스템");
//	}

}
