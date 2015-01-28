package next.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import next.model.Question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class QuestionDaoTest {
	@Autowired
	private QuestionDao dut;

	@Test
	public void crud() throws Exception {
		Question expected = new Question("자바지기", "title", "contents");
		dut.insert(expected);

		List<Question> questions = dut.findAll();
		assertTrue(questions.size() > 0);
	}
}
