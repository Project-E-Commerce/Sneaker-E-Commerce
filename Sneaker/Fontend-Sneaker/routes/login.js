const express = require('express');
const path = require('path');
const router = express.Router();

router.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../views', 'login','login.html'));
});
router.post('/', (req, res) => {
    const { username, password } = req.body;
    
    res.send(`Logged in with username: ${username} and password: ${password}`);
});

module.exports = router;