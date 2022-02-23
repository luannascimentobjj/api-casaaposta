async function connect(){

    if(global.connection && global.connection.state !== 'disconnected')
            return global.connection;
    
            const mysql = require('mysql2/promise');
    const connection = await mysql.createConnection("mysql://root:Xp3rtsBD2022@191.252.59.151:80/aposta");
    console.log("Conectou no Mysql");
    global.connection = connection;
    return connection;
}

connect();

module.exports = {}
