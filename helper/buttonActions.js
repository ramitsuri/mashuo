var getButtonAction = function(id, callback){
  var action = '{"actionResponse":"you pressed button ' + id + '"}';
  callback(action);
};


  module.exports = {
    getButtonAction: getButtonAction,
  }
