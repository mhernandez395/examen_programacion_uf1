/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.productmanager.model;

/**
 *
 * @author alumne
 */
public interface StoreInterface {

    //Methods
    /**
     * Adds a given product to the array of products if there
     * is enough space left and returns 0. If it fails returns -1.
     * It prevents from repeated codes.
     * @param p
     * @return 0 if successfully added, -1 otherwise
     */
    int add(Product p);

    /**
     * Finds a product in the array
     * @param product product to find
     * @return the product searched or null if it doesn't exist
     */
    Product find(Product product);

    /**
     * Find a product by code
     * @param code the code of the product searched for in the list
     * @return a product with the given code or null if it not exists
     */
    Product findByCode(String code);

    /**
     * Find products with the given name.
     * @param name the name to search
     * @return an object store containing all the products with
     *         the given name or an empty store if not found.
     */
    Store findByName(String name);

    int getNumElements();

    public Product get(int i);

    public Product[] getProducts();
    
}
