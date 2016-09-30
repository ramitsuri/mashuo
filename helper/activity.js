
var getActivityLayout = function(callback){
  var layout = '{"layout":[{"button":{"name":"button1", "action":""}},{"button":{"name":"button1", "action":""}},{"button":{"name":"button1", "action":""}},{"button":{"name":"button1", "action":""}}]}';

callback(layout);
};


  module.exports = {
    getActivityLayout: getActivityLayout,
  }
