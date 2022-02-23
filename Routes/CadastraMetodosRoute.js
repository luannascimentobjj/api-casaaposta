const CadastraMetodoController = require('../Controllers/CadastraMetodosController');
module.exports = (app) => {
   app.post('/cadastraMetodo', UsuarioController.post);
   app.put('/cadastraMetodo/:id', UsuarioController.put);
   app.delete('/cadastraMetodo/:id', UsuarioController.delete);
   app.get('/cadastraMetodo', UsuarioController.get);
   app.get('/cadastraMetodo/:id', UsuarioController.getById);
}