var express = require('express');

var helper = require('../helper/buttonActions.js');
var router = express.Router();

router.get('/:id', function(request, response){
  var id = request.params.id;
  helper.getButtonAction(id, function(action){
    response.send(action);
  });
});

module.exports = router;
