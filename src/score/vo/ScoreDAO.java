package score.vo;

import java.util.ArrayList;

//Data Access Object
public class ScoreDAO {
//	ArrayList: 학생정보객체(StudentVO)들을 저장하기 위해
	ArrayList<ScoreVO> svoList = new ArrayList<ScoreVO>();

//	insert: ArrayList에 학생정보객체(StudentVO)를 추가하는 메소드
	public void insert(ScoreVO svo) {
		svoList.add(svo);
	}
	
	public void delete(int row) {
		svoList.remove(row);
	}
	
//	select: 전체 학생정보객체들을 반환하는 메소드
	public ArrayList<ScoreVO> select(){
		return svoList;
	}
	
}
