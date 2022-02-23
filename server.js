const express = require('express');
const cors = require('cors');
const app = express();
const db = require('./src/Conf/db');
require('./src/Routes/index')(app);
app.use(cors());
app.use(express.json());
app.listen(3000);

