
addEventListener("load", (event) => {
    
    const btnSubmit = document.querySelector('.submit.producto');
    const tableProducts = document.querySelector('.lista-productos');

    const url = "http://localhost:8080/api/v1/product/";

    // load products
    loadProducts();

    btnSubmit.addEventListener('click', e => {
        e.preventDefault()
      
        fetch(
          url + 'create', 
          {
            'method': "POST",
            'body': JSON.stringify(Object.fromEntries(new FormData(document.forms.createProduct))),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
              }
          }
        )
          .then(response => response.json())
          .then(response => {
            loadProducts();
          })
          .catch(err => console.error(err));
      });

      function loadProducts()
      {
        fetch(
            url + 'list'
          )
            .then(response => response.json())
            .then(response => {
                empty(tableProducts);
                
                // Headers
                let rowHeaders = tableProducts.insertRow();

                let thName = document.createElement("th");
                let textName = document.createTextNode("Nombre");
                thName.appendChild(textName);
                rowHeaders.appendChild(thName);

                let thPrecio = document.createElement("th");
                let textPrecio = document.createTextNode("Precio");
                thPrecio.appendChild(textPrecio);
                rowHeaders.appendChild(thPrecio);

                let thOpciones = document.createElement("th");
                rowHeaders.appendChild(thOpciones);

                // Rows
                for (let element of response) {
                    let row = tableProducts.insertRow();

                    createCell(row, element.productName);
                    createCell(row, element.productPrice);
                    createDeleteButton(row, element.productId);
                  }
                

            })
            .catch(err => console.error(err))
      }

      function createCell(row, textContent)
      {
        let cell = row.insertCell();
        let text = document.createTextNode(textContent);
        cell.appendChild(text);
      }

      function createDeleteButton(row, productId)
      {
        let cell = row.insertCell();
        let btn = document.createElement("button");
        let text = document.createTextNode("Eliminar producto");
        
        btn.appendChild(text);
        cell.appendChild(btn);

        btn.addEventListener('click', function(e)
        {
            fetch(
                url + 'delete/' + productId.toString(), 
                {
                  'method': "DELETE"
                }
              )
                .then(response => {
                  loadProducts();
                })
                .catch(err => console.error(err));
        });
      }
      
      function empty(element) {
        while(element.firstElementChild) {
           element.firstElementChild.remove();
        }
      }
});