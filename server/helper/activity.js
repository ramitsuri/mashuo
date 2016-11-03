var id = 0;
var layouts = [];
var getActivityLayout = function(id, callback){
  var layout = layouts[id];

callback(layout);
};
var addActivityLayout = function (layout, callback) {
    layouts[id] = layout;
    id = id + 1;
    callback(id - 1);
};


module.exports = {
    addActivityLayout: addActivityLayout,
    getActivityLayout: getActivityLayout
  }
