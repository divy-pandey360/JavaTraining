import java.util.*;

public class Product {
    Integer productId;
    String productName;
    String category;
    Double price;
    Integer stockQuantity;
    Double discount;
    String supplier;
    Double finalPrice;

    void dataValidator() throws IncorrectDataTypeException{

        if (!(this.productId instanceof Integer) || !(this.price == null || this.price instanceof Double) ||
                !(this.stockQuantity == null || this.stockQuantity instanceof Integer) ||
                !(this.discount == null || this.discount instanceof Double)) {
            throw new IncorrectDataTypeException("Data type mismatch");
        }
    }


    public Product(Integer productId,String productName,String category,Double price,
                              Integer stockQuantity, Double discount,String supplier) throws InvalidDataException, IncorrectDataTypeException {
//        if(!(this.productId instanceof Integer) || this.productId==null){
//            throw new InvalidDataException("Missing  ProductId");
//        }
//
//        if(this.productName==null || this.category==null){
//            throw new InvalidDataException("Product Name and Product ID is required");
//        }
        //dataValidator();
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.price=price;
        this.stockQuantity=stockQuantity;
        this.discount=discount;
        this.supplier=supplier;
        if (price != null && discount != null) {
            this.finalPrice = price - (price * discount / 100);
        }
    }


    public List<Product> mergeDataSets(List<Product> datasetA,List<Product> datasetB) throws DuplicateProductException{
        Map<Integer,Product> productMap=new HashMap<>();
        Set<Integer> productsId=new HashSet<>();
        for(Product product:datasetA){
            if(productsId.contains(product.productId)){
                throw new DuplicateProductException("Product is already present");
            }
            productsId.add(product.productId);
            productMap.put(product.productId, product);
        }

        for(Product product:datasetB){
            if(productsId.contains(product.productId)){
                throw new DuplicateProductException("Product is already present");
            }
            productsId.add(product.productId);
            Product existingProduct=productMap.get(product.productId);
            if(existingProduct!=null){
                existingProduct.discount=product.discount;
                existingProduct.supplier=product.supplier;
                existingProduct.finalPrice=existingProduct.price - (existingProduct.price * product.discount / 100);
            }
            else {
                productMap.put(product.productId, product);
            }
        }
        List<Product> mergedDataset = new ArrayList<>(productMap.values());
        return mergedDataset;
    }

    class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }

    class IncorrectDataTypeException extends Exception {
        public IncorrectDataTypeException(String message) {
            super(message);
        }
    }

    class DuplicateProductException extends Exception {
        public DuplicateProductException(String message) {
            super(message);
        }
    }

}
