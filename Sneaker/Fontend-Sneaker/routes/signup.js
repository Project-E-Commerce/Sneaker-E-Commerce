const express = require('express');
const path = require('path');
const router = express.Router();

router.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../views','signup', 'signup.html'));
});

router.post('/', (req, res) => {
    const { username, password } = req.body;
    res.send(`Signed up with username: ${username} and password: ${password}`);
});
module.exports = router;