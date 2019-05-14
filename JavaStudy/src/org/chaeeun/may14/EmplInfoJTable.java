package org.chaeeun.may14;

import java.awt.Dimension;
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

class EmpModel extends AbstractTableModel{
	
	private Object[][] tableData;//DB조회 결과가 저장될 배열
	private int cols,rows;//열의 갯수와 행의 갯수가 저장될 변수
	private String[] columnName = {"사원번호","사원이름","사원부서","성별","사원주소","입사일"};//열의 제목
	private List<EmpInfo> list;
	
	EmpModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.SelectEmpInfo();
		setData();
	}
	
	private void setData() {
		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		int r = 0;
		while(it.hasNext()) {
			EmpInfo info = (EmpInfo)it.next();
			tableData[r][0] = info.getEmp_id();
			tableData[r][1] = info.getEmp_name();
			tableData[r][2] = info.getEmp_dpt();
			tableData[r][3] = info.getEmp_gen();
			tableData[r][4] = info.getEmp_addr();
			tableData[r][5] = info.getEmp_date();
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

public class EmplInfoJTable extends JFrame implements ActionListener{
	
	JButton select;
	JTable table;
	JPanel centerPanel,southPanel;
	JScrollPane scroll;
	public void actionPerformed(ActionEvent e) {
		table.setModel(new EmpModel());
	}
	public EmplInfoJTable(String str) {
		super(str);
		select = new JButton("전체 조회");
		select.addActionListener(this);
		table = new JTable();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600,400));//테이블 크기 변경
		centerPanel.add(scroll);
		southPanel.add(select);
		this.add("Center",centerPanel);                   
		this.add("South",southPanel);
		this.setSize(650,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new EmplInfoJTable("사원 정보 전체 조회");
	}

}
