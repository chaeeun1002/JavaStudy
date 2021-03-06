package org.chaeeun.may14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class ItemModel2 extends AbstractTableModel{

	private Object[][] tableData;//DB조회 결과가 저장될 배열
	private int cols,rows;//열의 갯수와 행의 갯수가 저장될 변수
	private String[] columnName = {"상품번호","상품이름","상품가격","상품정보","상품원산지","상품이미지경로"};//열의 제목
	private List<ItemInfo> list;
	
	ItemModel2(CRUDprocess crud, Map map){
		list = crud.SelectItemInfoCondition(map);
		cols = columnName.length;
		rows = list.size();
		setData();
	}
	
	private void setData() {//조회 결과를 이차원 배열에 저장(이차원 배열에 저장? --> 테이블이 행과 열로 구성되어 있기 때문에)
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		Iterator it = list.iterator();
		int r = 0;
		while(it.hasNext()) {
			ItemInfo info = (ItemInfo)it.next();
			tableData[r][0] = info.getCode();
			tableData[r][1] = info.getName();
			tableData[r][2] = info.getPrice();
			tableData[r][3] = info.getInfo();
			tableData[r][4] = info.getOrigin();
			tableData[r][5] = info.getImage();
			r++;
		}
	}
	
	public int getRowCount() {
		return rows;
	}

	public int getColumnCount() {
		return cols;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}
	
}

//GridLayout(8,1), panel(8)
//label(5), textfield(3), button(4), textarea(1)-->상품설명, radioButton(2)-->원산지, checkboxgroup(1)

public class ItemSystem extends JPanel implements ActionListener{
	
	JPanel[] panel;
	JLabel[] label;
	JButton[] btn;
	JTextField[] text;
	JTextArea textarea;
	JRadioButton[] madeIn;
	ButtonGroup group;

	String[] titles = {"상품번호","상품이름","상품가격","상품설명","상품원산지"};
	String[] btn_name = {"삽 입","삭 제","변 경", "조 회","지우기"};
	
	Font font;

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
//
//		if(obj == btn[0]) {//삽입버튼을 누른 경우
//			
//			String code = text[0].getText();
//			
//			CRUDprocess crud = new CRUDprocess();
//			ItemInfo item = crud.SelectItemCode(code);
//			
//			if(code.equals("")) {//상품코드가 null값일 경우
//				JOptionPane.showMessageDialog(total, "상품번호는 반드시 입력해야 합니다.");
//			}else if(item != null) {//중복된 상품코드를 입력 했을 경우
//				JOptionPane.showMessageDialog(total, "이미 등록되어 있는 상품번호입니다.");
//			}else {
//				//YES or NO 옵션 다이얼로그 생성
//				String[] str = {"등 록","취 소"};
//				int select = JOptionPane.showOptionDialog(total, "등록하시겠습니까?", "등 록", JOptionPane.YES_NO_OPTION, 
//						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
//				
//				if(select == JOptionPane.YES_OPTION) {
//					String name = text[1].getText();//상품이름
//					String price = text[2].getText();//상품가격
//					String info = textarea.getText();//상품설명
//					String origin = "";//상품원산지
//					if(madeIn[0].getState()) {
//						origin = "korea";
//					}else if(madeIn[1].getState()) {
//						origin = "other country";
//					}
//					String image = SaveActionListener.path;
//					
//					ItemInfo iteminfo = new ItemInfo();//모델 객체 생성
//					iteminfo.setCode(code);
//					iteminfo.setName(name);
//					iteminfo.setPrice(Integer.parseInt(price));
//					iteminfo.setInfo(info);
//					iteminfo.setOrigin(origin);
//					iteminfo.setImage(image);
//					
//					int result = crud.insertIntoItemInfo(iteminfo);
//					
//					if(result > 0) {
//						JOptionPane.showMessageDialog(total, "물품 등록이 정상적으로 완료되었습니다.");
//					}else {
//						JOptionPane.showMessageDialog(total, "물품 등록과정에서 오류가 발생하였습니다.");
//					}
//				}//YES_OPTION if문의 끝
//			}
//			
//		}
		if(obj == btn[1]) {//삭제버튼
			String[] str = {"삭 제","취 소"};
			int select = JOptionPane.showOptionDialog(iij, "삭제하시겠습니까?", "삭 제", JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			//Yes와 No 버튼이 있는 다이얼로그 생성
			if(select == JOptionPane.YES_OPTION) {
				HashMap<String,Object> map = new HashMap<String,Object>();
				if(!text[0].getText().equals("")) {
					map.put("code", text[0].getText());
				}
				if(!text[1].getText().equals("")) {
					map.put("name", text[1].getText());
				}
				if(!text[2].getText().equals("")) {
					map.put("price", text[2].getText());
				}
				if(madeIn[0].isSelected()) {
					map.put("origin", "korea");
				}else if(madeIn[1].isSelected()) {
					map.put("origin", "other country");
				}
				CRUDprocess crud = new CRUDprocess();
				int result = crud.DeleteItemInfoCondition(map);
				if(result > 0) {
					JOptionPane.showMessageDialog(iij, "삭제가 정상적으로 되었습니다.");
				}else {
					JOptionPane.showMessageDialog(iij, "삭제과정에서 문제가 발생했습니다.");
				}
			}
		}
			
//		}else if(obj == btn[2]) {//변경버튼
//			String[] str = {"변 경","취 소"};
//			int select = JOptionPane.showOptionDialog(total, "변경하시겠습니까?", "변 경", JOptionPane.YES_NO_OPTION, 
//					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
//			//Yes와 No 버튼이 있는 다이얼로그 생성
//			if(select == JOptionPane.YES_OPTION) {
//				String code = text[0].getText();
//				if(code.equals("")) {
//					JOptionPane.showMessageDialog(total, "상품번호를 입력해주세요");
//				}else {
//					//DB에서 해당상품번호의 정보를 변경
//					CRUDprocess crud = new CRUDprocess();
//					ItemInfo item = new ItemInfo();
//					String name = text[1].getText();
//					String price = text[2].getText();
//					String info = textarea.getText();
//					String origin = "";
//					if(madeIn[0].getState() == true) {
//						origin = "korea";
//					}else if(madeIn[1].getState() == true) {
//						origin = "other country";
//					}
//					item.setCode(code);
//					item.setName(name);
//					item.setPrice(Integer.parseInt(price));
//					item.setInfo(info);
//					item.setOrigin(origin);
//					int result = crud.updateItemByCode(item);
//					if(result > 0) {
//						JOptionPane.showMessageDialog(total, "물품 변경이 정상적으로 완료되었습니다.");
//					}else {
//						JOptionPane.showMessageDialog(total, "물품 변경과정에서 오류가 발생하였습니다.");
//					}
//				}
//			}else if(select == JOptionPane.NO_OPTION) {
//				
//			}
//		}
		if(obj == btn[3]) {//조회버튼
			//상품번호, 이름, 가격, 원산지가 입력되었는지 찾는다.
			HashMap<String,Object> map = new HashMap<String,Object>();
			if(!text[0].getText().equals("")) {//상품번호가 입력된 경우
				map.put("code", text[0].getText());
			}
			if(!text[1].getText().equals("")) {//상품이름이 입력된 경우
				map.put("name", text[1].getText());
			}
			if(!text[2].getText().equals("")) {//상품가격이 입력된 경우
				map.put("price", text[2].getText());
			}
			if(madeIn[0].isSelected()) {//한국산을 선택한 경우
				map.put("origin", "korea");
			}else if(madeIn[1].isSelected()) {//외국산을 선택한 경우
				map.put("origin", "other country");
			}
			CRUDprocess crud = new CRUDprocess();
			ItemModel2 itemModel = new ItemModel2(crud,map);
			iij.table.setModel(itemModel);
		}
		if(obj == btn[4]) {//지우기버튼
			for(int i = 0; i < text.length; i++) {
				text[i].setText(" ");
				text[i].setText("");
			}
			textarea.setText(" ");
			textarea.setText("");
			madeIn[0].setSelected(true);
			btn[0].setEnabled(true);
		}
	}

	void makeRadioButton() {
		group = new ButtonGroup();
		madeIn = new JRadioButton[2];
		madeIn[0] = new JRadioButton("한국산",true);
		madeIn[0].setFont(font);
		madeIn[1] = new JRadioButton("외국산",false);
		madeIn[1].setFont(font);
		group.add(madeIn[0]);group.add(madeIn[1]);
	}
	
	void makeLabel() {
		label = new JLabel[5];
		for(int i = 0; i < label.length; i++) {
			label[i] = new JLabel(titles[i]);
			label[i].setFont(font);
		}
	}
	
	void makeTextField() {
		text = new JTextField[3];
		for(int i = 0; i < text.length; i++) {
			text[i] = new JTextField(15);
			text[i].setFont(font);
		}
	}
	
	void makeButton() {
		btn = new JButton[5];
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btn_name[i]);
			btn[i].setFont(font);
			btn[i].setBackground(new Color(119,136,153));
			btn[i].addActionListener(this);
		}
	}
	
	void makePanel() {
		panel = new JPanel[8];
		for(int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
	}
	
	JPanel centerPanel;//상품 정보
	
	ItemInfoJTable iij;
	
	public ItemSystem(ItemInfoJTable iij) {
//		super(title);

//		this.total = total;
		
//		this.setLayout(new GridLayout(8,1));
		
		this.iij = iij;
		
		this.setLayout(new BorderLayout());
		
		makeRadioButton();
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		
		textarea = new JTextArea(2,15);//2행 15열로 텍스트에리어 생성
		
		panel[0].add(new JLabel());
		panel[1].add(label[0]);panel[1].add(text[0]);
		panel[2].add(label[1]);panel[2].add(text[1]);
		panel[3].add(label[2]);panel[3].add(text[2]);
		panel[4].add(label[3]);panel[4].add(textarea);
		panel[5].add(label[4]);panel[5].add(madeIn[0]);panel[5].add(madeIn[1]);
		panel[6].add(btn[0]);panel[6].add(btn[1]);panel[6].add(btn[2]);panel[6].add(btn[3]);panel[6].add(btn[4]);
		panel[7].add(new JLabel());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(7,1));
		
		centerPanel.add(panel[0]);
		centerPanel.add(panel[1]);
		centerPanel.add(panel[2]);
		centerPanel.add(panel[3]);
		centerPanel.add(panel[4]);
		centerPanel.add(panel[5]);
		centerPanel.add(panel[7]);
		
		font = new Font("굴림체",Font.BOLD, 20);

		this.add("Center",centerPanel);
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
