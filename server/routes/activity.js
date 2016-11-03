var express = require('express');
var bodyParser = require('body-parser');
var helper = require('../helper/activity.js');
var router = express.Router();
router.use(bodyParser.json());

router.get('/:id', function (request, response) {
    var id = request.params.id;
  helper.getActivityLayout(id, function(layout){
    response.send(layout);
  });
});

router.post('/', function (request, response) {
    var layout = request.body;
    helper.addActivityLayout(layout, function (id) {
        response.send("layout id is:" + id);
    });
});


module.exports = router;
