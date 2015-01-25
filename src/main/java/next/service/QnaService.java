package next.service;

import next.dao.AnswerDao;
import next.dao.QuestionDao;

public class QnaService {
	private QuestionDao questionDao;
	private AnswerDao answerDao;

	public QnaService(QuestionDao questionDao, AnswerDao answerDao) {
		this.questionDao = questionDao;
		this.answerDao = answerDao;
	}
	
	public void delete(final long questionId) {
		
	}
}
