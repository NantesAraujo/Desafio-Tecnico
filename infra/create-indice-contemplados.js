const axios = require('axios')

axios
  .put('http://localhost:9200/contemplados', {
    "mappings":{
		"properties":{
			"id":{
				"type":"text"
			}			
		}
	}
  })
  .then(res => {
    
  })
  .catch(error => {
    console.error(error)
  })