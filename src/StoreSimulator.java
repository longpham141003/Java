import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name= name;
        this.price= price;
        this.stock= stock;
    }

    @Override
    public String toString(){
        return id + ". " + name + " - Gia: " + price + " - Ton kho: " + stock;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.name + " x" + quantity + " - Gia: " + (product.price * quantity);
    }
}

public class StoreSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"Tao",5,10));
        products.add(new Product(2,"Chuoi",6,12));
        products.add(new Product(3,"Cam",7,14));
        products.add(new Product(4,"Nho",8,16));
        products.add(new Product(5,"Oi",9,18));

        double totalRevenue = 0;
        boolean loop = true;
        while(loop) {
            System.out.println("\n------STORE HIEU-------");
            System.out.println("Dang nhap voi vai tro(admin/user) hoac exit de thoat: ");
            String role = sc.nextLine().trim();

            if (role.equalsIgnoreCase("exit")) {
                System.out.println("Thoat chuong trinh...");
                break;
            }
            if (role.equalsIgnoreCase("admin")) {
                boolean adminLoop = true;
                do {
                    System.out.println("\n--- Menu Admin ---");
                    System.out.println("1. Xem sản phẩm");
                    System.out.println("2. Thêm sản phẩm");
                    System.out.println("3. Xóa sản phẩm");
                    System.out.println("4. Sửa sản phẩm");
                    System.out.println("5. Xem doanh thu");
                    System.out.println("6. Logout");
                    System.out.print("Chọn chức năng: ");

                    int choice;
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e){
                        System.out.println("Lua chon khong hop le! Vui long chon lai...");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("\n--- Danh sach san pham ---");
                            for(Product p: products){
                                System.out.println(p);
                            }
                            break;

                        case 2:
                            System.out.println("Ten san pham: ");
                            String name = sc.nextLine();
                            System.out.println("Gias: ");
                            double price = Double.parseDouble(sc.nextLine());
                            System.out.println("Ton kho: ");
                            int stock = Integer.parseInt(sc.nextLine());

                            boolean trungten = false;
                            for( Product p: products ){
                                if(p.name.equalsIgnoreCase(name)) {
                                    p.stock += stock;
                                    System.out.println("San pham da ton tai. Cap nhap san pham trong kho");
                                }
                            }
                            if (!trungten) {
                                int newId = products.size() + 1;
                                products.add(new Product(newId,name,price,stock));
                                System.out.println("Them san pham moi thanh cong");
                            }
                            break;

                        case 3:
                            System.out.println("Nhap ID san pham can xoa: ");
                            int deletedId = Integer.parseInt(sc.nextLine());
                            boolean xoaSp = false;
                            for( int i=0; i<products.size(); i++ ) {
                                if(products.get(i).id == deletedId) {
                                    products.remove(i);
                                    System.out.println("Xoa san pham thanh cong!");
                                    xoaSp = true;
                                    break;
                                }
                            }
                            if (!xoaSp) {
                                System.out.println("Khong tim thay san pham...");
                            }
                            break;

                        case 4:
                            System.out.print("Nhập ID sản phẩm cần sửa: ");
                            int editId = Integer.parseInt(sc.nextLine());
                            Product editProduct = null;
                            for(Product p: products){
                                if(p.id == editId){
                                    editProduct = p;
                                    break;
                                }
                            }
                            if(editProduct==null){
                                System.out.println("Không tìm thấy sản phẩm!");
                                break;
                            }
                            System.out.print("Tên mới (" + editProduct.name + "): ");
                            String newName = sc.nextLine();
                            System.out.print("Giá mới (" + editProduct.price + "): ");
                            double newPrice = Double.parseDouble(sc.nextLine());
                            System.out.print("Tồn kho mới (" + editProduct.stock + "): ");
                            int newStock = Integer.parseInt(sc.nextLine());

                            editProduct.name = newName.isEmpty()? editProduct.name : newName;
                            editProduct.price = newPrice>0 ? newPrice : editProduct.price;
                            editProduct.stock = newStock>0 ? newStock : editProduct.stock;

                            System.out.println("Cap nhap san pham thanh cong");
                            break;

                        case 5:
                            System.out.println("Tong doanh thu: " + totalRevenue);
                            break;

                        case 6:
                            System.out.println("Dang xuat Admin");
                            adminLoop = false;
                            break;

                        default:
                            System.out.println("Lua chon khong hop le...");
                    }
                } while (adminLoop);
            } else if(role.equalsIgnoreCase("user")) {
                ArrayList<CartItem> cart = new ArrayList<>();
                boolean userLoop = true;
                do{
                    System.out.println("\n--- Menu User ---");
                    System.out.println("1. Xem sản phẩm");
                    System.out.println("2. Thêm vào giỏ hàng");
                    System.out.println("3. Xem giỏ hàng");
                    System.out.println("4. Thanh toán");
                    System.out.println("5. Logout");
                    System.out.print("Chọn chức năng: ");

                    int choice;
                    try{
                       choice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Lua chon khong hop le! Vui long chon lai...");
                        continue;
                    }

                    switch(choice){
                        case 1:
                            System.out.println("\n   Danh sachs san pham  ");
                            for( Product p: products ) {
                                System.out.println(p);
                            }
                            break;

                        case 2:
                            System.out.println("nhap Id sp muon mua: ");
                            int productId;
                            try{
                                productId = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("Id khong hop le hoac san pham khong ton tai");
                                continue;
                            }

                            Product selected = null;
                            for (Product p: products){
                                if(p.id == productId){
                                    selected = p;
                                    break;
                                }
                            }
                            if (selected == null) {
                                System.out.println("Khong tim thay san pham");
                                break;
                            }

                            System.out.println("Nhap so luong: ");
                            int quantity;
                            try{
                                quantity = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                System.out.println("So luong khong hop le...");
                                continue;
                            }

                            if( quantity <=0 || quantity > selected.stock ){
                                System.out.println("So luong khong hop le hoac vuot qua so luong ton kho...");
                                break;
                            }

                            cart.add(new CartItem(selected, quantity));
                            selected.stock -= quantity;
                            System.out.println("them san pham vao gio hang thanh cong");
                            break;

                        case 3:
                            if(cart.isEmpty()) {
                                System.out.println("Gio hang trong!");
                            } else {
                                System.out.println("  gio hang  ");
                                for( int i=0 ; i < cart.size(); i++ ){
                                    System.out.println((i+1) + ". " + cart.get(i));
                                }
                            }
                            break;

                        case 4:
                            if(cart.isEmpty()){
                                System.out.println("Giỏ hàng trống!");
                                break;
                            }
                            double total = 0;
                            for(CartItem item: cart){
                                total += item.product.price * item.quantity;
                            }

                            boolean discount10 = total > 1000;
                            boolean discount5 = cart.size() >=3;
                            if(discount10 && discount5){
                                total *= 0.85;
                                System.out.println("giam 15 phan tram");
                            } else if(discount10 || discount5){
                                total *= 0.9;
                                System.out.println("giam 10 phan tram");
                            }

                            System.out.println("Tổng thanh toán: " + total);
                            totalRevenue += total;
                            cart.clear();
                            break;

                        case 5:
                            System.out.println("dang xuat nguoi dung");
                            userLoop = false;
                            break;

                        default:
                            System.out.println("lua chon khong hop le...");
                    }
                } while (userLoop);
            } else {
                System.out.println("Vai tro khong hop le, nhap admin or user");
            }
        }
        sc.close();
    }
}

