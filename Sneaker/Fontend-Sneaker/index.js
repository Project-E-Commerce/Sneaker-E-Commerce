import express from 'express';
import { engine } from 'express-handlebars';

const express = require('express');
const app = express();
const path = require('path');
const port = 3000;
const bodyParser = require('body-parser');

app.use(express.static(path.join(__dirname, 'views')));
app.use(express.urlencoded({ extended: true }));
app.use(bodyParser.json());

const loginRoutes = require('./routes/login');
const signupRoutes = require('./routes/signup');

//template engine
app.engine('handlebars', engine());
app.set('view engine', 'handlebars');
app.set('views', './views');
app.get('/', (req, res) => {
    res.render('homepage/homepage');
});

app.use('/login', loginRoutes);
app.use('/signup', signupRoutes);



app.listen(port, () => console.log(`http://localhost:${port}`))