var productControllers = angular.module('productControllers', []);

productControllers.controller('ProductListCtrl', function($scope, $http) {
	$http.get('learno/assessmentList').success(function(data) {
		$scope.assessments = data;
	});
});

productControllers.controller('ProductDetailCtrl', function($scope, $routeParams, $http) {
	var id = $routeParams.assessmentId;
	var createResults;
	$scope.result = {};
	$scope.answers = []; // user answers
    
	$http.get('learno/assessment/'+id).success(function(data) {
	      $scope.questions = data.questions;
	      $scope.result ={assessmentId: id, name: data.name, topic: data.topic, answers: []};
	      createResults();
	    
	});
	
	
	 // prepare array of result objects
    createResults = function () {
      var len = $scope.questions.length;
      for (var i = 0; i < len; i++) {
        $scope.result.answers.push({
          questionId:   $scope.questions[i].id,
          seq:			$scope.questions[i].seq,
          answer:     	$scope.questions[i].answer,
          subtopic:		$scope.questions[i].subtopic,
          userChoice: null,
          correct:    null
        });
      }
    };
 
    // assign and check user's choice
    $scope.checkUserChoice = function (question, userChoice, seq) {
      // assign the user's choice to userChoice
      $scope.result.answers[seq].userChoice = userChoice;
      // check the user's choice against the answer
      if ($scope.result.answers[seq].answer === userChoice) {
        $scope.result.answers[seq].correct = 'C';
      } else {
        $scope.result.answers[seq].correct = 'I';
      }
    };
 
    // only show results if all questions are answered
    $scope.checkQuizCompleted = function () {
      var len = $scope.result.answers.length;
      for (var i = 0; i < len; i++) {
        if ($scope.result.answers[i].userChoice === null) {
          return true;
        }
      }
      return false;
    };
	
    //save the data
	$scope.evaluate = function(result){
		$http.post('learno/evaluate', result).success(function(data){
			
		});
	};
	
});


productControllers.controller('ProductCreateCtrl', function($scope, $http, $window) {
	$scope.update = function(question){
		$http.post('learno/question', question).success(function(data){
			
		});
	};
	
});
