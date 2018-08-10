var express = require('express');
var browserify= require('browserify-middleware');
var app = express();
var router = express.Router();

router.get("/js/solace.js", browserify(['solclientjs']));
router.get("/js/solace-pubsub.js", function(req,res){
  res.sendfile(__dirname + '/javascripts/solace-pubsub.js');
}); 

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Solace Sample Subscriber App' });
});

module.exports = router;
