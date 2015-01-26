package next.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import next.model.Answer;

public class MockAnswerDao implements AnswerDao {
	private Map<Long, Answer> answers = new HashMap<Long, Answer>();
	
	@Override
	public void insert(Answer answer) {
		answers.put(answer.getAnswerId(), answer);
	}

	@Override
	public List<Answer> findAllByQuestionId(long questionId) {
		Collection<Answer> values = answers.values();
		List<Answer> answers = new ArrayList<Answer>();
		for (Answer answer : values) {
			if (questionId == answer.getQuestionId()) {
				answers.add(answer);
			}
		}
		return answers;
	}

}
