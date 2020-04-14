const axios = require('axios')

axios
  .put('http://localhost:9200/familias', {
    "mappings":{
		"properties":{
			"id":{
				"type":"text"
			},
			"pessoas": {
				"properties": {
				  "id": {
					"type": "text"
				  },
				  "nome": {
					"type": "text"
				  },
				  "tipo":{
					"type": "text"
				  },
				  "dataDeNascimento":{
					"type": "text"
				  }
				}
			},
			"rendas": {
				"properties": {
				  "pessoaId": {
					"type": "text"
				  },
				  "valor": {
					"type": "text"
				  }
				}
			},
			"status":{
				"type": "text"
			}			
		}
	}
  })
  .then(res => {
    
  })
  .catch(error => {
    console.error(error)
  })