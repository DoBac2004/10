package com.example.model;

import com.example.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomException extends Exception{
    public static final long serialVersionUID = 1L;
    public CustomException(String str) throws CustomException {
        super();
        System.out.println(str);
        ProductSystem.operations();

    }
}
public class ProductSystem {
    public static Map<Integer, Product> map = new HashMap<>();
    public static void addProduct(String name, int price, String Description, int productId) throws CustomException{
        Product product = new Product(name, price, Description,productId);
        map.put(productId, product);

        operations();
    }
    public static void deleteProduct(int productId) throws CustomException{
        if(map.containsKey(productId)){
            map.remove(productId);
            System.out.println("Successfully Delete !!");
        }else {
            throw new CustomException("Not Found");
        }
        operations();
    }
    public static void updateProduct(int productId, String name, int price, String Description) throws CustomException{
        if (map.containsKey(productId)) {
            Product product = map.get(productId);
            product.setName(name);
            product.setPrice(price);
            product.setDescription(Description);
            System.out.println("Successfully updated product with productId: " + productId);
        } else {
            throw new CustomException("Not Found");
        }

        operations();
    }


    public static void searchProduct(int productId) throws CustomException{
        if (map.containsKey(productId)) {
            System.out.println("Product Details: " + map.get(productId));
        } else {
            throw new CustomException("Not Found");
        }

        operations();
    }

    public static void productList() {
        System.out.println(map.toString());
    }

    public static void operations() throws CustomException {
        System.out.println("\n********** Product Management System **********");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Search Product");
        System.out.println("5. Product List");

        Scanner scanner = new Scanner(System.in);
        int keyInput = scanner.nextInt();

        if (keyInput == 1) {
            System.out.println("Enter Product Details(Name, Price, Describe, Id)");
            Scanner scanner1 = new Scanner(System.in);

            String name = scanner1.next();
            int price = scanner1.nextInt();
            String Description = scanner1.next();
            int productId = scanner1.nextInt();

            if (!name.equals("") && price != 0 && !Description.equals("") && productId != 0) {
                addProduct(name, price, Description, productId);
            }
        } else if (keyInput == 2) {
            System.out.println("Enter Product ID: ");
            Scanner scanner2 = new Scanner(System.in);
            int productId = scanner2.nextInt();

            System.out.println("Enter Product Details(Name, Price, Describe):");
            Scanner scanner3 = new Scanner(System.in);
            String name = scanner3.next();
            int price = scanner3.nextInt();
            String Description = scanner3.next();

            if (!name.equals("") && price != 0 && !Description.equals("") && productId != 0) {
                updateProduct(productId, name, price, Description);
            }
        } else if (keyInput == 3) {
            System.out.println("Enter Product ID: ");
            Scanner scanner3 = new Scanner(System.in);

            int productId = scanner3.nextInt();
            try {
                deleteProduct(productId);
            } catch (CustomException e) {

            }
        } else if (keyInput == 4) {
            System.out.println("Enter Product ID: ");
            Scanner scanner4 = new Scanner(System.in);

            int productId = scanner4.nextInt();
            try {
                searchProduct(productId);
            } catch (CustomException e) {

            }

            operations();
        } else if (keyInput == 5) {
            productList();

            operations();
        }
    }

    public static void main(String[] args) throws CustomException {
        operations();
    }
}
