package org.chaeeun.may13;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class ItemModel extends AbstractTableModel{

	private Object[][] tableData;//DB조회 결과가 저장될 배열
	private int cols,rows;//열의 갯수와 행의 갯수가 저장될 변수
	private String[] columnName = {"상품번호","상품이름","상품가격","상품정보","상품원산지","상품이미지경로"};//열의 제목
	private List<ItemInfo> list;
	
	ItemModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.SelectItemImfo();
		setData();
	}
	
	private void setData() {
		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
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
	
	@Override
	public String getColumnName(int column) {
		return columnName[column];
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
	
}

public class ItemInfoJTable extends JFrame implements ActionListener, MouseListener{
	
	JButton select;
	JTable table;
	JPanel panel, btnPanel;
	JScrollPane scroll;
	ItemSystem itemSystem;
	
	public void mouseClicked(MouseEvent e) {
//		System.out.println("선택한 행, 열 : "+table.getSelectedRow()+","+table.getSelectedColumn());
//		int selectedRow = table.getSelectedRow();
//		for(int i = 0; i < 6; i++) {
//			System.out.println("선택한 행 : "+selectedRow+",전체정보 : "+table.getValueAt(selectedRow,i));
//		}
		//선택한 행과 열의 데이터를 ItemSystem으로 출력한다.
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getSelectedColumn();
		for(int i = 0; i < columnCount; i++) {
			itemSystem.text[0].setText(table.getValueAt(selectedRow, 0)+"");//상품번호
			itemSystem.text[1].setText(table.getValueAt(selectedRow, 1)+"");//상품이름
			itemSystem.text[2].setText(table.getValueAt(selectedRow, 2)+"");//상품가격
			itemSystem.textarea.setText(table.getValueAt(selectedRow, 3)+"");//상품정보
			String str = table.getValueAt(selectedRow, 4)+"";
			if(str.equals("korea")) {
				itemSystem.madeIn[0].setSelected(true);
			}else if(str.equals("other country")) {
				itemSystem.madeIn[1].setSelected(true);
			}
		}
		itemSystem.btn[0].setEnabled(false);//삽입 버튼 비활성화
	}
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void actionPerformed(ActionEvent e) {
		table.setModel(new ItemModel());
	}
	
	public ItemInfoJTable(String str, ItemSystem itemSystem) {
		super(str);
		this.itemSystem = itemSystem;
		select = new JButton("전체 조회");
		select.addActionListener(this);
		table = new JTable();
		table.addMouseListener(this);
		panel = new JPanel();
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600,300));//테이블 크기 변경
		panel.add(itemSystem); panel.add(scroll);
		this.add("Center",panel);
		btnPanel = new JPanel();
		btnPanel.add(select);
		this.add("South",btnPanel);
		this.setSize(650,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ItemSystem itemSystem = new ItemSystem();
		new ItemInfoJTable("상품 정보 전체 조회",itemSystem);
	}

}
