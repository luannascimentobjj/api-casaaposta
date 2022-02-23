const CadastraMetodoController = require('../Controllers/CadastraMetodosController');

module.exports = (app) => {
   app.post('/cadastraMetodo', CadastraMetodoController.post);
   app.put('/cadastraMetodo/:id', CadastraMetodoController.put);
   app.delete('/cadastraMetodo/:id', CadastraMetodoController.delete);
   app.get('/cadastraMetodo', CadastraMetodoController.get);
   app.get('/cadastraMetodo/:id', CadastraMetodoController.getById);


}