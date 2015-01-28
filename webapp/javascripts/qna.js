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
			
			var ids = e.target.getAttribute("data-ids").split('_');
			var url = "/api/questions/" + ids[0] + "/answers/" + ids[1];
	
			var request = new XMLHttpRequest();
			request.open("DELETE", url, true);
			request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = JSON.parse(request.responseText);
					if (result.status) {
						location.reload(true);
					}
				}
			}
			request.send();
		});

	}
	
	function writeAnswers(e) {
		e.preventDefault();

		var answerForm = e.currentTarget.form;
		var url = "/api/questions/" + answerForm[0].value + "/answers";
		var params = "writer=" + answerForm[1].value + "&contents=" + answerForm[2].value;

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