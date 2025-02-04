import express from 'express';
import { engine } from 'express-handlebars';
import { fileURLToPath } from 'url';
import {dirname, join} from 'path';
import bodyParser from 'body-parser';

const _filename = fileURLToPath(import.meta.url);
const _dirname = dirname(_filename);

const express = require('express');
const app = express();
const path = require('path');
const port = 3000;
const bodyParser = require('body-parser');

app.use(express.static(path.join(__dirname, 'views')));
app.use(express.urlencoded({ extended: true }));
app.use(bodyParser.json());

const adminLoginRoutes = require('./routes/adminLogin');
const userLoginRoutes = require('./routes/userLogin');
const signupRoutes = require('./routes/signup');

//template engine
app.engine('handlebars', engine({
    layoutsDir: join(_dirname, 'views/layouts'),
    defaultLayout: 'main',
    extname: 'handlebars.'
}));
app.set('view engine', 'handlebars');
app.set('views', './views');
app.get('/', (req, res) => {
    res.render('homepage/homepage');
    res.render('cart/cart');
});

app.use('/adminLogin', adminLoginRoutes);
app.use('/userLogin',userLoginRoutes);
app.use('/signup', signupRoutes);



app.listen(port, () => console.log(`http://localhost:${port}`))