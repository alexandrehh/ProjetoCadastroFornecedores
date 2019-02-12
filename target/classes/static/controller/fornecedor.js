angular.module('AppModule', ['ui.mask'])
.controller('AppControl', function($scope, $http) {	
	
	var urlFornecedor = "http://localhost:8082/fornecedor"	
		
    $scope.novoFornecedor = {id: '', name: '', email: '', comment: '', cnpj: ''};    
	
	
    $http.get(urlFornecedor + '/todos').then(function(response) {
        $scope.fornecedores = response.data;
    });
    
    
    $scope.inserir = function (existe) {
        $scope.erroUsuarioExiste = false;
        if (existe){
            $http.put(urlFornecedor, $scope.fornecedor).then(function (responsePost) {
                $http.get(urlFornecedor + '/todos').then(function (responseGet) {
                    $scope.fornecedores = responseGet.data;
                });
            });
        }
        else {
            $http.post(urlFornecedor, $scope.novoFornecedor).then(function (responsePost) {
                $http.get(urlFornecedor + '/todos').then(function (responseGet) {
                    $scope.fornecedores = responseGet.data;
                });
            });
        }
    }
    
   
    $scope.limpaDados = function () {
        $scope.erroUsuarioExiste = false;
        $scope.novoFornecedor = {id: '', name: '', email: '', comment: '', cnpj: ''};
    }
    
   
    $scope.editar = function(fornecedor){
    	
    	$scope.fornecedor = angular.copy(fornecedor);
    }
    
   
    $scope.delete = function(id) {
    	
    	$scope.erroUsuarioExiste = false;
        $http.delete(urlFornecedor + "/" + id).then(function (){
        		
        		$http.get(urlFornecedor + "/todos").then(function (responseGet) {
                    $scope.fornecedores = responseGet.data;
                });       
        
        });
    }
    
   
}).directive('onlyDigits', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
})
