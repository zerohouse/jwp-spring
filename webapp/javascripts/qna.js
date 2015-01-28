(function() {
	var currentPage;
	window.addEventListener('load', function() {
		var formList = document
				.querySelectorAll('.answerWrite input[type=submit]');
		for (var j = 0; j < formList.length; j++) {
			formList[j].addEventListener('click', writeAnswers, false);
		}
		addAnswerRemoveListener();
	});
	
	function addAnswerRemoveListener() {
		document.getElementById('comments').addEventListener('click',function(e) {
			e.preventDefault();
			if (e.target.nodeName !== 'A') {
				return;
			}
			var ids = e.target.id.split('_');
			var url = "/api/answer.next";
			var params = "questionId=" + ids[0] + "&answerId="
					+ ids[1];
	
			var request = new XMLHttpRequest();
			request.open("POST", url, true);
			request.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
	
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var responseObj = JSON.parse(request.responseText);
					var newAnswers = responseObj.answers;
					var answerIdMap = {};
					for(var answer in newAnswers) {
						answerIdMap[newAnswers[answer].answerId] = true;
					}
					var container = document.getElementById('comments');
					document.querySelector('#comments #numAnswers').innerHTML = '댓글 수 : ' + newAnswers.length;
					var currentAnswers = document.querySelectorAll('#comments .comment');
					for(var answer in currentAnswers) {
						if(!currentAnswers[answer].id) {
							continue;
						}
						var id = currentAnswers[answer].id.split("_")[1];
						console.log('currentId: ' + id);
						if(!answerIdMap[id]) {
							container.removeChild(currentAnswers[answer]);
						}
					}
				}
			}
			request.send(params);
		});

	}
	
	function writeAnswers(e) {
		e.preventDefault();

		var answerForm = e.currentTarget.form;
		var url = "/api/addanswer.next";
		var params = "questionId=" + answerForm[0].value + "&writer="
				+ answerForm[1].value + "&contents=" + answerForm[2].value;

		var request = new XMLHttpRequest();
		request.open("POST", url, true);
		request.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");

		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				location.reload(true);
			}
		}

		request.send(params);
	}
})();