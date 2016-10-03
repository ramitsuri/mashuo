
var getActivityLayout = function(callback){
  var layout = '[{"type":0, "text":"button1", "action":"http://52.39.204.2:1398/action/1"},{"type":0, "text":"button2", "action":"http://52.39.204.2:1398/action/2"},{"type":0, "text":"button3", "action":"http://52.39.204.2:1398/action/3"}]';

callback(layout);
};


  module.exports = {
    getActivityLayout: getActivityLayout,
  }
