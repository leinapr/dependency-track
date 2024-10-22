package org.dependencytrack.resources;

import org.dependencytrack.model.Product;
import org.dependencytrack.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    // Instance du service Product pour gérer la logique métier
    private final ProductService productService = new ProductService();

    /**
     * Endpoint POST pour créer un nouveau produit
     * @param product L'objet Product reçu en format JSON
     * @return Le produit créé, avec réponse HTTP 200 OK
     */
    @POST
    public Response createProduct(Product product) {
        Product newProduct = productService.createProduct(product.getName(), product.getCpeCode());
        return Response.ok(newProduct).build();
    }

    // Autres endpoints pour gérer les produits
}
