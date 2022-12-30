package score.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import score.view.ScoreView;
import score.vo.ScoreDAO;
import score.vo.ScoreVO;

public class ScoreController extends JFrame {
	ScoreDAO dao;
	ArrayList<ScoreVO> svoList;
	ScoreView view2;
	JTable table;
	
	public ScoreController() {
		dao = new ScoreDAO();
		view2 = new ScoreView();
		svoList = dao.select();
		view2.setScoreVOList(svoList);
		view2.initView();
		JButton btnAdd = view2.getBtnAdd();
		btnAdd.addActionListener(btnAddL);	
		table = view2.getTable();
		table.addMouseListener(tableL);
		add(view2, "Center");
		setTitle("성적관리시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreController();
	}

	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			neededInsertData(): panS에 있는 JTextField에 입력된 값들을
//			ScoreVO에 필드값들을 초기화하여 ScoreVO 객체 참조값을 반환하는 메소드
			ScoreVO vo = view2.neededInsertData();
			dao.insert(vo);
			svoList = dao.select();
			view2.setScoreVOList(svoList);
			view2.putResult();
			view2.initInsertData();
		}
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			if(e.getClickCount()==2) {
				state = JOptionPane.showConfirmDialog(ScoreController.this, "정말 삭제하시겠습니까?","삭제여부", JOptionPane.YES_NO_OPTION);
				if(state == JOptionPane.YES_OPTION) {
					dao.delete(table.getSelectedRow());
					svoList = dao.select();
					view2.setScoreVOList(svoList);
					view2.putResult();
				}
			}
		}
	};
}



