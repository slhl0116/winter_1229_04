package score.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import score.vo.ScoreVO;

public class ScoreView extends JPanel{
	JTable table;
	DefaultTableModel model;
	ArrayList<ScoreVO> svoList;
	String[] header = {"학번", "성명", "학년", "반", "국어", "영어", "수학", "과학", "총점", "평균"};
	JPanel panS;
	JLabel[] lbls = new JLabel[header.length-2];
	JTextField[] tf = new JTextField[header.length-2];
	JButton btnAdd = new JButton("성적추가");
	
	public ScoreView() {
		setLayout(new BorderLayout());		
		panS = new JPanel();
		panS.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < lbls.length; i++) {
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);
			tf[i] = new JTextField();
			panS.add(tf[i]);
		}
		
		for (int i = 0; i < 3; i++) {
			panS.add(new JLabel("  "));
		}
		panS.add(btnAdd);
	}
//	initView(): JTable 관련 메소드
	public void initView() {
		model = new DefaultTableModel(header, svoList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();		
		
		add("Center", scroll);
		add("South", panS);
	}
	
//	DefaultTableModel에 성적정보들을 설정한다.
	public void putResult() {
//		★ modeldml 행 개수 설정
		model.setRowCount(svoList.size());
		ScoreVO vo = null;
		for (int i = 0; i < svoList.size(); i++) {
			vo = svoList.get(i);
//			i:행번호 0:열번호
			model.setValueAt(vo.getStuId(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getGrade(), i, 2);
			model.setValueAt(vo.getClassNum(), i, 3);
			model.setValueAt(vo.getKor(), i, 4);
			model.setValueAt(vo.getEng(), i, 5);
			model.setValueAt(vo.getMath(), i, 6);
			model.setValueAt(vo.getScience(), i, 7);
			model.setValueAt(vo.getTotal(), i, 8);
			model.setValueAt(String.format("%.2f", vo.getAvg()), i, 9);
		}
	}
	
	
	public void setScoreVOList(ArrayList<ScoreVO> svoList) {
		this.svoList = svoList;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public ScoreVO neededInsertData() {
		ScoreVO vo = new ScoreVO();
		vo.setStuId(Integer.parseInt(tf[0].getText()));
		vo.setName(tf[1].getText());
		vo.setGrade(Integer.parseInt(tf[2].getText()));
		vo.setClassNum(Integer.parseInt(tf[3].getText()));
		vo.setKor(Integer.parseInt(tf[4].getText()));
		vo.setEng(Integer.parseInt(tf[5].getText()));
		vo.setMath(Integer.parseInt(tf[6].getText()));
		vo.setScience(Integer.parseInt(tf[7].getText()));	
		vo.setTotal();
		vo.setAvg();
		return vo;
	}
	
	public void initInsertData() {
		for (int i = 0; i < tf.length; i++) {
			tf[i].setText("");
		}
	}
	
	public JTable getTable() {
		return table;
	}
	
}





