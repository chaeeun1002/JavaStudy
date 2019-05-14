package org.chaeeun.may14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class CustomerModel extends AbstractTableModel{
	
	private Object[][] tableData;//DB조회 결과가 저장될 배열
	private int cols,rows;//열의 갯수와 행의 갯수가 저장될 변수
	private String[] columnName = {"고객번호","고객이름","고객주소","가입일"};//열의 제목
	//컬렉션 프레임워크의 리스트 객체 선언
	private List<Customer_info> list;//util.list를 import
	
	CustomerModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.SelectCusInfo();//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData();
	}
	
	private void setData() {
		//list에 있는 조회결과를 2차원 배열(tableData)에 넣는다.
		//컬렉션 프레임워크에 저장된 데이터를 검색하는 방법 -> Iterator
		Iterator it = list.iterator();
		rows = list.size();//데이터의 갯수를 rows에 저장.(행의갯수)
		cols = columnName.length;//제목의 갯수를 저장.(열의 갯수)
		tableData = new Object[rows][cols];//배열생성
		int r = 0;
		while(it.hasNext()) {
			Customer_info cs = (Customer_info)it.next();//조회결과를 가져옴.
			tableData[r][0] = cs.getId();//고객번호
			tableData[r][1] = cs.getName();//고객이름
			tableData[r][2] = cs.getAddr();//고객주소
			tableData[r][3] = cs.getJoin_date();//가입일
			r++;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	//콜백메서드 : 이벤트가 발생하면 자동으로 호출되는 메서드.(JTable로부터 호출됨)
	public int getRowCount() {//행의 갯수
		return rows;
	}

	public int getColumnCount() {//열의 갯수
		return cols;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}
	
}

public class CustomerInfoJTable extends JFrame implements ActionListener{
	
	JButton select;
	JTable table;
	JPanel centerPanel,southPanel;
	JScrollPane scroll;
	
	public void actionPerformed(ActionEvent e) {
		table.setModel(new CustomerModel());
		//테이블이 사용하는 모델을 CustomerModel로 설정한다.
	}
	
	public CustomerInfoJTable(String str) {
		super(str);
		select = new JButton("전체 조회");
		select.addActionListener(this);
		table = new JTable();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);
		southPanel.add(select);
		this.add("Center",centerPanel);
		this.add("South",southPanel);
		this.setSize(600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CustomerInfoJTable("고객 정보 전체 조회");
	}

}
