var express = require('express');

var activityRoutes = require('./routes/activity.js');
var buttonActionRoutes = require('./routes/buttonActions.js');
var app = express();
var port = 1398;
app.use('/activity', activityRoutes);
app.use('/actions', buttonActionRoutes);

app.listen(port);
console.log("starting on port: " + port);
