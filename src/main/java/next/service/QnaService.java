package next.service;

import next.ResourceNotFoundException;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Question;

public class QnaService {
	private QuestionDao questionDao;
	private AnswerDao answerDao;

	public QnaService(QuestionDao questionDao, AnswerDao answerDao) {
		this.questionDao = questionDao;
		this.answerDao = answerDao;
	}
	
	public void delete(final long questionId) throws ResourceNotFoundException {
		Question question = questionDao.findById(questionId);
		if (question == null) {
			throw new ResourceNotFoundException("존재하지 않는 질문입니다.");
		}
	}
}
