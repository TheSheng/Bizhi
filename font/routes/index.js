var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});
router.get('/login', function(req, res, next) {
  res.render('login', { title: 'Express' });
});

router.get('/pinglun', function(req, res, next) {
  res.render('Pinglun', { title: 'Express' });
});
router.get('/charts', function(req, res, next) {
  res.render('charts', { title: 'Express' });
});
router.get('/member', function(req, res, next) {
  res.render('member', { title: 'Express' });
});
router.get('/zan', function(req, res, next) {
  res.render('zan', { title: 'Express' });
});
router.get('/update', function(req, res, next) {
  res.render('update', { title: 'Express' });
});
router.get('/pinglun', function(req, res, next) {
  res.render('pinglun', { title: 'Express' });
});
router.get('/gai', function(req, res, next) {
  res.render('gai', { title: 'Express' });
});
router.get('/loading', function(req, res, next) {
  res.render('loading', { title: 'Express' });
});
module.exports = router;
