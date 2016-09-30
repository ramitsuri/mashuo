var express = require('express');

var helper = require('../helper/activity.js');
var router = express.Router();

router.get('/', function(request, response){
  helper.getActivityLayout(function(layout){
    response.send(layout);
  });
});

module.exports = router;
