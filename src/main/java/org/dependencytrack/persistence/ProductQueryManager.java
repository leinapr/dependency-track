package org.dependencytrack.persistence;

import alpine.persistence.AlpineQueryManager;
import org.dependencytrack.model.Product;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProductQueryManager extends AlpineQueryManager {

    /**
     * Crée un nouveau produit et le persiste dans la base de données
     * @param name Le nom du produit
     * @param cpeCode Le code CPE unique du produit
     * @return Le produit créé et persisté
     */
    public Product createProduct(String name, String cpeCode) {
        Product product = new Product();
        product.setName(name);
        product.setCpeCode(cpeCode);
        getEntityManager().persist(product);
        return product;
    }

    /**
     * Récupère un produit par son ID
     * @param id L'identifiant unique du produit
     * @return Le produit trouvé ou null s'il n'existe pas
     */
    public Product getProductById(Long id) {
        return getEntityManager().find(Product.class, id);
    }

    /**
     * Récupère tous les produits de la base de données
     * @return Liste de tous les produits
     */
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = getEntityManager().createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    /**
     * Met à jour les informations d'un produit dans la base de données
     * @param product Le produit à mettre à jour
     * @return Le produit mis à jour
     */
    public Product updateProduct(Product product) {
        return getEntityManager().merge(product);
    }

    /**
     * Supprime un produit de la base de données
     * @param product Le produit à supprimer
     */
    public void deleteProduct(Product product) {
        Product managedProduct = getEntityManager().find(Product.class, product.getId());
        if (managedProduct != null) {
            getEntityManager().remove(managedProduct);
        }
    }

    /**
     * Supprime un produit de la base de données par son ID
     * @param id L'ID du produit à supprimer
     */
    public void deleteProductById(Long id) {
        Product product = getProductById(id);
        if (product != null) {
            getEntityManager().remove(product);
        }
    }
}
