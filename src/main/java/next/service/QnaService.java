package next.service;

import next.ExistedAnotherUserException;
import next.ResourceNotFoundException;
import next.dao.QuestionDao;
import next.model.Question;

public class QnaService {
	private QuestionDao questionDao;

	public QnaService(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public void delete(final long questionId) throws ResourceNotFoundException, ExistedAnotherUserException {
		Question question = questionDao.findWithAnswersById(questionId);
		
		if (!question.canDelete()) {
			throw new ExistedAnotherUserException("다른 사용자가 추가한 댓글이 존재해 삭제할 수 없습니다.");
		}

		questionDao.delete(questionId);
	}
}
