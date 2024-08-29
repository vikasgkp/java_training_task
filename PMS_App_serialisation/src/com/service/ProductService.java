package com.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.bean.Product;

public class ProductService {
    private static final String FILE_NAME = "product.ser";
    private List<Product> listOfProducts;

    public ProductService() {
        listOfProducts = loadProducts();
    }

    public String addProduct(Product product) {
        int flag = 0;
        for (Product p : listOfProducts) {
            if (p.getPid() == product.getPid()) {
                flag++;
                break;
            }
        }
        if (flag == 0) {
            listOfProducts.add(product);
            saveProducts();
            return "Product added successfully";
        } else {
            return "Product ID must be unique";
        }
    }

    public List<Product> findAllProducts() {
        return listOfProducts;
    }

    public String deleteProduct(int pid) {
        Iterator<Product> iterator = listOfProducts.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getPid() == pid) {
                iterator.remove();
                saveProducts();
                return "Product deleted successfully";
            }
        }
        return "Product not present";
    }

    public String updateProduct(Product product) {
        for (Product p : listOfProducts) {
            if (p.getPid() == product.getPid()) {
                p.setPrice(product.getPrice());
                saveProducts();
                return "Product price updated successfully";
            }
        }
        return "Product not present";
    }

    private void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(listOfProducts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Product> loadProducts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<Product>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}