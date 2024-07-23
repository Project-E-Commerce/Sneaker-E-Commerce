const express = require('express')
const app = express()
const path = require('path');
const port = 3000


app.use(express.static(path.join(__dirname, 'views')));
app.use(express.urlencoded({ extended: true }));


const loginRoutes = require('./routes/login');
const signupRoutes = require('./routes/signup');


app.use('/login', loginRoutes);
app.use('/signup', signupRoutes);



app.listen(port, () => console.log(`http://localhost: ${port}`))