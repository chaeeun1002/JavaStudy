package exam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//GridLayout(8,1), panel(8)
//label(5), textfield(3), button(4), textarea(1)-->상품설명, radioButton(2)-->원산지, checkboxgroup(1)

public class ItemSystem extends Panel implements ActionListener{
	
	Panel[] panel;
	Label[] label;
	Button[] btn;
	TextField[] text;
	TextArea textarea;
	Checkbox[] madeIn;
	CheckboxGroup group;

	String[] titles = {"상품번호","상품이름","상품가격","상품설명","상품원산지"};
	String[] btn_name = {"삽 입","삭 제","변 경", "조 회","지우기"};
	
	Font font;
	
	TotalSystem total;

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj == btn[0]) {//삽입버튼을 누른 경우
			
			String code = text[0].getText();
			
			CRUDprocess crud = new CRUDprocess();
			ItemInfo item = crud.SelectItemCode(code);
			
			if(code.equals("")) {//상품코드가 null값일 경우
				JOptionPane.showMessageDialog(total, "상품번호는 반드시 입력해야 합니다.");
			}else if(item != null) {//중복된 상품코드를 입력 했을 경우
				JOptionPane.showMessageDialog(total, "이미 등록되어 있는 상품번호입니다.");
			}else {
				//YES or NO 옵션 다이얼로그 생성
				String[] str = {"등 록","취 소"};
				int select = JOptionPane.showOptionDialog(total, "등록하시겠습니까?", "등 록", JOptionPane.YES_NO_OPTION, 
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
				
				if(select == JOptionPane.YES_OPTION) {
					String name = text[1].getText();//상품이름
					String price = text[2].getText();//상품가격
					String info = textarea.getText();//상품설명
					String origin = "";//상품원산지
					if(madeIn[0].getState()) {
						origin = "korea";
					}else if(madeIn[1].getState()) {
						origin = "other country";
					}
					String image = SaveActionListener.path;
					
					ItemInfo iteminfo = new ItemInfo();//모델 객체 생성
					iteminfo.setCode(code);
					iteminfo.setName(name);
					iteminfo.setPrice(Integer.parseInt(price));
					iteminfo.setInfo(info);
					iteminfo.setOrigin(origin);
					iteminfo.setImage(image);
					
					int result = crud.insertIntoItemInfo(iteminfo);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(total, "물품 등록이 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(total, "물품 등록과정에서 오류가 발생하였습니다.");
					}
				}//YES_OPTION if문의 끝
			}
			
		}else if(obj == btn[1]) {//삭제버튼
			String[] str = {"삭 제","취 소"};
			int select = JOptionPane.showOptionDialog(total, "삭제하시겠습니까?", "삭 제", JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			//Yes와 No 버튼이 있는 다이얼로그 생성
			if(select == JOptionPane.YES_OPTION) {
				String code = text[0].getText();
				if(code.equals("")) {
					JOptionPane.showMessageDialog(total, "상품번호를 입력해주세요");
				}else {
					//DB에서 해당상품번호를 삭제
					CRUDprocess crud = new CRUDprocess();
					int result = crud.deleteItemByCode(code);
					if(result > 0) {
						JOptionPane.showMessageDialog(total, "물품 삭제가 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(total, "물품 삭제과정에서 오류가 발생하였습니다.");
					}
				}
			}else if(select == JOptionPane.NO_OPTION) {
				System.out.println("삭제 취소");
			}
		}else if(obj == btn[2]) {//변경버튼
			String[] str = {"변 경","취 소"};
			int select = JOptionPane.showOptionDialog(total, "변경하시겠습니까?", "변 경", JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			//Yes와 No 버튼이 있는 다이얼로그 생성
			if(select == JOptionPane.YES_OPTION) {
				String code = text[0].getText();
				if(code.equals("")) {
					JOptionPane.showMessageDialog(total, "상품번호를 입력해주세요");
				}else {
					//DB에서 해당상품번호의 정보를 변경
					CRUDprocess crud = new CRUDprocess();
					ItemInfo item = new ItemInfo();
					String name = text[1].getText();
					String price = text[2].getText();
					String info = textarea.getText();
					String origin = "";
					if(madeIn[0].getState() == true) {
						origin = "korea";
					}else if(madeIn[1].getState() == true) {
						origin = "other country";
					}
					item.setCode(code);
					item.setName(name);
					item.setPrice(Integer.parseInt(price));
					item.setInfo(info);
					item.setOrigin(origin);
					int result = crud.updateItemByCode(item);
					if(result > 0) {
						JOptionPane.showMessageDialog(total, "물품 변경이 정상적으로 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(total, "물품 변경과정에서 오류가 발생하였습니다.");
					}
				}
			}else if(select == JOptionPane.NO_OPTION) {
				
			}
		}else if(obj == btn[3]) {//조회버튼
			String code = text[0].getText();
			CRUDprocess crud = new CRUDprocess();
			ItemInfo info = crud.SelectItemCode(code);
			if(info == null) {
				JOptionPane.showMessageDialog(total, "입력하신 상품번호는 존재하지 않습니다.");
			}else {
				//DB의 검색정보를 윈도우 컴포넌트에 출력한다.
				text[0].setText(info.getCode());
				text[1].setText(info.getName());
				text[2].setText(String.valueOf(info.getPrice()));
				textarea.setText(info.getInfo());
				if(info.getOrigin().equals("korea")) {
					madeIn[0].setState(true);
				}else if(info.getOrigin().equals("other country")) {
					madeIn[1].setState(true);
				}
			}
		}else if(obj == btn[4]) {//지우기버튼
			for(int i = 0; i < text.length; i++) {
				text[i].setText(" ");
				text[i].setText("");
			}
			textarea.setText(" ");
			textarea.setText("");
			madeIn[0].setState(true);
		}
	}

	void makeRadioButton() {
		group = new CheckboxGroup();
		madeIn = new Checkbox[2];
		madeIn[0] = new Checkbox("한국산",group,true);
		madeIn[0].setFont(font);
		madeIn[1] = new Checkbox("외국산",group,false);
		madeIn[1].setFont(font);
	}
	
	void makeLabel() {
		label = new Label[5];
		for(int i = 0; i < label.length; i++) {
			label[i] = new Label(titles[i]);
			label[i].setFont(font);
		}
	}
	
	void makeTextField() {
		text = new TextField[3];
		for(int i = 0; i < text.length; i++) {
			text[i] = new TextField(15);
			text[i].setFont(font);
		}
	}
	
	void makeButton() {
		btn = new Button[5];
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new Button(btn_name[i]);
			btn[i].setFont(font);
			btn[i].setBackground(new Color(119,136,153));
			btn[i].addActionListener(this);
		}
	}
	
	void makePanel() {
		panel = new Panel[8];
		for(int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();
		}
	}
	
	Panel centerPanel;//상품 정보
	ImageSystem imageSystem;//상품 이미지
	
	public ItemSystem(TotalSystem total) {
//		super(title);

		this.total = total;
		
//		this.setLayout(new GridLayout(8,1));
		this.setLayout(new BorderLayout());
		
		makeRadioButton();
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		
		textarea = new TextArea(2,15);//2행 15열로 텍스트에리어 생성
		
		panel[0].add(new Label());
		panel[1].add(label[0]);panel[1].add(text[0]);
		panel[2].add(label[1]);panel[2].add(text[1]);
		panel[3].add(label[2]);panel[3].add(text[2]);
		panel[4].add(label[3]);panel[4].add(textarea);
		panel[5].add(label[4]);panel[5].add(madeIn[0]);panel[5].add(madeIn[1]);
		panel[6].add(btn[0]);panel[6].add(btn[1]);panel[6].add(btn[2]);panel[6].add(btn[3]);panel[6].add(btn[4]);
		panel[7].add(new Label());
		
		centerPanel = new Panel();
		centerPanel.setLayout(new GridLayout(7,1));
		
		centerPanel.add(panel[0]);
		centerPanel.add(panel[1]);
		centerPanel.add(panel[2]);
		centerPanel.add(panel[3]);
		centerPanel.add(panel[4]);
		centerPanel.add(panel[5]);
		centerPanel.add(panel[7]);
		
		imageSystem = new ImageSystem(total);
		
		font = new Font("굴림체",Font.BOLD, 20);

		this.add("Center",centerPanel);
		this.add("East",imageSystem);
		this.add("South",panel[6]);
		
//		this.addWindowListener(new LoginSystemExit());
		
		this.setBackground(new Color(176,196,222));
		
//		this.setSize(400,500);
//		this.setVisible(true);

	}
	
//	public static void main(String[] args) {
//		new ItemSystem("물품 관리 시스템");
//	}

}
