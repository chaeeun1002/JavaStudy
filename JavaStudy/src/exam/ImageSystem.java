package exam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;


class ImagePanel extends Panel{
	Image image;
	void setImage(String path) {
		image = Toolkit.getDefaultToolkit().getImage(path);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		if(image != null) {
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
}

class LoadActionListener implements ActionListener{//이미지 로드 버튼을 클릭했을 때 이벤트를 처리해주는 클래스
	//이미지 로드 버튼을 클릭한 경우 actionPerformed가 자동호출 된다.
	//이미지 파일의 경로를 ImageSystem에서 불러온다.
	//위의 파일의 경로에 있는 이미지를 불러와서 ImagePanel에 출력한다.
	//그리고, ImagePanel을 다시 그린다.
	
	ImageSystem is; ImagePanel ip;
	FileDialog fileDialog;//파일 다이얼로그 호출
	TotalSystem ts;
	
	static String fileName;
	
	static BufferedInputStream bis;
	LoadActionListener(ImageSystem is, ImagePanel ip, TotalSystem ts){
		this.is = is;
		this.ip = ip;
		this.ts = ts;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(ts,"이미지 파일 열기",FileDialog.LOAD);
		//파일다이얼로그가 동작되는 윈도우/다이얼로그 이름/다이얼로그 역할(LOAD=파일 불러오기)
		fileDialog.setVisible(true);
		fileName = fileDialog.getFile();
		String path = fileDialog.getDirectory()+fileDialog.getFile();
		//파일 다이얼로그에서 선택한 파일의 경로와 파일명이 path에 저장된다.
		is.text.setText(path);//파일의 경로와 파일명을 TextField에 출력.
		ip.setImage(path);//이미지 패널에 이미지 경로를 설정한 후, 
		ip.repaint();//이미지 패널을 다시 그린다.
		try {
			bis = new BufferedInputStream(new FileInputStream(path));
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(is, "이미지 파일을 로드할 수 없습니다.");
		}
	}
	
}

class SaveActionListener implements ActionListener{//이미지 저장 버튼을 클릭했을 때 이벤트를 처리해주는 클래스
	
	FileDialog fileDialog;
	ImageSystem is;
	BufferedOutputStream bos;//파일처리에 사용하는 객체
	TotalSystem ts;
	
	//BufferedOutputStream 이란? -> 자바 세상에는 객체(클래스)만 존재, 파일도 객체, A파일과 B파일이 있다고 가정하고,
	//A파일을 B파일에 저장하는 처리과정(stream) 또한 객체(클래스)가 됨,
	//A -> B A파일에서 파일이 B파일로 저장하기 위해 나갈 경우 OutputStream
	//B <- A B파일에서 A파일로부터 온 파일을 받는 경우 InputStream
	//즉, 파일을 처리할 때에는 OutputStream/InputStream이 붙어있는 클래스를 사용해야 한다.
	
	//Buffered란, 위의 Stream기능(메서드) + 알파를 가지고 있는 객체.(전용 메모리 = 버퍼) 
	//--> 파일 처리를 하는 데에 전용의 메모리를 사용해서 효율적으로 파일 처리를 함.(확장클래스)
	
	SaveActionListener(ImageSystem is, TotalSystem ts){
		this.is = is;
		this.ts = ts;
	}
	
	static String path;
	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(ts,"이미지 파일 저장",FileDialog.SAVE);
		//파일다이얼로그가 동작되는 윈도우/다이얼로그 이름/다이얼로그 역할(SAVE=파일 저장하기)
		fileDialog.setFile(LoadActionListener.fileName);//static변수로 선언했기 때문에 클래스이름.변수이름
		fileDialog.setVisible(true);
		path = fileDialog.getDirectory()+fileDialog.getFile();
		is.text.setText(path);
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			int data = 0;//4바이트 설정
			while((data = LoadActionListener.bis.read()) != -1) {
				bos.write(data);
			}//이미지 파일을 불러와서 새로운 파일에 저장한다.
		}catch(Exception ex){
			JOptionPane.showMessageDialog(is, "이미지 파일 저장에 실패 하였습니다.");
		}finally {
			//사용한 모든 stream을 닫는다.
			try {
				bos.close();
				LoadActionListener.bis.close();
			}catch(Exception exe) {}
		}
	}
	
}

public class ImageSystem extends Panel {
	
	Button load,save;
	TextField text;
	Panel southPanel;//버튼을 넣을 패널
	ImagePanel imagePanel;//이미지 패널
	
	TotalSystem ts;
	
	public ImageSystem(TotalSystem ts) {
//		super(str);
		this.setLayout(new BorderLayout());

		imagePanel = new ImagePanel();
		
		load = new Button("이미지 로드");
		load.addActionListener(new LoadActionListener(this, imagePanel, ts));
		
		save = new Button("이미지 저장");
		save.addActionListener(new SaveActionListener(this, ts));
		
		text = new TextField(40);
		
		southPanel = new Panel();
		southPanel.setBackground(Color.MAGENTA);
		southPanel.add(text);
		southPanel.add(load);
		southPanel.add(save);

		this.add("South",southPanel);
		this.add("Center",imagePanel);
		
//		this.addWindowListener(new LoginSystemExit());
//		this.setSize(600,400);
//		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new ImageSystem("이미지 시스템");
//	}

}
