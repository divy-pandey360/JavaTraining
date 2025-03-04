import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Product> datasetA = Arrays.asList(
                    new Product(1, "Laptop", "Electronics", 50000.0, 10, 0.05, "Supplier C"),
                    new Product(2, "Smartphone", "Electronics", 30000.0, 20, 0.6, null),
                    new Product(3, "Chair", "Furniture", 2000.0, 15, 0.03, null)
            );
            List<Product> datasetB = Arrays.asList(
                    new Product(2, "Smartphone", "Electronics", null, null, 10.0, "Supplier A"),
                    new Product(3, "Chair", "Furniture", null, null, 5.0, "Supplier B"),
                    new Product(4, "Table", "Furniture", null, null, 15.0, "Supplier C")
            );


            List<Product> mergedDataset = mergeDataSets(datasetA, datasetB);
            for (Product product : mergedDataset) {
                System.out.println("Product Id "+product.productId+" Product Name "+product.productName
                                   +" Category "+ product.category+" Discount "+product.discount+" Final Price: "+product.finalPrice+
                                    " Stock Quantity "+product.stockQuantity+" Supplier "+product.supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


    public static List<Product> mergeDataSets(List<Product> datasetA, List<Product> datasetB)  {
        Map<Integer, Product> productMap = new HashMap<>();
        Set<Integer> productsId = new HashSet<>();
        for (Product product : datasetA) {
//            if (productsId.contains(product.productId)) {
//                throw new DuplicateProductException("Product is already present");
//            }
            productsId.add(product.productId);
            productMap.put(product.productId, product);
        }

        for (Product product : datasetB) {
//            if (productsId.contains(product.productId)) {
//                throw new Product.DuplicateProductException("Product is already present");
//            }
            productsId.add(product.productId);
            Product existingProduct = productMap.get(product.productId);
            if (existingProduct != null) {
                existingProduct.discount = product.discount;
                existingProduct.supplier = product.supplier;
                if (existingProduct.price != null && product.discount != null) {
                    existingProduct.finalPrice = existingProduct.price - (existingProduct.price * product.discount / 100);
                }
            } else {
                productMap.put(product.productId, product);
            }
        }
        return new ArrayList<>(productMap.values());
    }
}
